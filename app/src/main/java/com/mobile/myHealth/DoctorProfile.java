package com.mobile.myHealth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RaveUiManager;
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.skyhope.showmoretextview.ShowMoreTextView;

import java.util.Calendar;
import java.util.UUID;

import cn.pedant.SweetAlert.SweetAlertDialog;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class DoctorProfile extends AppCompatActivity {

private HorizontalCalendar horizontalCalendar;
private Chip mChip;
private ChipGroup mChipGroup;
private FrameLayout mFrameSlots;
private Button mBtnBookAppointment;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_doctor_profile);

	mBtnBookAppointment = findViewById(R.id.btn_book_appointment);
//	mBtnBookAppointment.setOnClickListener(v -> startActivity(new Intent(this,ChatActivity.class)));
	mBtnBookAppointment.setOnClickListener(v -> makePayment());

	showMore();
	inflateSpecialties();
	inflateCalendar();
	inflateTimeSlots();
}

private void showMore() {
	ShowMoreTextView doctor_summary = findViewById(R.id.text_view_show_more);
	doctor_summary.setShowingLine(2);
	doctor_summary.addShowMoreText("show more");
	doctor_summary.addShowLessText("show less");
	doctor_summary.setShowMoreColor(R.color.colorPrimary);
	doctor_summary.setShowLessTextColor(R.color.colorPrimary);
}

private void inflateTimeSlots() {
	mChipGroup = findViewById(R.id.chipGroupTimeSlots);

	String[] genres = {"09:00 AM",
			"09:30 AM",
			"10:00 AM",
			"11:00 AM",
			"11:30 AM",
			"12:00 PM"};
	for (String genre : genres) {
		mChip = new Chip(this);
		mChip.setText(genre);
		mChipGroup.addView(mChip);

	}
}

private void inflateSpecialties() {
	ChipGroup chipGroup = findViewById(R.id.chipGroupSpecialties);

	String[] genres = {
			"Anesthesiology",
			"Dermatology",
			"Radiology",
			"Emergency medicine",
			"Family medicine"};
	for (String genre : genres) {
		Chip chip = new Chip(this);
		chip.setText(genre);
		chipGroup.addView(chip);
		chip.setEnabled(false);
		chip.setTextAppearanceResource(R.style.ChipTextStyle);
		chip.setChipBackgroundColorResource(R.color.colorAccent);
	}
}

private void inflateCalendar() {
	Calendar startDate = Calendar.getInstance();
	startDate.add(Calendar.DATE, 0);

	Calendar endDate = Calendar.getInstance();
	endDate.add(Calendar.MONTH, 2);

	// Default Date set to Today.
	final Calendar defaultSelectedDate = Calendar.getInstance();

	horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
			                     .range(startDate, endDate)
			                     .datesNumberOnScreen(5)
			                     .configure()
			                     .formatTopText("MMM")
			                     .formatMiddleText("dd")
			                     .formatBottomText("EEE")
			                     .showTopText(true)
			                     .showBottomText(true)
			                     .textColor(Color.BLACK, Color.parseColor("#ffffff"))
			                     .colorTextMiddle(Color.BLACK, Color.parseColor("#ffffff"))
			                     .end()
			                     .defaultSelectedDate(defaultSelectedDate)
			                     .build();

	horizontalCalendarListener();
}

private void horizontalCalendarListener() {
	horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
		@Override
		public void onDateSelected(Calendar date, int position) {
			String selectedDateStr = DateFormat.format("EEE, MMM d, yyyy", date).toString();
			Toast.makeText(DoctorProfile.this, selectedDateStr + " selected!", Toast.LENGTH_SHORT).show();
		}

	});
}
private void makePayment() {

	String public_key = "FLWPUBK-88c939116e212caed1936c55b4cbfd16-X";
	String encryption_key = "b8354e05c17721cd19f6145d";
	String phoneNumber = "0748880318";
	String email = "bryannkoech7@gmail.com";
	String txRef = email +" "+  UUID.randomUUID().toString();

	new RaveUiManager(this)
			.setAmount(Double.parseDouble("1"))
			.setEmail(email)
			.setCountry("KE")
			.setCurrency("KES")
			.setfName("Kiprotich")
			.setlName("Brian")
			.setPhoneNumber(phoneNumber, false)
			.setNarration("SMO")
			.setPublicKey(public_key)
			.setEncryptionKey(encryption_key)
			.setTxRef(txRef)
			.acceptAccountPayments(true)
			.acceptCardPayments(true)
			.acceptMpesaPayments(true)
			.acceptUgMobileMoneyPayments(true)
			.onStagingEnv(false)
			.shouldDisplayFee(true)
			.showStagingLabel(false)
			.withTheme(R.style.RaveAppTheme)
			.initialize();

}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	/*
	 *  We advise you to do a further verification of transaction's details on your server to be
	 *  sure everything checks out before providing service or goods.
	 */
	if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
		String message = data.getStringExtra("response");
		if (resultCode == RavePayActivity.RESULT_SUCCESS) {
			Toast.makeText(this, "SUCCESS " + message, Toast.LENGTH_SHORT).show();
//			successMessage();
		}
		else if (resultCode == RavePayActivity.RESULT_ERROR) {
			Toast.makeText(this, "ERROR " + message, Toast.LENGTH_LONG).show();
//			errorMessage();
		}
		else if (resultCode == RavePayActivity.RESULT_CANCELLED) {
			Toast.makeText(this, "CANCELLED " + message, Toast.LENGTH_SHORT).show();
		}
	}
	else {
		super.onActivityResult(requestCode, resultCode, data);
	}
}
public void successMessage() {
	new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE).setTitleText("Good job!").setContentText("You clicked the button!").show();
}
public void errorMessage() {
	new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE).setTitleText("Oops...").setContentText("Something went wrong!").show();
}

}