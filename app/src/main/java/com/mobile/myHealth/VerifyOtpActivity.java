package com.mobile.myHealth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.mobile.myHealth.Network.ApiClient;
import com.mobile.myHealth.Network.ApiInterface;
import com.mobile.myHealth.Network.MessageResponse;
import com.mobile.myHealth.Utility.GenericTextWatcher;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyOtpActivity extends AppCompatActivity {

private EditText mEnter_otp;
private Button mVerify;
private TextView mResend;
private String mOtpAuto;
private LottieAnimationView mProgressBar;
private static final int REQ_USER_CONSENT = 200;
SmsBroadcastReceiver smsBroadcastReceiver;
private TextView mCountdown;
private String mPhone;
private String mId1;
private Button mVerify1;
EditText otp_textbox_one, otp_textbox_two, otp_textbox_three, otp_textbox_four;
private EditText[] mEdit;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_verify_otp);


	otp_textbox_one = findViewById(R.id.otp_edit_box1);
	otp_textbox_two = findViewById(R.id.otp_edit_box2);
	otp_textbox_three = findViewById(R.id.otp_edit_box3);
	otp_textbox_four = findViewById(R.id.otp_edit_box4);
//	mEnter_otp = findViewById(R.id.editOTP);
	mVerify = findViewById(R.id.verify_otp_btn);
//	mVerify1 = findViewById(R.id.btn_verify_otp1);
	ImageView back = findViewById(R.id.back_arrow_verify);
//	mProgressBar = findViewById(R.id.progressBarVerify);
	mCountdown = findViewById(R.id.tv_countdown);
	mResend = findViewById(R.id.btn_resend);

	textWatcher();
	receiveIntentExtras();
	startSmsUserConsent();
	startCountdown();
	back.setOnClickListener(v -> finish());
	mVerify.setOnClickListener(v -> verifyOtp());
//	mVerify1.setOnClickListener(v -> verifyOtp1());
//	mResend.setOnClickListener(v -> resendOTP());
}

private void textWatcher() {
	mEdit = new EditText[]{otp_textbox_one, otp_textbox_two, otp_textbox_three, otp_textbox_four};

	otp_textbox_one.addTextChangedListener(new GenericTextWatcher(otp_textbox_one, mEdit));
	otp_textbox_two.addTextChangedListener(new GenericTextWatcher(otp_textbox_two, mEdit));
	otp_textbox_three.addTextChangedListener(new GenericTextWatcher(otp_textbox_three, mEdit));
	otp_textbox_four.addTextChangedListener(new GenericTextWatcher(otp_textbox_four, mEdit));
}

private void receiveIntentExtras() {
	Intent intent = getIntent();
	mPhone = intent.getStringExtra("phone");
}

private void resendOTP() {

	mResend.setVisibility(View.GONE);
	mProgressBar.setVisibility(View.VISIBLE);

	ApiInterface apiService =
			ApiClient.getClient().create(ApiInterface.class);

	Call<MessageResponse> call = apiService.sendOTP(mPhone, "", "send-otp", "");
	call.enqueue(new Callback<MessageResponse>() {

		@Override
		public void onResponse(@NonNull Call<MessageResponse> call,
		                       @NonNull Response<MessageResponse> response) {
			try {
				assert response.body() != null;
				Log.d("ResponseLog", call.request().toString());
				if (response.body().getError().equals("false")) {
					startSmsUserConsent();
					mProgressBar.setVisibility(View.GONE);
					mResend.setVisibility(View.GONE);
					mVerify1.setVisibility(View.VISIBLE);
					mId1 = response.body().getId();
				} else {
					Toast.makeText(VerifyOtpActivity.this, response.body().getMessage(),
							Toast.LENGTH_LONG).show();
					final Handler handler = new Handler();
					handler.postDelayed(() -> {
						mProgressBar.setVisibility(View.GONE);
						startCountdown();

					}, 60000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		@Override
		public void onFailure(@NonNull Call<MessageResponse> call, @NonNull Throwable t) {
			Log.e("ERROR", t.toString());
		}

	});
}

private void startSmsUserConsent() {
	SmsRetrieverClient client = SmsRetriever.getClient(this);
	//We can add sender phone number or leave it blank I'm adding null here
	client.startSmsUserConsent(null).addOnSuccessListener(aVoid -> Toast.makeText(getApplicationContext(),
			"OTP successfully sent", Toast.LENGTH_LONG).show()
	).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "There was a problem, please try again",
			Toast.LENGTH_LONG).show());
}

@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
	if (requestCode == REQ_USER_CONSENT) {
		if ((resultCode == RESULT_OK) && (data != null)) {

			//This gives the whole message to us. We need to extract the code using regex
			String message = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
			mEnter_otp.setText(String.format("%s - %s", getString(R.string.received_message), message));
			getOtpFromMessage(message);
			verifyOtp();
		}
	}
}

private void getOtpFromMessage(String message) {
	// This will match any 4 digit number in the message
	Pattern pattern = Pattern.compile("(|^)\\d{4}");
	Matcher matcher = pattern.matcher(message);
	if (matcher.find()) {
		mEnter_otp.setText(matcher.group(0));
	}
}

private void registerBroadcastReceiver() {
	smsBroadcastReceiver = new SmsBroadcastReceiver();
	smsBroadcastReceiver.smsBroadcastReceiverListener =
			new SmsBroadcastReceiver.SmsBroadcastReceiverListener() {
				@Override
				public void onSuccess(Intent intent) {
					startActivityForResult(intent, REQ_USER_CONSENT);
				}

				@Override
				public void onFailure() {
				}
			};
	IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
	registerReceiver(smsBroadcastReceiver, intentFilter);
}

private void verifyOtp() {

	startActivity(new Intent(this,SecurityQuestions.class));
//	String id = getIntent().getStringExtra("id");
//	mOtpAuto = mEnter_otp.getText().toString();
//	if (mOtpAuto.isEmpty()){
//		mEnter_otp.setError("Enter otp");
//	}else{
//		mProgressBar.setVisibility(View.VISIBLE);
//		mVerify.setVisibility(View.GONE);
//
//		ApiInterface apiService =
//				ApiClient.getClient().create(ApiInterface.class);
//
//		Call<MessageResponse> call = apiService.verifyOTP("", "", "verify-otp", mOtpAuto, id, "");
//
//		call.enqueue(new Callback<MessageResponse>() {
//
//			@Override
//			public void onResponse(@NonNull Call<MessageResponse> call, @NonNull Response<MessageResponse> response) {
//
//				try {
//					assert response.body() != null;
//					if (response.body().getError().equals("false")) {
//						Intent intent = new Intent(VerifyOtpActivity.this, MainActivity.class);
//						startActivity(intent);
//						finish();
//					} else {
//						Toast.makeText(VerifyOtpActivity.this, response.body().getMessage(),
//								Toast.LENGTH_LONG).show();
//						Log.d("FailureVerify", response.body().getMessage());
//						new CountDownTimer(60000, 1000) {
//							@SuppressLint({"SetTextI18n", "DefaultLocale"})
//							public void onTick(long millisUntilFinished) {
//								mCountdown.setText(response.body().getMessage() + ", " + "resend OTP " +
//										                   "in " + String.format("%02d:%02d",
//										TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
//										TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
//												TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
//							}
//
//							public void onFinish() {
//								mEnter_otp.setText("");
//								mResend.setVisibility(View.VISIBLE);
//								mProgressBar.setVisibility(View.GONE);
//								mCountdown.setVisibility(View.GONE);
//							}
//						}.start();
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			@Override
//			public void onFailure(@NonNull Call<MessageResponse> call, @NonNull Throwable t) {
//				Log.e("ERRORVERIFY", t.toString());
//			}
//
//		});
//	}
}

private void verifyOtp1() {

	mOtpAuto = mEnter_otp.getText().toString();
	mProgressBar.setVisibility(View.VISIBLE);
	mVerify1.setVisibility(View.GONE);
	mCountdown.setVisibility(View.VISIBLE);

	ApiInterface apiService =
			ApiClient.getClient().create(ApiInterface.class);

	Call<MessageResponse> call = apiService.verifyOTP("", "", "verify-otp", mOtpAuto, mId1, "");

	call.enqueue(new Callback<MessageResponse>() {

		@Override
		public void onResponse(@NonNull Call<MessageResponse> call, @NonNull Response<MessageResponse> response) {

			try {
				assert response.body() != null;
				if (response.body().getError().equals("false")) {
					Intent intent = new Intent(VerifyOtpActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(VerifyOtpActivity.this, response.body().getMessage(),
							Toast.LENGTH_LONG).show();
					Log.d("FailureVerify", response.body().getMessage());
					new CountDownTimer(60000, 1000) {
						@SuppressLint({"SetTextI18n", "DefaultLocale"})
						public void onTick(long millisUntilFinished) {
							mCountdown.setText(response.body().getMessage() + ", " + "resend " +
									                   "OTP in " + String.format("%02d" +":%02d",
									TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
									TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
											TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
						}

						public void onFinish() {
							mEnter_otp.setText("");
							mResend.setVisibility(View.VISIBLE);
							mVerify1.setVisibility(View.GONE);
							mProgressBar.setVisibility(View.GONE);
							mCountdown.setVisibility(View.GONE);
						}
					}.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onFailure(@NonNull Call<MessageResponse> call, @NonNull Throwable t) {
			Log.e("ERRORVERIFY", t.toString());
		}

	});
}


private void startCountdown() {
	new CountDownTimer(60000, 1000) {
		@SuppressLint({"SetTextI18n", "DefaultLocale"})
		public void onTick(long millisUntilFinished) {
			mCountdown.setText("(" + String.format("%02d",
					TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
							TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))) + "s)");
		}

		public void onFinish() {
//			mEnter_otp.setText("");
//			mResend.setVisibility(View.VISIBLE);
//			mProgressBar.setVisibility(View.GONE);
//			mCountdown.setVisibility(View.GONE);
		}
	}.start();
}

@Override
protected void onStart() {
	super.onStart();
	registerBroadcastReceiver();
}

@Override
protected void onStop() {
	super.onStop();
	unregisterReceiver(smsBroadcastReceiver);
}
}