package com.mobile.myHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

public class ResetPassword extends AppCompatActivity {

private ImageView mBack;
private TextInputEditText mPassword;
private TextInputEditText mConfirm;
private Button mBtnConfirm;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_reset_password);

	mBack = findViewById(R.id.img_back);
	mPassword = findViewById(R.id.edt_password);
	mConfirm = findViewById(R.id.edt_conf_pass);
	mBtnConfirm = findViewById(R.id.btn_confirm);

	clickEvents();
}

private void clickEvents() {
	mBack.setOnClickListener(v -> finish());
	mBtnConfirm.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent(ResetPassword.this, Interests.class));
		}
	});
}
}