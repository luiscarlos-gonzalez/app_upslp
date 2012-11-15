package com.kentverger.upslp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Jsoup;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Upslp extends Activity {

	private ProgressBar p;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upslp);

		p = (ProgressBar) findViewById(R.id.progressBar1);
		p.setProgress(0);
		//Checa si el device esta conectado o no
		if(isOnline()){
			//Ejecuta la tarea asincrona
			new ObtenInfoUsuario().execute("070521");
		}else {
			Toast.makeText(getApplicationContext(), "No tienes conexion a Interné :(", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_upslp, menu);
		return true;
	}

	/**
	 * Hace la peticion asincrona
	 * 
	 * @author kentverger
	 *
	 */
	public class ObtenInfoUsuario extends AsyncTask<String, Integer, String[]>{
		/**
		 * Acutaliza la UI
		 * 
		 */
		@Override
		protected void onProgressUpdate(Integer... values) {
			p.setProgress(values[0]);
			super.onProgressUpdate(values);
		}
		/**
		 * Ejecuta esto cuando termina la peticion
		 * 
		 */
		@Override
		protected void onPostExecute(String[] result) {
			//Nombre de los archivos almacenados internamente
			String BASIC_INFO_FILENAME = "basic_info";
			String FALTAS_FILENAME = "faltas";
			String HORARIO_FILENAME = "horario";
			String CALIFICACIONES_FILENAME = "calificaciones";


			try {
				//Crean los archivos para almacenar la informacion
				FileOutputStream fos_b = openFileOutput(BASIC_INFO_FILENAME, Context.MODE_PRIVATE);
				FileOutputStream fos_f = openFileOutput(FALTAS_FILENAME, Context.MODE_PRIVATE);
				FileOutputStream fos_h = openFileOutput(HORARIO_FILENAME, Context.MODE_PRIVATE);
				FileOutputStream fos_c = openFileOutput(CALIFICACIONES_FILENAME, Context.MODE_PRIVATE);

				//Guarda en los archivos la informacion
				fos_b.write(result[0].getBytes());
				fos_b.close();

				fos_f.write(result[1].getBytes());
				fos_f.close();

				fos_h.write(result[2].getBytes());
				fos_h.close();

				fos_c.write(result[3].getBytes());
				fos_c.close();

			} catch (FileNotFoundException e) {
				Log.d("Weird Shit Happening", e.getMessage());
			} catch (IOException e) {
				Log.d("Weird Shit Happening", e.getMessage());
			}

			super.onPostExecute(result);
		}
		/**
		 * Esto hace la peticion al servidor
		 * 
		 */
		@Override
		protected String[] doInBackground(String... arg0) {

			String[] result = new String[4];

			Log.d("Data", arg0[0]);

			try {
				//Obtiene la informacion basica del usuario
				String basic_info_string = Jsoup.connect("http://192.168.31.222/upslp/index.php/upslp/index/" + arg0[0])
						.get()
						.text();
				publishProgress(1);
				//Obtiene la informacion de las faltas
				String faltas_info_string = Jsoup.connect("http://192.168.31.222/upslp/index.php/upslp/faltas/" + arg0[0])
						.get()
						.text();
				publishProgress(2);
				//Obtiene la informacion del horario
				String horario_info_string = Jsoup.connect("http://192.168.31.222/upslp/index.php/upslp/horario/" + arg0[0])
						.get()
						.text();
				publishProgress(3);
				//Obtiene la informacion claificaciones
				String calificaciones_info_string = Jsoup.connect("http://192.168.31.222/upslp/index.php/upslp/calificaciones/" + arg0[0])
						.get()
						.text();
				publishProgress(4);
				result[0] = basic_info_string;
				Log.d("Response", basic_info_string);
				result[1] = faltas_info_string;
				Log.d("Response", faltas_info_string);
				result[2] = horario_info_string;
				Log.d("Response", horario_info_string);
				result[3] = calificaciones_info_string;
				Log.d("Response", calificaciones_info_string);


			} catch (IOException e) {
				Log.d("Weird Shit Happening", e.getMessage());
			}
			return result;
		}

	}
	/**
	 * Verifica si esta conectado o no
	 * 
	 * @return
	 */
	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo netInfo = cm.getActiveNetworkInfo();

		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}

		return false;
	}
}
