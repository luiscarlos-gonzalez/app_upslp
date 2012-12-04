package com.kentverger.upslp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

public class FaltasActivity extends SherlockActivity {
	private StringBuilder faltas;
	private JSONArray json;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		setTheme(R.style.UPSLPTheme);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.faltas_list);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("Tus faltas");
		
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
		try {
			json = new JSONArray( faltas.toString() );
		} catch (JSONException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		}
		
		FaltasAdapter adapter = new FaltasAdapter();
		ListView lista = (ListView)findViewById(R.id.faltasListView);
		lista.setAdapter(adapter);
		
	}
	
	public class FaltasAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return json.length();
		}

		@Override
		public Object getItem(int arg0) {
			Object element = null;
			try {
				element = json.get(arg0);
			} catch (JSONException e) {
				Log.d("Weird Shit Happening", e.getMessage());
			}
			return element;
		}

		@Override
		public long getItemId(int arg0) {
			long id = Long.parseLong(arg0+"");
			return id;
		}

		@Override
		public View getView(int pos, View v, ViewGroup parent) {

			if(v == null){
				LayoutInflater layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
				v = layoutInflater.inflate(R.layout.faltas_list_item, null);
			}
			
			
			TextView nombreMateria = (TextView)v.findViewById(R.id.nombre_materia_faltas);
			TextView faltasParcial1 = (TextView)v.findViewById(R.id.faltas_1);
			TextView faltasParcial2 = (TextView)v.findViewById(R.id.faltas_2);
			TextView faltasParcial3 = (TextView)v.findViewById(R.id.faltas_3);
			
			TextView p1 = (TextView) v.findViewById(R.id.parcial_1_label);
			TextView p2 = (TextView) v.findViewById(R.id.parcial_2_label);
			TextView p3 = (TextView) v.findViewById(R.id.parcial_3_label);

			

			Typeface font = Typeface.createFromAsset(getAssets(), "BenchNine-Regular.ttf");
			
			nombreMateria.setTypeface(font);
			faltasParcial1.setTypeface(font);
			faltasParcial2.setTypeface(font);
			faltasParcial3.setTypeface(font);
			p1.setTypeface(font);
			p2.setTypeface(font);
			p3.setTypeface(font);
			
			
			try {
				JSONObject jsonObject = json.getJSONObject(pos);
				int total  = Integer.parseInt(jsonObject.getString("INAS1")) + Integer.parseInt(jsonObject.getString("INAS2")) + Integer.parseInt(jsonObject.getString("INAS3"));
				
				if(total <= 4){
					v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
				}else if(total > 4){
					v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
				}else{
					v.setBackgroundDrawable(getResources().getDrawable(R.drawable.gris));
				}
				
				nombreMateria.setText(jsonObject.getString("NOMMATERIA"));
				faltasParcial1.setText(jsonObject.getString("INAS1"));
				faltasParcial2.setText(jsonObject.getString("INAS2"));
				faltasParcial3.setText(jsonObject.getString("INAS3"));
			} catch (JSONException e) {
				Log.d("Weird Shit Happening", e.getMessage());
			}
			return v;
		}
		
	}

}
