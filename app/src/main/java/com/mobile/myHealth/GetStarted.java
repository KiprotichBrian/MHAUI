package com.mobile.myHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetStarted extends AppCompatActivity {

private Button mStart;
private Button mSign;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_get_started);

	mStart = findViewById(R.id.btn_start);
	mSign = findViewById(R.id.btn_sign_in);

	mStart.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent(GetStarted.this, Onboarding.class));
		}
	});
	mSign.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent(GetStarted.this, Login.class));
		}
	});
}
}