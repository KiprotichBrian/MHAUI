package com.mobile.myHealth;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.myHealth.Adapters.DoctorAdapterHome;
import com.mobile.myHealth.Models.DoctorListModel;

import java.util.ArrayList;
import java.util.Objects;

public class DoctorListHome extends AppCompatActivity {

private RecyclerView mRecycler;
private DoctorAdapterHome mDoctorAdapter;
private LinearLayoutManager mLinearLayoutManager;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_doctor_list_home);

	Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
	Objects.requireNonNull(getSupportActionBar()).setTitle("Doctor list");

	mRecycler = findViewById(R.id.recycler_doctor_list_home);
	mLinearLayoutManager = new LinearLayoutManager(this);
	mRecycler.setLayoutManager(mLinearLayoutManager);

	ArrayList<DoctorListModel>DoctorList  = new ArrayList<>();

	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));
	DoctorList.add(new DoctorListModel(R.drawable.doctor, "Kiprotich Brian", "Neuro-surgeon, Nairobi"));

	mDoctorAdapter = new DoctorAdapterHome(this,DoctorList);
	mRecycler.setAdapter(mDoctorAdapter);
}
}