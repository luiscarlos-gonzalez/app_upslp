package com.kentverger.upslp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class CalificacionFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.list_calificacion_element, container, false);
		TextView p1 = (TextView) v.findViewById(R.id.Calificacion1Text);
		p1.setText(getArguments().getString("EX1P"));
		TextView p2 = (TextView) v.findViewById(R.id.Calificacion2Text);
		p2.setText(getArguments().getString("EX2P"));
		TextView p3 = (TextView) v.findViewById(R.id.Calificacion3Text);
		p3.setText(getArguments().getString("EX3P"));
		TextView fin = (TextView) v.findViewById(R.id.CalificacionFinalText);
		fin.setText(getArguments().getString("EXFINAL"));
		TextView ext = (TextView) v.findViewById(R.id.CalificacionExtraText);
		ext.setText(getArguments().getString("EXTRA"));
		return v;
	}

}
