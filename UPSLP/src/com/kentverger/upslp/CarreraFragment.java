package com.kentverger.upslp;

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

import com.actionbarsherlock.app.SherlockFragment;

public class CarreraFragment extends SherlockFragment {
	
	private String semestre;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.listviewcontent, container, false);
		String Json = getArguments().getString("json");
		semestre = getArguments().getString("sem");
		
		try {
			if(semestre.equals("1")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(0);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}else if(semestre.equals("2")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(1);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}else if(semestre.equals("3")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(2);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}else if(semestre.equals("4")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(3);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}else if(semestre.equals("5")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(4);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}else if(semestre.equals("6")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(5);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}else if(semestre.equals("7")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(6);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}else if(semestre.equals("8")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(7);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}else if(semestre.equals("9")){
				JSONArray horario_json = new JSONArray(Json).getJSONArray(8);
				CarreraAdapter adapter = new CarreraAdapter(horario_json);
				ListView lista = (ListView)v.findViewById(R.id.listView1);
				lista.setAdapter(adapter);
			}
		} catch (JSONException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		}
		return v;
	}
	public class CarreraAdapter extends BaseAdapter {

		private JSONArray data;
		
		public CarreraAdapter(JSONArray data) {
			super();
			this.data = data;
		}

		@Override
		public int getCount() {
			return data.length();
		}

		public Object getItem(int arg0) {
			Object element = null;
			try {
				element = data.get(arg0);
			} catch (JSONException e) {
				Log.d("Weird Shit Happening", e.getMessage());
			} 
			return element;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int pos, View v, ViewGroup parent) {
			if(v == null){
				LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
				v = layoutInflater.inflate(R.layout.carrera_list_item, null);
			}
			Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "BenchNine-Regular.ttf");
			
			TextView materia = (TextView) v.findViewById(R.id.Materia);
			TextView seriacion = (TextView) v.findViewById(R.id.Seriacion);
			
			materia.setTypeface(font);
			seriacion.setTypeface(font);
			


			try {
				JSONObject semestre = data.getJSONObject(pos);
				materia.setText(semestre.getString("MATERIA"));
				String calfinal = semestre.getString("CALFIN");
				String calextra = semestre.getString("EXTRA");
				String calregu = semestre.getString("REGU");
				
				if(!calregu.equals(" ")){
					seriacion.setText(calregu);
					v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
				}else if(!calextra.equals(" ")){
					seriacion.setText(calextra);
					v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
				}else if(!calfinal.equals(" ")){
					seriacion.setText(calfinal);
					v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
				}
				if(calfinal.equals("-1")){
					seriacion.setText("");
					v.setBackgroundDrawable(getResources().getDrawable(R.drawable.gris));
				}
				if(calfinal.equals(" ")){
					v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
				}
			} catch (JSONException e) {
				Log.d("Weird Shit Happening", e.getMessage());
			}
			return v;
		}
		
	}

}
