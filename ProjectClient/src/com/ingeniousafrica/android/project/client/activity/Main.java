package com.ingeniousafrica.android.project.client.activity;

import com.ingeniousafrica.android.project.client.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{

	// Définition des variables globales pour contenir nos controles
	Button button;
	EditText nom;
	EditText prenom;
	Spinner choix_couleur;
	Spinner choix_vitesse;



	/** Called when the activity is first created. */
	/**Début de l initialisation de notre activity avec la fonction onCreate */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//recuperation de l instance de notre objet spinner1 avec la methode findViewById ou creation des accesseurs vers nos controles
		Spinner s1 =(Spinner)findViewById(R.id.spinner1);

		nom = (EditText)findViewById(R.id.editText1);
		prenom = (EditText)findViewById(R.id.editText2);
		button = (Button)findViewById(R.id.button1);

		/** Mettons en place un ecouteur d evenement sur notre controle button */
		button.setOnClickListener(this);

		// Recuperation de nos données
		if(this.getIntent().getExtras() != null){
			String s = this.getIntent().getExtras().getString("Nom");
			nom.setText(s);
		}
		
		
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onCreate");
		
		//Rajout du "setResult"
		this.setResult(2000);
		
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

	/** Creation de tableau du choix des couleurs */
	private static final String S1couleur [] = { "Blanche", "Noire", "Bleue", "Verte", "Rouge"};

	private static final String s2vitesse [] = {"Automatique", "Mécanique"};

	//Gestion du clique
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			// Demandons a android de nous pousser une autre activity
			//Intent intent = new Intent(Main.this, Fabric.class);
			//startActivity(intent);
			Intent intent = new Intent(this, Fabric.class);
			//Envoie de datas a notre sous-activite
			intent.putExtra("Nom", "Bonjour");
			this.startActivityForResult(intent, 1000);


			break;

		default:
			break;
		}

	}
	
	
  // Recuperation des codes des datas de notre sous-activité
	//avec la methode "onActivityResult"
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Testons si notre code correspond au requestCode renvoye au dessus id 1000
		if(requestCode == 1000){
			//si c est ok Renvoyons le resultCode dans le Log
			Log.i("", ""+resultCode);
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}

	/** Fonction appelée Lorsque l activité de visible a l user */
	@Override
	protected void onStart() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("","onStart");
		super.onStart();
	}

	/** Fonction appelée lorsque l activité devien reellemet active et en cours d utilisation par l user */
	@Override
	protected void onResume() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onResume");
		super.onResume();
	}

	/** Fonction appelée lorsque l activité est en pause */
	@Override
	protected void onPause() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onPause");
		super.onPause();
	}

	/** Fonction appelée lorsque l activité est stopé par un autre programme du systeme */
	@Override
	protected void onStop() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onStop");
		super.onStop();
	}


	/** Fonction appelée a la fin de notre activity */
	@Override
	protected void onDestroy() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onDestroy");
		super.onDestroy();
	}








}

