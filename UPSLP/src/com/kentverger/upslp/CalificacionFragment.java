package com.kentverger.upslp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class CalificacionFragment extends SherlockFragment {

	private TextView p3;
	private TextView p2;
	private TextView p1;
	private TextView fin;
	private TextView finfin;
	private TextView extra;
	
	private TextView l3;
	private TextView l2;
	private TextView l1;
	private TextView lfin;
	private TextView lfinfin;
	private TextView lextra;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.list_calificacion_element, container, false);
		
		p1 = (TextView) v.findViewById(R.id.Calificacion1Text);
		p2 = (TextView) v.findViewById(R.id.Calificacion2Text);
		p3 = (TextView) v.findViewById(R.id.Calificacion3Text);
		fin = (TextView) v.findViewById(R.id.CalificacionFinalText);
		finfin = (TextView) v.findViewById(R.id.CalificacionFinalFinalText);
		extra = (TextView) v.findViewById(R.id.CalificacionFinalFinalText);
		
		l1 = (TextView) v.findViewById(R.id.parcial1Text);
		l2 = (TextView) v.findViewById(R.id.parcial2Text);
		l3 = (TextView) v.findViewById(R.id.parcial3Text);
		lfin = (TextView) v.findViewById(R.id.finalText);
		lfinfin = (TextView) v.findViewById(R.id.finalFinalText);
		lextra = (TextView) v.findViewById(R.id.extraText);
		
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "BenchNine-Regular.ttf");
		
		p1.setTypeface(font);
		p2.setTypeface(font);
		p3.setTypeface(font);
		fin.setTypeface(font);
		finfin.setTypeface(font);
		extra.setTypeface(font);
		l1.setTypeface(font);
		l2.setTypeface(font);
		l3.setTypeface(font);
		lfin.setTypeface(font);
		lfinfin.setTypeface(font);
		lextra.setTypeface(font);
		
		if(getArguments().getString("EX1P").equals(" ")){
			p1.setText("0");
		}else {
			p1.setText(getArguments().getString("EX1P"));
		}
		
		if(getArguments().getString("EX2P").equals(" ")){
			p2.setText("0");
		}else {
			p2.setText(getArguments().getString("EX2P"));
		}
		SeekBar sb = (SeekBar) v.findViewById(R.id.seekBar2);
		if(!getArguments().getString("EX2P").equals(" ")){
			sb.setEnabled(false);
			sb.setVisibility(View.INVISIBLE);
		}
		sb.setMax(20);
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {

				float num = Float.parseFloat(arg1+"");
				
				p1.setText(num/2+"");
				float finalFinal = (Float.parseFloat(p1.getText().toString()) + Float.parseFloat(p2.getText().toString()) + Float.parseFloat(p3.getText().toString()))/3;			
				float examenFinal = Float.parseFloat(fin.getText().toString());
				finfin.setText((finalFinal*.4)+(examenFinal*.6)+"");
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		if(getArguments().getString("EX3P").equals(" ")){
			p3.setText("0");
		}else {
			p3.setText(getArguments().getString("EX3P"));
		}
		SeekBar sb2 = (SeekBar) v.findViewById(R.id.seekBar3);
		if(!getArguments().getString("EX3P").equals(" ")){
			sb2.setEnabled(false);
			sb2.setVisibility(View.INVISIBLE);
		}
		sb2.setMax(20);
		sb2.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				
				float num = Float.parseFloat(arg1+"");
				
				p3.setText(num/2+"");
				float finalFinal = (Float.parseFloat(p1.getText().toString()) + Float.parseFloat(p2.getText().toString()) + Float.parseFloat(p3.getText().toString()))/3;			
				float examenFinal = Float.parseFloat(fin.getText().toString());
				finfin.setText((finalFinal*.4)+(examenFinal*.6)+"");
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				p3.setText("0");
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		if(getArguments().getString("EXFINAL").equals(" ")){
			fin.setText("0");
		}else {
			fin.setText(getArguments().getString("EXFINAL"));
		}
		SeekBar sb3 = (SeekBar) v.findViewById(R.id.seekBar4);
		if(!getArguments().getString("EXFINAL").equals(" ")){
			sb3.setEnabled(false);
			sb3.setVisibility(View.INVISIBLE);
		}
		sb3.setMax(20);
		sb3.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {

				float num = Float.parseFloat(arg1+"");
				
				fin.setText(num/2+"");
				float finalFinal = (Float.parseFloat(p1.getText().toString()) + Float.parseFloat(p2.getText().toString()) + Float.parseFloat(p3.getText().toString()))/3;			
				float examenFinal = Float.parseFloat(fin.getText().toString());
				finfin.setText((finalFinal*.4)+(examenFinal*.6)+"");
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		TextView ext = (TextView) v.findViewById(R.id.CalificacionExtraText);
		ext.setText(getArguments().getString("EXTRA"));
		return v;
	}

}
