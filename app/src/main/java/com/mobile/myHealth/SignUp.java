package com.mobile.myHealth;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.mobile.myHealth.Network.ApiClient;
import com.mobile.myHealth.Network.ApiInterface;
import com.mobile.myHealth.Network.MessageResponse;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

private EditText mFirstName;
private EditText mLastName;
private EditText mPhoneNumber;
private EditText mEmailAddress;
private EditText mPassword;
private EditText mConfirmPassword;
private Button mSignUp;
private String mFName;
private String mLName;
private String mPhone;
private String mEmail;
private String mPassword1;
private LottieAnimationView mProgressBar;
private CountryCodePicker mCcp;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
//	setContentView(R.layout.activity_sign_up_email);

	mFirstName = findViewById(R.id.firstName_phone);
	mLastName = findViewById(R.id.lastName_phone);
	mPhoneNumber = findViewById(R.id.phoneNumber_phone);
	mCcp = findViewById(R.id.ccp_signUp_phone);
//	mEmailAddress = findViewById(R.id.email);
	mPassword = findViewById(R.id.password_phone);
//	mConfirmPassword = findViewById(R.id.confirmPassword);
//	mSignUp = findViewById(R.id.btn_signUp_phone);
//	mProgressBar = findViewById(R.id.progressBarSignUp_phone);

//	mSignUp.setOnClickListener(v -> validate());
//	ImageView back = findViewById(R.id.back_arrow_sign_up);
//	back.setOnClickListener(v -> finish());

	spanText();
}

private void spanText() {
	SpannableString ss = new SpannableString("By registering, you agree to the privacy policy and" +
			                                         " terms of service");
	String urlPrivacy = "https://www.myhealthafrica.com/privacy-policy/";
	String urlTerms = "https://www.myhealthafrica.com/terms-of-use/";

	ss.setSpan(new URLSpan(urlPrivacy), 33, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	ss.setSpan(new URLSpan(urlTerms), 52, 68, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//	TextView textView = findViewById(R.id.tvTerms);
//	textView.setText(ss);
//	textView.setMovementMethod(LinkMovementMethod.getInstance());
//	textView.setHighlightColor(Color.TRANSPARENT);
}

private void signUp() {

	mSignUp.setEnabled(false);
	mProgressBar.setVisibility(View.VISIBLE);

	String country_code = mCcp.getSelectedCountryCode();
	String phone_number = country_code + mPhone;
	String signup = "signup";

	ApiInterface apiService =
			ApiClient.getClient().create(ApiInterface.class);
	Call<MessageResponse> call = apiService.register(mFName, mLName, phone_number, mEmail, signup,
			mPassword1);

	call.enqueue(new Callback<MessageResponse>() {
		@Override
		public void onResponse(@NonNull Call<MessageResponse> call,
		                       @NonNull Response<MessageResponse> response) {
			try {
				assert response.body() != null;
				if (response.body().getError().equals("false")) {
					mProgressBar.setVisibility(View.GONE);
					mSignUp.setEnabled(true);
					Intent success = new Intent(SignUp.this, VerifyOtpActivity.class);
					success.putExtra("id", response.body().getOtp_id());
					startActivity(success);
					finish();
				}else {
					Toast.makeText(SignUp.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
private void validate(){

	mFName = mFirstName.getText().toString();
	mLName = mLastName.getText().toString();
	mPhone = mPhoneNumber.getText().toString();
	mEmail = mEmailAddress.getText().toString();
	mPassword1 = mPassword.getText().toString();
	String confirmPassword1 = mConfirmPassword.getText().toString();

	if (mFName.isEmpty()){
		mFirstName.setError("Enter First Name");
	}
	else if (mLName.isEmpty()){
		mLastName.setError("Enter Last Name");
	}
	else if (mEmail.isEmpty()){
		mEmailAddress.setError("Enter Email Address");
	}
	else if (mPhone.isEmpty()){
		mPhoneNumber.setError("Enter Phone Number");
	}
	else if (mPassword1.isEmpty()){
		mPassword.setError("Enter password");
	}
	else if (confirmPassword1.isEmpty()){
		mConfirmPassword.setError("Enter password confirmation");
	}
	else if (!confirmPassword1.equals(mPassword1)) {
		mPassword.setError("Passwords do not match") ;
		mConfirmPassword.setError("Passwords do not match");
	}
	else {
		signUp();
	}
}


}