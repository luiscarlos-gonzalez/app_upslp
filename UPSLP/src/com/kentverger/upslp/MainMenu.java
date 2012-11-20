package com.kentverger.upslp;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;

public class MainMenu extends SherlockActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		setContentView(R.layout.main_menu);
		super.onCreate(savedInstanceState);
	}

}
