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

public class MainFragment extends Fragment {


public MainFragment() {
	// Required empty public constructor
}
private View mView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
	// Inflate the layout for this fragment
	mView = inflater.inflate(R.layout.fragment_main, container, false);


	onClickListeners();
	loadServices();
	loadDoctors();

	return mView;
}

private void onClickListeners() {


}

private void loadServices() {

}

private void loadDoctors() {


}
}