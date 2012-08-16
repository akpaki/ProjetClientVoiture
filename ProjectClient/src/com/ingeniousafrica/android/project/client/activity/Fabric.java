package com.ingeniousafrica.android.project.client.activity;

import com.ingeniousafrica.android.project.client.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class Fabric extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabric);

		//Recuperation des instances de nos objets creer 
		Spinner s1 = (Spinner)findViewById(R.id.spinner1);

		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);


		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s1marque);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s1.setAdapter(adapter);
		s1.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(
					AdapterView<?> parent, View view, int position, long id) {
				showToast("Spinner1: position=" + position + " id=" + id);
			}


			public void onNothingSelected(AdapterView<?> parent) {
				showToast("Spinner1: unselected");
			}
		});

	}

	protected void showToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

	}
	private static final String[] s1marque = { "Acura", "Benz", "BMW", "Ferrari", "Toyota"};

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:

			Intent intent = new Intent(this, Main.class);
			startActivity(intent);

			break;

		case R.id.button2:
			Intent intent2 = new Intent(this, ParcVoiture.class);
			startActivity(intent2);
			break;
		}

	}

}

