package com.mobile.myHealth.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.myHealth.Adapters.HospitalAdapter;
import com.mobile.myHealth.Models.HospitalModel;
import com.mobile.myHealth.R;

import java.util.ArrayList;

public class HospitalFragment extends Fragment {
private RecyclerView mRecycler;
private HospitalAdapter mHospitalAdapter;
private LinearLayoutManager mLinearLayoutManager;

public HospitalFragment() {
}
private View mView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
	mView = inflater.inflate(R.layout.fragment_hospital, container, false);


	mRecycler = mView.findViewById(R.id.rv_hospital_list_home);
	mLinearLayoutManager = new LinearLayoutManager(getContext());
	mRecycler.setLayoutManager(mLinearLayoutManager);

//	Beginning of dummy data(to be deleted)
	ArrayList<HospitalModel> HospitalList  = new ArrayList<>();

	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));
	HospitalList.add(new HospitalModel( "Gertrude’s Children’s Hospital","Nairobi, Kenya","(123 " +
			                                                                                      "Reviews)",R.drawable.hospital_img,"4.5"));

	mHospitalAdapter = new HospitalAdapter(getContext(),HospitalList);
	mRecycler.setAdapter(mHospitalAdapter);
//	End of dummy data(To be deleted)
	return mView;
}
}