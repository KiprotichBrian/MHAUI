package com.mobile.myHealth.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;

import com.mobile.myHealth.Login;
import com.mobile.myHealth.R;
import com.mobile.myHealth.VerifyOtpActivity;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class sign_up_phone extends Fragment {

private EditText mEdt_fName_phone;
private EditText mEdt_lName_phone;
private CountryCodePicker mCcp_phone;
private EditText mEdt_phone_phone;
private EditText mEdt_password_phone;
private Button mBtn_signUp_phone;
private ImageButton mGoogle_signUp_phone;
private ImageButton mFacebook_signUp_phone;
float v = 0;
private TextInputLayout mFname;
private TextInputLayout mLname;
private TextInputLayout mPhone;
private TextInputLayout mPass;
private CheckBox mCheckBox;
private TextView mTerms;
private Button mSignUp;
private TextView mLogin;
private LottieAnimationView mProgressBar;

public sign_up_phone() {
	// Required empty public constructor
}
private View mView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

	mView = inflater.inflate(R.layout.activity_sign_up_phone, container, false);

	mEdt_fName_phone = mView.findViewById(R.id.firstName_phone);
	mEdt_lName_phone = mView.findViewById(R.id.lastName_phone);
	mCcp_phone = mView.findViewById(R.id.ccp_signUp_phone);
	mEdt_phone_phone = mView.findViewById(R.id.phoneNumber_phone);
	mEdt_password_phone = mView.findViewById(R.id.password_phone);
	mCheckBox = mView.findViewById(R.id.checkBox_phone);
	mTerms = mView.findViewById(R.id.txt_tc);
	mSignUp = mView.findViewById(R.id.btn_signUp_phone);
	mLogin = mView.findViewById(R.id.tvLogin);
	mProgressBar = mView.findViewById(R.id.progressBarSignUp_phone);

	animateViews();
	spanText();
	initializeViews();
	return  mView;
}

private void initializeViews() {
	mSignUp.setEnabled(false);
	mCheckBox.setChecked(false);
	mSignUp.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mSignUp.isEnabled()){
				generateOtp();
			}else{
				Toast.makeText(getContext(),"Read privacy policy",Toast.LENGTH_SHORT).show();
			}
		}
	});
	mCheckBox.setOnClickListener(v -> mSignUp.setEnabled(mCheckBox.isChecked()));
	mLogin.setOnClickListener(v -> startActivity(new Intent(getContext(), Login.class)));

}

private void generateOtp() {

	new CountDownTimer(6000, 1000) {
		@SuppressLint({"SetTextI18n", "DefaultLocale"})
		public void onTick(long millisUntilFinished) {
			mSignUp.setEnabled(false);
			mProgressBar.setVisibility(View.VISIBLE);
		}

		public void onFinish() {
			mProgressBar.setVisibility(View.GONE);
			mSignUp.setEnabled(true);
			startActivity(new Intent(getContext(), VerifyOtpActivity.class));
		}
	}.start();
}

private void animateViews() {

	mFname = mView.findViewById(R.id.edt_firstName_phone);
	mLname = mView.findViewById(R.id.edt_lastName_phone);
	mPhone = mView.findViewById(R.id.edt_phoneNumber_phone);
	mPass = mView.findViewById(R.id.edt_password_phone);

	mPhone.setTranslationX(800);
	mFname.setTranslationX(800);
	mLname.setTranslationX(800);
	mPass.setTranslationX(800);
	mCcp_phone.setTranslationX(800);

	mPhone.setAlpha(v);
	mFname.setAlpha(v);
	mLname.setAlpha(v);
	mPass.setAlpha(v);
	mCcp_phone.setAlpha(v);

	mPhone.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
	mCcp_phone.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
	mFname.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
	mLname.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();
	mPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
}
private void spanText() {
	SpannableString ss = new SpannableString("I accept terms and conditions");
	String urlTerms = "https://www.myhealthafrica.com/terms-of-use/";

	ss.setSpan(new URLSpan(urlTerms), 9, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

	mTerms.setText(ss);
	mTerms.setMovementMethod(LinkMovementMethod.getInstance());
	mTerms.setHighlightColor(Color.TRANSPARENT);
}

}