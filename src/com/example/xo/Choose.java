package com.example.xo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose extends Activity{
	
	Button onePlayer,twoPlayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose);
		onePlayer=(Button) findViewById(R.id.one_player);
		onePlayer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent newActivity=new Intent(getApplicationContext(),OnePlayer.class);
				 startActivity(newActivity);
//				 finish();
			}
		});
		
		twoPlayer=(Button) findViewById(R.id.two_player);
		twoPlayer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent newActivity=new Intent(getApplicationContext(),TwoPlayer.class);
				 startActivity(newActivity);
//				 finish();
			}
		});
	}
}
