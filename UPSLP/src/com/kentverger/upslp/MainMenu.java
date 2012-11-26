package com.kentverger.upslp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainMenu extends SherlockActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.UPSLPTheme);
		setContentView(R.layout.main_menu);
		
		Button b_horario = (Button) findViewById(R.id.horario_btn);
		Button b_carrera = (Button) findViewById(R.id.carrera_btn);
		Button b_calificacion = (Button) findViewById(R.id.calificaciones_btn);
		Button b_faltas = (Button) findViewById(R.id.faltas_btn);
		  
		Typeface font = Typeface.createFromAsset(getAssets(), "BenchNine-Regular.ttf");  
		
		b_horario.setTypeface(font);
		b_carrera.setTypeface(font);
		b_calificacion.setTypeface(font);
		b_faltas.setTypeface(font);
		

		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("UPSLP");
		//actionBar.setBackgroundDrawable(R.drawable.actionbar_style);
		
		b_calificacion.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent calificaciones_intent = new Intent(getApplicationContext(), CalificacionesActivity.class);
				startActivity(calificaciones_intent);
			}
			
		});
		b_horario.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent horario_intent = new Intent(getApplicationContext(), HorarioActivity.class);
				startActivity(horario_intent);
			}
			
		});
		
		b_carrera.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent horario_intent = new Intent(getApplicationContext(), CarreraActivity.class);
				startActivity(horario_intent);
			}
			
		});
		
		b_faltas.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent horario_intent = new Intent(getApplicationContext(), FaltasActivity.class);
				startActivity(horario_intent);
			}
			
		});
		
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Recargar")
		.setIcon(android.R.drawable.ic_popup_sync)
		.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		Intent calificaciones_intent = new Intent(getApplicationContext(), Upslp.class);
		startActivity(calificaciones_intent);
		
		return super.onOptionsItemSelected(item);
	}
	
	

}
