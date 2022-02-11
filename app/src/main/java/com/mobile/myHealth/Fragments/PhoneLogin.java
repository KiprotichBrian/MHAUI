package com.mobile.myHealth.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.mobile.myHealth.MainActivity;
import com.mobile.myHealth.R;
import com.mobile.myHealth.ForgotPassword;
import com.mobile.myHealth.SignUpScreen;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

public class PhoneLogin extends Fragment {

float v = 0;
private TextInputLayout mPass;
private TextInputLayout mPhone;
private Button mLogin;
private CheckBox mCheck;
private TextView mSignUp;
private CountryCodePicker mCcp;


public PhoneLogin() {
	// Required empty public constructor
}

private View mView;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

	// Inflate the layout for this fragment
	mView = inflater.inflate(R.layout.fragment_phone_login, container, false);
//	mCheck = mView.findViewById(R.id.checkBoxPhoneLogin);
	mLogin = mView.findViewById(R.id.btn_login_phone);
	mSignUp = mView.findViewById(R.id.tvLogin);
	spanText();
	animateViews();

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
private void animateViews() {
	mCcp = mView.findViewById(R.id.ccp_signUp_phone);
	mPhone = mView.findViewById(R.id.phone);
	mPass = mView.findViewById(R.id.pass);

	mCcp.setTranslationX(800);
	mPhone.setTranslationX(800);
	mPass.setTranslationX(800);

	mCcp.setAlpha(v);
	mPhone.setAlpha(v);
	mPass.setAlpha(v);

	mCcp.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
	mPhone.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
	mPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();

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
}