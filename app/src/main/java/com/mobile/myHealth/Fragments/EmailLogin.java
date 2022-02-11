package com.mobile.myHealth.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.mobile.myHealth.MainActivity;
import com.mobile.myHealth.Network.ApiClient;
import com.mobile.myHealth.Network.ApiInterface;
import com.mobile.myHealth.Network.MessageResponse;
import com.mobile.myHealth.R;
import com.mobile.myHealth.ForgotPassword;
import com.mobile.myHealth.SignUpScreen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailLogin extends Fragment {

private EditText mEmail;
private EditText mPassword;
private Button mLogin;
private String mPassword1;
private String mEmail1;
private LottieAnimationView mProgressEmail;
private String mEmailLogin;
private CheckBox mCheck;
private TextView mSignUp;

public EmailLogin() {
	// Required empty public constructor
}
private View mView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

	// Inflate the layout for this fragment
	mView = inflater.inflate(R.layout.fragment_email_login, container, false);

	mEmail = mView.findViewById(R.id.edt_email_address);
	mPassword = mView.findViewById(R.id.edt_password_phone);
	mLogin = mView.findViewById(R.id.btn_login_email);
	mProgressEmail = mView.findViewById(R.id.progressBar_email);
//	mCheck = mView.findViewById(R.id.checkBoxEmailLogin);
	mSignUp = mView.findViewById(R.id.tvLogin);

//	mLogin.setOnClickListener(v -> validate());
	spanText();
	mSignUp.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent(getContext(), SignUpScreen.class));
		}
	});
	mLogin.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent(getContext(), MainActivity.class));
		}
	});
//	initializeViews();
	return mView;
}
private void initializeViews() {
	mLogin.setEnabled(false);
	mCheck.setChecked(false);
	mCheck.setOnClickListener(v -> mLogin.setEnabled(mCheck.isChecked()));

}
private void spanText() {
	SpannableString ss = new SpannableString("Forgot password");

	ClickableSpan clickableSpan = new ClickableSpan() {
		@Override
		public void onClick(View textView) {
			startActivity(new Intent(getActivity(), ForgotPassword.class));
		}

		@Override
		public void updateDrawState(TextPaint ds) {
			super.updateDrawState(ds);
			ds.setUnderlineText(false);
		}
	};

	ss.setSpan(clickableSpan, 0, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

	TextView textView = mView.findViewById(R.id.tv_reset_password);
	textView.setText(ss);
	textView.setMovementMethod(LinkMovementMethod.getInstance());
}

private void validate() {
	mEmail1 = mEmail.getText().toString();
	mPassword1 = mPassword.getText().toString();
	mEmailLogin = "email-login";

	if (mEmail1.isEmpty()) {
		mEmail.setError("Enter email");
	}
	if (mPassword1.isEmpty()) {
		mPassword.setError("Enter password");
	} else {
		login();
	}
}

private void login() {

	mLogin.setVisibility(View.GONE);
	mProgressEmail.setVisibility(View.VISIBLE);

	ApiInterface apiService =
			ApiClient.getClient().create(ApiInterface.class);

	Call<MessageResponse> call = apiService.email_login(mEmail1, mEmailLogin, mPassword1);
	call.enqueue(new Callback<MessageResponse>() {
		@Override
		public void onResponse(@NonNull Call<MessageResponse> call,
		                       @NonNull Response<MessageResponse> response) {
			try {
				assert response.body() != null;
				if (response.body().getError().equals("false")) {

					mProgressEmail.setVisibility(View.GONE);
					mLogin.setVisibility(View.VISIBLE);
					Intent success = new Intent(getActivity(), MainActivity.class);
					startActivity(success);
					getActivity().finish();
				} else {
					Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

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
}