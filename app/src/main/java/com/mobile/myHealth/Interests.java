package com.mobile.myHealth;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

public class Interests extends AppCompatActivity {

private Button mConfirm;
private Button mSkip;
private ChipGroup mInterests;
private Chip mChip;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_interests);

	mConfirm = findViewById(R.id.btn_confirm_interests);
	mSkip = findViewById(R.id.btn_skip_interests);
	mInterests = findViewById(R.id.chip_group_interests);

	inflateInterests();
	clickListeners();
}

private void clickListeners() {

	mInterests.setOnCheckedChangeListener((group, checkedId) -> {
		// Handle the checked chip change.
		mChip.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary,
				getTheme())));
	});
	mSkip.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent(Interests.this,EnterPin.class));
		}
	});
}

private void inflateInterests() {

	String[] interests = {"Mental Health",
			"Female Sexuality",
			"Hearing",
			"Sexuality",
			"Nutrition",
			"Respiratory",
			"Mindfulness",
			"Beauty",
			"Relationships & family",
			"Vitals"};

	for (String interest : interests) {
		mChip = new Chip(this);
		mChip.setText(interest);
		mChip.setCheckable(true);
		mChip.setChipBackgroundColor(ColorStateList.valueOf(Color.WHITE));
		mChip.setChipStrokeColor(ColorStateList.valueOf(getResources().getColor(R.color.textColor,
				getTheme())));
		mChip.setCheckedIconResource(R.drawable.check_chip);
		mChip.setChipStrokeWidth(1);
		mInterests.setChipSpacing(10);
		mInterests.addView(mChip);


	}
}
}