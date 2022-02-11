package com.mobile.myHealth.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.mobile.myHealth.Login;
import com.mobile.myHealth.R;

public class sign_up_email extends Fragment {

private EditText mEdt_fName_phone;
private EditText mEdt_lName_phone;
private EditText mEdt_email_address;
private EditText mEdt_password_phone;
private Button mBtn_signUp_phone;
private ImageButton mGoogle_signUp_phone;
private ImageButton mFacebook_signUp_phone;
private TextView mTerms;
private CheckBox mCheck;
private Button mBtnSignUp;
private TextView mLogin;

public sign_up_email() {
	// Required empty public constructor
}

private View mView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

	mView = inflater.inflate(R.layout.activity_sign_up_email, container, false);

	mEdt_fName_phone = mView.findViewById(R.id.firstName_email);
	mEdt_lName_phone = mView.findViewById(R.id.lastName_email);
	mEdt_email_address = mView.findViewById(R.id.email_address);
	mEdt_password_phone = mView.findViewById(R.id.password_email);
	mCheck = mView.findViewById(R.id.checkBox_email);
	mTerms = mView.findViewById(R.id.txt_tc);
	mBtnSignUp = mView.findViewById(R.id.btn_signUp_email);
	mLogin = mView.findViewById(R.id.tvLogin);

	spanText();
	initializeViews();
	return mView;
}
private void initializeViews() {
	mBtnSignUp.setEnabled(false);
	mCheck.setChecked(false);
	mCheck.setOnClickListener(v -> mBtnSignUp.setEnabled(mCheck.isChecked()));
	mLogin.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent(getContext(), Login.class));
		}
	});

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