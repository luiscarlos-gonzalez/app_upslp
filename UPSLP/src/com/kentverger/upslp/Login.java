package com.kentverger.upslp;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends SherlockActivity {

	private EditText matricula;
	private EditText password;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.UPSLPTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("Login");
        
        Button acceder = (Button) findViewById(R.id.acceder);
        matricula = (EditText) findViewById(R.id.usuario_input);
        password = (EditText) findViewById(R.id.password);
        TextView usuario_lab = (TextView) findViewById(R.id.mat_label);
        TextView password_lab = (TextView) findViewById(R.id.pass_lab); 
        

		Typeface font = Typeface.createFromAsset(getAssets(), "BenchNine-Regular.ttf");
		acceder.setTypeface(font);
		usuario_lab.setTypeface(font);
		password_lab.setTypeface(font);
		matricula.setTypeface(font);
		password.setTypeface(font);
        acceder.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
        	   if(!matricula.getText().toString().equals("")){
            	   Intent i = new Intent(Login.this, Upslp.class);
            	   i.putExtra("matricula", matricula.getText().toString());
            	   startActivity(i);
        	   }
           }
        });
        
    }
}