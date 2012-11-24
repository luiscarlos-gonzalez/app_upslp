package com.kentverger.upslp;

import org.json.JSONArray;
import org.json.JSONException;

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
			if(dia.equals("Lunes")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINILUN");
					Log.d("Clase", tiene_calse);
					if(!tiene_calse.equals("null")){
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINLUN"));
						aula.setText(data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Martes")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINIMAR");
					Log.d("Clase", tiene_calse);
					if(!tiene_calse.equals("null")){
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINMAR"));
						aula.setText(data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Miercoles")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINIMIE");
					Log.d("Clase", tiene_calse);
					if(!tiene_calse.equals("null")){
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINMIE"));
						aula.setText(data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Jueves")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINIJUE");
					Log.d("Clase", tiene_calse);
					if(!tiene_calse.equals("null")){
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINJUE"));
						aula.setText(data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Viernes")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINIVIE");
					Log.d("Clase", tiene_calse);
					if(!tiene_calse.equals("null")){
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINVIE"));
						aula.setText(data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}else if(dia.equals("Sabado")){
				try {
					String tiene_calse = data.getJSONObject(pos).getString("HORINISAB");
					Log.d("Clase", tiene_calse);
					if(!tiene_calse.equals("null")){
						materia.setText(data.getJSONObject(pos).getString("MATERIA"));
						hora.setText(tiene_calse + " a " +data.getJSONObject(pos).getString("HORFINSAB"));
						aula.setText(data.getJSONObject(pos).getString("AULA"));
					}
				} catch (JSONException e) {
					Log.d("Weird Shit Happening", e.getMessage());
				}
			}
			return v;
		}


	}

}
