package com.mobile.myHealth.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.myHealth.HospitalProfile;
import com.mobile.myHealth.Models.HospitalModel;
import com.mobile.myHealth.R;
import com.mobile.myHealth.Utility.RoundedTransformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder> {

Context context;
ArrayList<HospitalModel> hospitalList;


public HospitalAdapter(Context context, ArrayList<HospitalModel> hospitalList) {
	this.context = context;
	this.hospitalList = hospitalList;
}

@NonNull
@Override
public HospitalAdapter.HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                           int viewType) {
	View view = LayoutInflater.from(context).inflate(R.layout.item_hospital, parent, false);

	view.setOnClickListener(v -> {
		Intent hospital = new Intent(context, HospitalProfile.class);
		context.startActivity(hospital);
	});

	return new HospitalViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull HospitalAdapter.HospitalViewHolder holder, int position) {

	Picasso.get().load(R.drawable.hospital_img).transform(new RoundedTransformation(50, 4))
			.into(holder.mHospitalImg);
	holder.mHospitalName.setText("Gertrude’s Children’s Hospital");
	holder.mHospitalLocation.setText("Nairobi, Kenya");
	holder.mRatings.setText("4.8");
	holder.mRatingsNo.setText("(123 Reviews)");

	final int basec = 230;

	Random rndm = new Random();
	int color = Color.argb(255, basec + rndm.nextInt(256-basec), basec + rndm.nextInt(256-basec), basec + rndm.nextInt(256-basec));
	holder.mCardView.setCardBackgroundColor(color);

}

@Override
public int getItemCount() {
	return hospitalList.size();
}

public static class HospitalViewHolder extends RecyclerView.ViewHolder {


	private final ImageView mHospitalImg;
	private final TextView mHospitalName;
	private final TextView mHospitalLocation;
	private final TextView mRatings;
	private final TextView mRatingsNo;
	private final CardView mCardView;

	public HospitalViewHolder(@NonNull View itemView) {
		super(itemView);

		mHospitalImg = itemView.findViewById(R.id.hospitalImage);
		mHospitalName = itemView.findViewById(R.id.hospitalName);
		mHospitalLocation = itemView.findViewById(R.id.hospitalLocation);
		mRatings = itemView.findViewById(R.id.tv_rating);
		mRatingsNo = itemView.findViewById(R.id.tv_no_of_reviews);

		mCardView = itemView.findViewById(R.id.cardViewHospital);



	}
}
}
