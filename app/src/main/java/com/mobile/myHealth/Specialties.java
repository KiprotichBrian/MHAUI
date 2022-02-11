package com.mobile.myHealth;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.myHealth.Adapters.ServicesAdapter;
import com.mobile.myHealth.Models.ServicesModel;

import java.util.ArrayList;
import java.util.Objects;

public class Specialties extends AppCompatActivity {

private LinearLayoutManager mLinearLayoutManager;
private ServicesAdapter mServicesAdapter;
private RecyclerView mRecycler;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_services);

	Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
	Objects.requireNonNull(getSupportActionBar()).setTitle("Specialties");

	mRecycler = findViewById(R.id.rv_services);
	mLinearLayoutManager = new LinearLayoutManager(this);
	mRecycler.setLayoutManager(mLinearLayoutManager);

	ArrayList<ServicesModel>SpecialtyList  = new ArrayList<>();

	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));
	SpecialtyList.add(new ServicesModel(R.drawable.dental, "Kiprotich Brian"));

	mServicesAdapter = new ServicesAdapter(this,SpecialtyList);
	mRecycler.setAdapter(mServicesAdapter);
}
}