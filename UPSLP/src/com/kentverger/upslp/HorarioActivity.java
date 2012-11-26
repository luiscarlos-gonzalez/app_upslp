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
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;

public class HorarioActivity extends SherlockFragmentActivity implements ActionBar.TabListener{
	
	private StringBuilder horario;
	private SherlockFragment f;
	
	@Override
	protected void onCreate(Bundle arg0){
		
		setTheme(R.style.UPSLPTheme);
		super.onCreate(arg0);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setTitle("Tu horario");
		
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
		Log.d("json", horario.toString());
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
		if(tab.getText().equals(getResources().getString(R.string.Lunes))){
			Bundle b = new Bundle();
			b.putString("json", horario.toString());
			b.putString("dia", "Lunes");
			f = (SherlockFragment) SherlockFragment.instantiate(this, HorarioFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.Martes))){
			Bundle b = new Bundle();
			b.putString("json", horario.toString());
			b.putString("dia", "Martes");
			f = (SherlockFragment) SherlockFragment.instantiate(this, HorarioFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.Miercoles))){
			Bundle b = new Bundle();
			b.putString("json", horario.toString());
			b.putString("dia", "Miercoles");
			f = (SherlockFragment) SherlockFragment.instantiate(this, HorarioFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.Jueves))){
			Bundle b = new Bundle();
			b.putString("json", horario.toString());
			b.putString("dia", "Jueves");
			f = (SherlockFragment) SherlockFragment.instantiate(this, HorarioFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.Viernes))){
			Bundle b = new Bundle();
			b.putString("json", horario.toString());
			b.putString("dia", "Viernes");
			f = (SherlockFragment) SherlockFragment.instantiate(this, HorarioFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.Sabado))){
			Bundle b = new Bundle();
			b.putString("json", horario.toString());
			b.putString("dia", "Sabado");
			f = (SherlockFragment) SherlockFragment.instantiate(this, HorarioFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.detach(f);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}

