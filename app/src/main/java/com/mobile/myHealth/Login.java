package com.mobile.myHealth;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mobile.myHealth.Adapters.LogInAdapter;

public class Login extends AppCompatActivity {

private ViewPager mSign_up_pager;
private TabLayout mSign_up_tab;
private ImageView mImg_home;
private ImageView mImg_bubbles;
float v = 0;


@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);

	mSign_up_pager = findViewById(R.id.pagerSignIn);
	mSign_up_tab = findViewById(R.id.tabLayoutSignIn);
//	mImg_bubbles = findViewById(R.id.img_bubbles);
	mImg_home = findViewById(R.id.img_home);

	final LogInAdapter adapter = new LogInAdapter(getSupportFragmentManager(),this,
			mSign_up_tab.getTabCount());
	mSign_up_pager.setAdapter(adapter);
	mSign_up_tab.setupWithViewPager(mSign_up_pager);

	mSign_up_tab.setTranslationX(800);
	mSign_up_tab.setAlpha(v);
	mSign_up_tab.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

	mImg_home.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			finish();
		}
	});


}

}