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

import com.mobile.myHealth.Models.ServicesModel;
import com.mobile.myHealth.R;
import com.mobile.myHealth.Search;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

private RecyclerView mRecyclerView;
private LinearLayoutManager mLinearLayoutManager;

private RecyclerView mRecycler;
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


//	onClickListeners();
//	loadServices();
//	loadDoctors();

	return mView;
}

private void onClickListeners() {
	mSearch.setOnClickListener(v -> {
		Intent search = new Intent(getContext(), Search.class);
		startActivity(search);
	});

	mSwitch_dark.setOnClickListener(v -> AppCompatDelegate
			.setDefaultNightMode(
					AppCompatDelegate
							.MODE_NIGHT_YES));

}

private void loadServices() {

}

private void loadDoctors() {



}
}