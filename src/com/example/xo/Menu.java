package com.example.xo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {

	Button start,options,about;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		start=(Button) findViewById(R.id.startGame);
		options=(Button) findViewById(R.id.options);
		about=(Button) findViewById(R.id.about);
		
		addClickListeners();
	}

	private void addClickListeners() {
		start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent newActivity=new Intent(getApplicationContext(),Choose.class);
				startActivity(newActivity);
//				finish();
			}
		});
		
		options.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent newActivity=new Intent(getApplicationContext(),Options.class);
				startActivity(newActivity);
//				finish();
			}
		});
		
		about.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent newActivity=new Intent(getApplicationContext(),About.class);
				startActivity(newActivity);
//				finish();
			}
		});
	}
}
