package com.kentverger.upslp;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;


public class Acceso extends SherlockFragmentActivity implements ActionBar.TabListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		super.onCreate(savedInstanceState);
		
		ActionBar mActionBar = getSupportActionBar();

		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab carrera = getSupportActionBar().newTab();
		carrera.setText("Carrera");
		Tab horario = getSupportActionBar().newTab();
		horario.setText("Horario");
		Tab calificaciones = getSupportActionBar().newTab();
		calificaciones.setText("Calificaciones");
		Tab faltas = getSupportActionBar().newTab();
		faltas.setText("Faltas");



		carrera.setTabListener(this);
		horario.setTabListener(this);
		calificaciones.setTabListener(this);
		faltas.setTabListener(this);


		mActionBar.addTab(carrera);
		mActionBar.addTab(horario);
		mActionBar.addTab(calificaciones);
		mActionBar.addTab(faltas);



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