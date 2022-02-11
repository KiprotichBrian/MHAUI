package com.mobile.myHealth.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mobile.myHealth.Fragments.sign_up_email;
import com.mobile.myHealth.Fragments.sign_up_phone;

public class SignUpAdapter extends FragmentPagerAdapter {

	private Context context;
	int totalTabs;

public SignUpAdapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
	super(fm);
	this.context = context;
	this.totalTabs = totalTabs;
}

@NonNull
@Override
public Fragment getItem(int position) {
	Fragment fragment = null;
	if (position == 0) {
		fragment = new sign_up_phone();
	}else if (position == 1){
		fragment = new sign_up_email();
	}
	assert fragment != null;
	return fragment;
}
@Nullable
@Override
public CharSequence getPageTitle(int position) {
	String title = null;
	if (position==0){
		title = "Phone";

	}
	else if (position==1) {
		title = "Email";
	}


	return title;
}

@Override
public int getCount() {
	return 2;
}
}
