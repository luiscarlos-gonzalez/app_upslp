package com.kentverger.upslp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;

public class Horario extends SherlockFragmentActivity implements ActionBar.TabListener{
	
	@Override
	protected void onCreate(Bundle arg0){
		
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		super.onCreate(arg0);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab = actionBar.newTab()
				.setText(R.string.Lunes)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.Martes)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.Miercoles)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.Jueves)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText(R.string.Viernes)
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

