package com.mobile.myHealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {

private CardView mCardEmail;
private CardView mCardPhone;
private ImageView mCheckEmail;
private TextView mTvEmail;
private ImageView mCheckPhone;
private TextView mTvPhone;
private Button mSendLink;
private ImageView mBack;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_forgot_password);

	mCardEmail = findViewById(R.id.cardResetEmail);
	mCardPhone = findViewById(R.id.cardResetPhone);
	mCheckEmail = findViewById(R.id.checkEmail);
	mTvEmail = findViewById(R.id.editTextEmail);
	mCheckPhone = findViewById(R.id.checkPhone);
	mTvPhone = findViewById(R.id.editTextPhone);
	mSendLink = findViewById(R.id.btn_send_link);
	mBack = findViewById(R.id.imgBack);

	toggleCards();
	mSendLink.setOnClickListener(v -> startActivity(new Intent(ForgotPassword.this,VerifyOtpActivity.class)));
	mBack.setOnClickListener(v -> finish());
}

private void toggleCards() {

	mCheckEmail.setVisibility(View.GONE);
	mTvEmail.setVisibility(View.GONE);
	mCheckPhone.setVisibility(View.GONE);
	mTvPhone.setVisibility(View.GONE);

	mCardEmail.setOnClickListener(v -> {
		mCheckPhone.setVisibility(View.GONE);
		mTvPhone.setVisibility(View.GONE);
		mCardPhone.setBackground(ContextCompat.getDrawable(ForgotPassword.this,
				R.drawable.card_drawable_inactive));
		mCardEmail.setCardBackgroundColor(getColor(R.color.colorCard));
		mCardPhone.setCardBackgroundColor(getColor(R.color.white));
		mCardEmail.setBackground(ContextCompat.getDrawable(ForgotPassword.this,
				R.drawable.card_drawable_inactive));
		if((mCheckEmail.getVisibility()==View.GONE)&&(mTvEmail.getVisibility()==View.GONE)){
			mCheckEmail.setVisibility(View.VISIBLE);
			mTvEmail.setVisibility(View.VISIBLE);
			mCardEmail.setBackground(ContextCompat.getDrawable(ForgotPassword.this,
					R.drawable.card_drawable));
		}else {
			mCheckEmail.setVisibility(View.GONE);
			mTvEmail.setVisibility(View.GONE);
			mCardEmail.setCardBackgroundColor(getColor(R.color.white));
			mCardEmail.setBackground(ContextCompat.getDrawable(ForgotPassword.this,
					R.drawable.card_drawable_inactive));

		}
	});

	mCardPhone.setOnClickListener(v -> {
		mCheckEmail.setVisibility(View.GONE);
		mTvEmail.setVisibility(View.GONE);
		mCardEmail.setBackground(ContextCompat.getDrawable(ForgotPassword.this,
				R.drawable.card_drawable_inactive));
		mCardPhone.setCardBackgroundColor(getColor(R.color.colorCard));
		mCardEmail.setCardBackgroundColor(getColor(R.color.white));
		mCardPhone.setBackground(ContextCompat.getDrawable(ForgotPassword.this,
				R.drawable.card_drawable_inactive));
		if((mCheckPhone.getVisibility()==View.GONE)&&(mTvPhone.getVisibility()==View.GONE)){
			mCheckPhone.setVisibility(View.VISIBLE);
			mTvPhone.setVisibility(View.VISIBLE);
			mCardPhone.setBackground(ContextCompat.getDrawable(ForgotPassword.this,
					R.drawable.card_drawable));
		}else {
			mCheckPhone.setVisibility(View.GONE);
			mTvPhone.setVisibility(View.GONE);
			mCardPhone.setCardBackgroundColor(getColor(R.color.white));
			mCardPhone.setBackground(ContextCompat.getDrawable(ForgotPassword.this,
					R.drawable.card_drawable_inactive));
		}
	});
}
}