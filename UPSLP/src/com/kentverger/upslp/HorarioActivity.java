package com.kentverger.upslp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;

public class HorarioActivity extends SherlockFragmentActivity implements ActionBar.TabListener{
	
	private StringBuilder horario;
	
	@Override
	protected void onCreate(Bundle arg0){
		
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		super.onCreate(arg0);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		FileInputStream horarioStream;
		String line;
		try {
			horarioStream = openFileInput("horario");
			InputStreamReader inputStreamReaderHorario = new InputStreamReader(horarioStream);
			BufferedReader bufferedReaderHorario = new BufferedReader(inputStreamReaderHorario );
			horario = new StringBuilder();
			while ((line = bufferedReaderHorario.readLine()) != null) {
				horario.append(line);
			}
		} catch (FileNotFoundException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		} catch (IOException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		}
		Log.d("Cadena", horario.toString());
		
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
		
		tab = actionBar.newTab()
				.setText(R.string.Sabado)
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

