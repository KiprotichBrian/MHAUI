package com.mobile.myHealth.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.myHealth.Models.ServicesModel;
import com.mobile.myHealth.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class ServicesAdapterHome extends RecyclerView.Adapter<ServicesAdapterHome.ServicesViewHolder> {

Context context;
ArrayList<ServicesModel> servicesModel;

public ServicesAdapterHome(Context context, ArrayList<ServicesModel> servicesModel) {
	this.context = context;
	this.servicesModel = servicesModel;
}


@NonNull
@Override
public ServicesAdapterHome.ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
	View view = LayoutInflater.from(context).inflate(R.layout.item_services_home, parent, false);
	return new ServicesViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull ServicesAdapterHome.ServicesViewHolder holder, int position) {
	Picasso.get().load(R.drawable.dental).into(holder.mServiceImg);
	holder.mServiceTitle.setText("Dental services");

	final int basec = 230; //baseline would be 50% gray

	Random rndm = new Random();
	int color = Color.argb(255, basec + rndm.nextInt(256-basec), basec + rndm.nextInt(256-basec), basec + rndm.nextInt(256-basec));
	holder.mCardView.setCardBackgroundColor(color);
}

@Override
public int getItemCount() {
	return servicesModel.size();
}

public static class ServicesViewHolder extends RecyclerView.ViewHolder {

	private final ImageView mServiceImg;
	private final TextView mServiceTitle;
	private final CardView mCardView;

	public ServicesViewHolder(@NonNull View itemView) {
		super(itemView);
		mServiceImg = itemView.findViewById(R.id.service_img);
		mServiceTitle = itemView.findViewById(R.id.service_name);
		mCardView = itemView.findViewById(R.id.card_services);
	}
}
}
