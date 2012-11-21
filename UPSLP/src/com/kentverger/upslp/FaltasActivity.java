package com.kentverger.upslp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.util.Log;

import com.actionbarsherlock.app.SherlockActivity;

public class FaltasActivity extends SherlockActivity {
	private StringBuilder faltas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		super.onCreate(savedInstanceState);
		
		FileInputStream faltasStream;
		String line;
		try {
			faltasStream = openFileInput("faltas");
			InputStreamReader inputStreamReaderFaltas = new InputStreamReader(faltasStream);
			BufferedReader bufferedReaderFaltas = new BufferedReader(inputStreamReaderFaltas);
			faltas = new StringBuilder();
			while ((line = bufferedReaderFaltas.readLine()) != null) {
				faltas.append(line);
			}
		} catch (FileNotFoundException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		} catch (IOException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		}
		Log.d("Cadena", faltas.toString());
	}

}
