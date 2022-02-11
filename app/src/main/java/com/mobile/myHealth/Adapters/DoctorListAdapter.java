package com.mobile.myHealth.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.myHealth.DoctorProfile;
import com.mobile.myHealth.Models.DoctorListModel;
import com.mobile.myHealth.R;
import com.mobile.myHealth.Utility.PicassoCircleTransformation;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class DoctorListAdapter extends FirebaseRecyclerAdapter<DoctorListModel,DoctorListAdapter.FirebaseViewHolder> {

private final Context mContext;

public DoctorListAdapter(@NonNull FirebaseRecyclerOptions<DoctorListModel> options, Context context) {
	super(options);
	mContext = context;
}

@NonNull
@Override
public DoctorListAdapter.FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
	View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor_card, parent, false);

	view.setOnClickListener(v -> {
		Intent doc = new Intent(mContext, DoctorProfile.class);
		mContext.startActivity(doc);
	});

	return new FirebaseViewHolder(view);
}

@Override
protected void onBindViewHolder(@NonNull DoctorListAdapter.FirebaseViewHolder holder, int position, @NonNull DoctorListModel model) {
	Picasso.get().load(model.getDoctorAvatar()).transform(new PicassoCircleTransformation()).into(holder.mDoctorsImage);
	holder.mDoctorsName.setText(model.getDoctorName());
	holder.mDoctorsTitle.setText(model.getDoctorTitle());

}

public static class FirebaseViewHolder extends RecyclerView.ViewHolder {

	private final ImageView mDoctorsImage;
	private final TextView mDoctorsTitle;
	private final TextView mDoctorsName;

	public FirebaseViewHolder(@NonNull View itemView) {
		super(itemView);

		mDoctorsImage = itemView.findViewById(R.id.doctorsImage);
		mDoctorsTitle = itemView.findViewById(R.id.doctorsTitle);
		mDoctorsName = itemView.findViewById(R.id.doctorsName);
	}
}
}
