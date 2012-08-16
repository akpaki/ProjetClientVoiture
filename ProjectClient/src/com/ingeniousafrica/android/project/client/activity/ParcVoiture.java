package com.ingeniousafrica.android.project.client.activity;

import com.ingeniousafrica.android.project.client.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ParcVoiture extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parc);
		
		findViewById(R.id.button1).setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			
			Intent intent = new Intent(this, Fabric.class);
			startActivity(intent);
			
			break;

		//default:
		//	break;
		}
		
	}
	

}
