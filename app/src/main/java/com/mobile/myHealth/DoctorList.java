package com.mobile.myHealth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.myHealth.Adapters.DoctorAdapter;
import com.mobile.myHealth.Adapters.DoctorListAdapter;
import com.mobile.myHealth.Models.DoctorListModel;

import java.util.ArrayList;
import java.util.Objects;

public class DoctorList extends AppCompatActivity {

private RecyclerView mRecycler;
private GridLayoutManager mGridLayoutManager;
private DoctorListAdapter mDoctorListAdapter;
private DoctorAdapter mDoctorAdapter;
private LinearLayoutManager mLinearLayoutManager;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_doctor_list);

	Objects.requireNonNull(getSupportActionBar()).setTitle("Doctors list");

	mRecycler = findViewById(R.id.recycler_doctor_list);
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
	mDoctorAdapter = new DoctorAdapter(this,DoctorList);
	mRecycler.setAdapter(mDoctorAdapter);
}
}