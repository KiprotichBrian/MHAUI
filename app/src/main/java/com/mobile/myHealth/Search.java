package com.mobile.myHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Search extends AppCompatActivity {

private ImageView mSearch_back;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_search);

	mSearch_back = findViewById(R.id.search_back);

	mSearch_back.setOnClickListener(v -> {
		finish();
	});
}
}