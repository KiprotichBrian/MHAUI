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

import com.mobile.myHealth.DoctorProfile;
import com.mobile.myHealth.Models.DoctorListModel;
import com.mobile.myHealth.R;
import com.mobile.myHealth.Utility.PicassoCircleTransformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class DoctorAdapterHome extends RecyclerView.Adapter<DoctorAdapterHome.DoctorViewHolder> {

Context context;
ArrayList<DoctorListModel> doctorsList;


public DoctorAdapterHome(Context context, ArrayList<DoctorListModel> doctorsList) {
	this.context = context;
	this.doctorsList = doctorsList;
}

@NonNull
@Override
public DoctorAdapterHome.DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
	View view = LayoutInflater.from(context).inflate(R.layout.item_doctor_card_home, parent, false);

	view.setOnClickListener(v -> {
		Intent doc = new Intent(context, DoctorProfile.class);
		context.startActivity(doc);
	});

	return new DoctorViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull DoctorAdapterHome.DoctorViewHolder holder, int position) {

	Picasso.get().load(R.drawable.doctor).transform(new PicassoCircleTransformation()).into(holder.mDoctorsImage);
	holder.mDoctorsName.setText("Kiprotich Brian");
	holder.mDoctorsTitle.setText("Neuro-surgeon, Nairobi");

	final int basec = 230; //baseline would be 50% gray

	Random rndm = new Random();
	int color = Color.argb(255, basec + rndm.nextInt(256-basec), basec + rndm.nextInt(256-basec), basec + rndm.nextInt(256-basec));
	holder.mCardView.setCardBackgroundColor(color);

}

@Override
public int getItemCount() {
	return doctorsList.size();
}

public static class DoctorViewHolder extends RecyclerView.ViewHolder {
	private final ImageView mDoctorsImage;
	private final TextView mDoctorsTitle;
	private final TextView mDoctorsName;
	private final CardView mCardView;

	public DoctorViewHolder(@NonNull View itemView) {
		super(itemView);

		mDoctorsImage = itemView.findViewById(R.id.doctorsImage);
		mDoctorsTitle = itemView.findViewById(R.id.doctorsTitle);
		mDoctorsName = itemView.findViewById(R.id.doctorsName);

		mCardView = itemView.findViewById(R.id.card_doc);

	}
}
}
