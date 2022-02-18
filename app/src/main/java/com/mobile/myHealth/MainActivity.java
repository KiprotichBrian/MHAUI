package com.mobile.myHealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.mobile.myHealth.Fragments.AccountFragment;
import com.mobile.myHealth.Fragments.ExploreFragment;
import com.mobile.myHealth.Fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

private BubbleNavigationConstraintView mBubbleNavigation;
Fragment selectedFragment = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	mBubbleNavigation = findViewById(R.id.bubbleNavigation);
	getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
			new MainFragment()).commit();

	mBubbleNavigation.setNavigationChangeListener((view, position) -> {
		switch (position){
			case 0:
				selectedFragment = new MainFragment();
				break;
			case 1:
				selectedFragment = new ExploreFragment();
				break;
			case 2:
				selectedFragment = new ExploreFragment();
				break;
			case 3:
				selectedFragment = new AccountFragment();
				break;
		}
		getSupportFragmentManager().beginTransaction().setCustomAnimations(
				R.anim.slide_in,  // enter
				R.anim.fade_out // exit
		).replace(R.id.fragment_container,
				selectedFragment).commit();
	});
}
}