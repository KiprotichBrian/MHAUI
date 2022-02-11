package com.mobile.myHealth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Preview extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.preview);

	Objects.requireNonNull(getSupportActionBar()).hide();

	Button login1 = findViewById(R.id.btn_login);
	Button signup1 = findViewById(R.id.btn_signup);
	Button preview1 = findViewById(R.id.btn_preview_app);

	preview1.setOnClickListener(v -> {
		Intent preview = new Intent(Preview.this, MainActivity.class);
		startActivity(preview);

	});

	login1.setOnClickListener(v -> {
		Intent login = new Intent(Preview.this, Login.class);
		startActivity(login);
	});

	signup1.setOnClickListener(v -> {
		Intent signup = new Intent(Preview.this, SignUp.class);
		startActivity(signup);
	});
}
}