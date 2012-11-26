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
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class CarreraActivity extends SherlockFragmentActivity implements ActionBar.TabListener{
	
	private StringBuilder carrera;
	private SherlockFragment f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.UPSLPTheme);
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setTitle("Reticula");
		
		FileInputStream carreraStream;
		String line;
		try {
			carreraStream = openFileInput("carrera");
			InputStreamReader inputStreamReaderCarrera = new InputStreamReader(carreraStream);
			BufferedReader bufferedReaderCarrera = new BufferedReader(inputStreamReaderCarrera );
			carrera = new StringBuilder();
			while ((line = bufferedReaderCarrera.readLine()) != null) {
				carrera.append(line);
			}
		} catch (FileNotFoundException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		} catch (IOException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		}
		Log.d("Json", carrera.toString());
		
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

		if(tab.getText().equals(getResources().getString(R.string.sem1))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "1");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.sem2))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "2");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.sem3))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "3");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.sem4))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "4");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.sem5))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "5");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.sem6))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "6");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.sem7))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "7");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.sem8))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "8");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
			ft.add(android.R.id.content, f);
		}else if(tab.getText().equals(getResources().getString(R.string.sem9))){
			Bundle b = new Bundle();
			b.putString("json", carrera.toString());
			b.putString("sem", "9");
			f = (SherlockFragment) SherlockFragment.instantiate(this, CarreraFragment.class.getName(), b);
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
