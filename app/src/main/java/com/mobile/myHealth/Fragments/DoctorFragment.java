package com.mobile.myHealth.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.myHealth.Adapters.DoctorAdapterHome;
import com.mobile.myHealth.Models.DoctorListModel;
import com.mobile.myHealth.R;

import java.util.ArrayList;

public class DoctorFragment extends Fragment {
private RecyclerView mRecycler;
private DoctorAdapterHome mDoctorAdapter;
private LinearLayoutManager mLinearLayoutManager;

public DoctorFragment() {
}
private View mView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
	mView = inflater.inflate(R.layout.fragment_doctor, container, false);

	mRecycler = mView.findViewById(R.id.recycler_doctor_list_home);
	mLinearLayoutManager = new LinearLayoutManager(getContext());
	mRecycler.setLayoutManager(mLinearLayoutManager);

//	Beginning of dummy data(to be deleted)
	ArrayList<DoctorListModel> DoctorList  = new ArrayList<>();

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

	mDoctorAdapter = new DoctorAdapterHome(getContext(),DoctorList);
	mRecycler.setAdapter(mDoctorAdapter);
//	End of dummy data(To be deleted)
	return mView;
}
}