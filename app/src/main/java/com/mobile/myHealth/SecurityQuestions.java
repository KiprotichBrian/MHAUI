package com.mobile.myHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class SecurityQuestions extends AppCompatActivity {

private Spinner mSItems;
private Spinner mSItems2;
private TextInputEditText mAnswr1;
private TextInputEditText mAnswr2;
private Button mBtnSecNext;
private Button mBtnSecSkip;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_security_questions);

	mSItems = findViewById(R.id.question1);
	mSItems2 = findViewById(R.id.question2);
	mAnswr1 = findViewById(R.id.ansquestion1);
	mAnswr2 = findViewById(R.id.ansquestion2);
	mBtnSecNext = findViewById(R.id.btn_security_next);
	mBtnSecSkip = findViewById(R.id.btn_security_skip);


	initSpinner();
	clickListeners();
}

private void clickListeners() {
	mBtnSecNext.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent(SecurityQuestions.this, ResetPassword.class));
		}
	});
}

private void initSpinner() {
	// Spinner 1
	List<String> spinnerArray = new ArrayList<>();
	spinnerArray.add("Select question 1");
	spinnerArray.add("Select question 2");
	spinnerArray.add("Select question 3");
	spinnerArray.add("Select question 4");

	ArrayAdapter<String> adapter = new ArrayAdapter<>(
			this, android.R.layout.simple_spinner_item, spinnerArray);

	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	mSItems.setSelection(adapter.getCount());
	mSItems.setAdapter(adapter);


	// Spinner 2
	List<String> spinnerArray2 = new ArrayList<>();
	spinnerArray2.add("Select question 2");
	spinnerArray2.add("Select question 2");
	spinnerArray2.add("Select question 3");
	spinnerArray2.add("Select question 4");

	ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
			this, android.R.layout.simple_spinner_item, spinnerArray2);

	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	mSItems2.setSelection(adapter.getCount());
	mSItems2.setAdapter(adapter2);


}
}