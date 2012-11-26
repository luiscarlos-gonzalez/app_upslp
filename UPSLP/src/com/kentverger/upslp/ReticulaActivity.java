package com.kentverger.upslp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;

public class ReticulaActivity extends SherlockFragmentActivity implements ActionBar.TabListener{
	
	@Override
	protected void onCreate(Bundle arg0){
		
		setTheme(R.style.UPSLPTheme);
		super.onCreate(arg0);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab = actionBar.newTab()
				.setText(R.string.sem1)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.sem2)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.sem3)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.sem4)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.sem5)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.sem6)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.sem7)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.sem8)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.sem9)
				.setTabListener(this);
		actionBar.addTab(tab);
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
