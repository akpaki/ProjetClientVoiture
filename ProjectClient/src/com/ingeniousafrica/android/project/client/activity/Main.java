package com.ingeniousafrica.android.project.client.activity;

import com.ingeniousafrica.android.project.client.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//recuperation de l instance de notre objet spinner1 avec la methode findViewById
		Spinner s1 =(Spinner)findViewById(R.id.spinner1);

		findViewById(R.id.editText1);
		findViewById(R.id.editText2);
		findViewById(R.id.button1).setOnClickListener(this);

		//Utilisation d un adapteur 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, S1couleur);
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


		Spinner s2 = (Spinner)findViewById(R.id.spinner2);

		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,s2vitesse);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s2.setAdapter(adapter2);
		s2.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(
					AdapterView<?> parent, View view, int position, long id) {
				showToast("Spinner2: position=" + position + " id=" + id);
			}

			public void onNothingSelected(AdapterView<?> parent) {
				showToast("Spinner2: unselected");
			}
		});

	}

	protected void showToast(String message) {
		// TODO Auto-generated method stub
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

	}

	// Creation de tableau du choix des couleurs
	private static final String S1couleur [] = { "Blanche", "Noire", "Bleue", "Verte", "Rouge"};

	private static final String s2vitesse [] = {"Automatique", "Mécanique"};

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			
			Intent intent = new Intent(Main.this, Fabric.class);
			startActivity(intent);
			
			break;

		default:
			break;
		}
		
	}

	
}

