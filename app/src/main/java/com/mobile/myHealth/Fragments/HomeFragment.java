package com.mobile.myHealth.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mobile.myHealth.Adapters.DoctorAdapter;
import com.mobile.myHealth.Adapters.ServicesAdapterHome;
import com.mobile.myHealth.DoctorListHome;
import com.mobile.myHealth.Models.DoctorListModel;
import com.mobile.myHealth.Models.ServicesModel;
import com.mobile.myHealth.R;
import com.mobile.myHealth.Search;
import com.mobile.myHealth.Specialties;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

private RecyclerView mRecyclerView;
private LinearLayoutManager mLinearLayoutManager;
private ServicesAdapterHome mServicesAdapter;

private RecyclerView mRecycler;
private DoctorAdapter mDoctorAdapter;
private TextView mSee_all_doctors;
private TextView mSee_all_services;
private Button mSearch;
private Button mSwitch_dark;

public HomeFragment() {
	// Required empty public constructor
}
private View mView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
	// Inflate the layout for this fragment
	mView = inflater.inflate(R.layout.fragment_home, container, false);

	mSearch = mView.findViewById(R.id.btn_search);
	mSwitch_dark = mView.findViewById(R.id.switch_dark_mode);
	mSee_all_doctors = mView.findViewById(R.id.tv_seeAllDoctors);
	mSee_all_services = mView.findViewById(R.id.tv_seeAllServices);


	onClickListeners();
	loadServices();
	loadDoctors();

	return mView;
}

private void onClickListeners() {
	mSearch.setOnClickListener(v -> {
		Intent search = new Intent(getContext(), Search.class);
		startActivity(search);
	});
	mSee_all_services.setOnClickListener(v -> {
		Intent allServices = new Intent(getContext(), Specialties.class);
		startActivity(allServices);
	});
	mSee_all_doctors.setOnClickListener(v -> {
		Intent allDoc = new Intent(getContext(), DoctorListHome.class);
		startActivity(allDoc);
	});
	mSwitch_dark.setOnClickListener(v -> AppCompatDelegate
			.setDefaultNightMode(
					AppCompatDelegate
							.MODE_NIGHT_YES));

}

private void loadServices() {
	mRecyclerView = mView.findViewById(R.id.rv_services_home);
	mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
	mRecyclerView.setLayoutManager(mLinearLayoutManager);

	ArrayList<ServicesModel> ServicesList = new ArrayList<>();

	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));
	ServicesList.add(new ServicesModel(R.drawable.dental, "Dental services"));

	mServicesAdapter = new ServicesAdapterHome(getContext(), ServicesList);
	mRecyclerView.setAdapter(mServicesAdapter);
}

private void loadDoctors() {
	mRecycler = mView.findViewById(R.id.recycler_doctor_list);
	mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
	mRecycler.setLayoutManager(mLinearLayoutManager);

	ArrayList<DoctorListModel> DoctorList = new ArrayList<>();

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

	mDoctorAdapter = new DoctorAdapter(getContext(), DoctorList);
	mRecycler.setAdapter(mDoctorAdapter);


}
}