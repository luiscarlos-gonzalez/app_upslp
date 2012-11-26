package com.kentverger.upslp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class CalificacionesActivity extends SherlockFragmentActivity implements ActionBar.TabListener{

	private StringBuilder calificaciones;
	private JSONArray calificaciones_array;
	private SherlockFragment f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		setTheme(R.style.UPSLPTheme);
		super.onCreate(savedInstanceState);
		
		FileInputStream calificacionesStream;
		String line;
		try {
			calificacionesStream = openFileInput("calificaciones");
			InputStreamReader inputStreamReaderCalificaciones = new InputStreamReader(calificacionesStream);
			BufferedReader bufferedReaderCalificaciones = new BufferedReader(inputStreamReaderCalificaciones);
			calificaciones = new StringBuilder();
			while ((line = bufferedReaderCalificaciones.readLine()) != null) {
				calificaciones.append(line);
			}
		} catch (FileNotFoundException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		} catch (IOException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		}
		Log.d("Cadena", calificaciones.toString());
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setTitle("Tus calificaciones");
		
		try {
			calificaciones_array = new JSONArray(calificaciones.toString());
			for(int x = 0; x<calificaciones_array.length(); x++){
				Tab tab = actionBar.newTab()
						.setText( calificaciones_array.getJSONObject(x).getString( "NOMMATERIA" ) )
						.setTabListener(this);
				actionBar.addTab(tab);
			}
		} catch (JSONException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		}
	
	}
	

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		String selectedTab = tab.getText().toString();
		
		for(int x = 0; x<calificaciones_array.length(); x++){
				try {
					if(calificaciones_array.getJSONObject(x).getString( "NOMMATERIA" ).equals(selectedTab)){
						Bundle b = new Bundle();
						b.putString("EX1P", calificaciones_array.getJSONObject(x).getString( "EX1P" ));
						b.putString("EX2P", calificaciones_array.getJSONObject(x).getString( "EX2P" ));
						b.putString("EX3P", calificaciones_array.getJSONObject(x).getString( "EX3P" ));
						b.putString("EXFINAL", calificaciones_array.getJSONObject(x).getString( "EXFINAL" ));
						b.putString("EXTRA", calificaciones_array.getJSONObject(x).getString( "EXTRA" ));
						b.putString("REGUL", calificaciones_array.getJSONObject(x).getString( "REGUL" ));
						f = (SherlockFragment) SherlockFragment.instantiate(this, CalificacionFragment.class.getName(), b);
						ft.add(android.R.id.content, f);
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				} 
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
