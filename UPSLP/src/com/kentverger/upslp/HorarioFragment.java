package com.kentverger.upslp;

import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONException;

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

public class HorarioFragment extends SherlockFragment {
	private String dia;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.listviewcontent, container, false);
		String Json = getArguments().getString("json");
		Log.d("JSON", Json);
		dia = getArguments().getString("dia");
		try {
			JSONArray horario_json = new JSONArray(Json);
			HorarioAdapter adapter = new HorarioAdapter(horario_json);
			ListView lista = (ListView)v.findViewById(R.id.listView1);
			lista.setAdapter(adapter);
		} catch (JSONException e) {
			Log.d("Weird Shit Happening", e.getMessage());
		}

		
		return v;
	}
	public class HorarioAdapter extends BaseAdapter {

		private JSONArray data;

		public HorarioAdapter(JSONArray data) {
			super();
			this.data = data;
		}

		@Override
		public int getCount() {
			return data.length();
		}

		@Override
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
			String[] element = null;
			try {
				element = data.getJSONObject(arg0).getString("CVEGPO").split("-");
			} catch (JSONException e) {
				Log.d("Weird Shit Happening", e.getMessage());
			}
			return Long.parseLong(element[1]);
		}

		@Override
		public View getView(int pos, View v, ViewGroup parent) {
			if(v == null){
				LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
				v = layoutInflater.inflate(R.layout.list_item_horario, null);
			}
			TextView materia = (TextView) v.findViewById(R.id.horario_materia);
			TextView hora = (TextView) v.findViewById(R.id.horario_hora);
			TextView aula = (TextView) v.findViewById(R.id.aula);
			
			v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
			
			Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "BenchNine-Regular.ttf");
			materia.setTypeface(font);
			hora.setTypeface(font);
			aula.setTypeface(font);
			
			if(dia.equals("Lunes")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINILUN");
					//Log.d("Clase", tiene_calse);
					if(!tiene_calse.equals("null")){
						int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
						int horario = Integer.parseInt(data.getJSONObject(pos).getString("HORFINLUN").substring(0, 2));
						if(horario < hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.gris));
						}else if(horario == hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
						}else if(horario > hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
						}
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINLUN"));
						aula.setText("Aula: " + data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Martes")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINIMAR");
					if(!tiene_calse.equals("null")){
						int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
						int horario = Integer.parseInt(data.getJSONObject(pos).getString("HORINIMAR").substring(0, 2));
						if(horario < hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.gris));
						}else if(horario == hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
						}else if(horario > hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
						}
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINMAR"));
						aula.setText("Aula: " + data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Miercoles")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINIMIE");
					if(!tiene_calse.equals("null")){
						int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
						int horario = Integer.parseInt(data.getJSONObject(pos).getString("HORINIMIE").substring(0, 2));
						if(horario < hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.gris));
						}else if(horario == hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
						}else if(horario > hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
						}
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINMIE"));
						aula.setText("Aula: " + data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Jueves")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINIJUE");
					if(!tiene_calse.equals("null")){
						int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
						int horario = Integer.parseInt(data.getJSONObject(pos).getString("HORINIJUE").substring(0, 2));
						if(horario < hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.gris));
						}else if(horario == hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
						}else if(horario > hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
						}
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINJUE"));
						aula.setText("Aula: " + data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Viernes")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINIVIE");
					if(!tiene_calse.equals("null")){
						int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
						int horario = Integer.parseInt(data.getJSONObject(pos).getString("HORINIVIE").substring(0, 2));
						if(horario < hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.gris));
						}else if(horario == hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
						}else if(horario > hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
						}
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINVIE"));
						aula.setText("Aula: " + data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Sabado")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINISAB");
					if(!tiene_calse.equals("null")){
						int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
						int horario = Integer.parseInt(data.getJSONObject(pos).getString("HORINISAB").substring(0, 2));
						if(horario < hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.gris));
						}else if(horario == hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.amarillo));
						}else if(horario > hour){
							v.setBackgroundDrawable(getResources().getDrawable(R.drawable.verde));
						}
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINSAB"));
						aula.setText("Aula: " + data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}
			return v;
		}


	}

}
