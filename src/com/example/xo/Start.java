package com.example.xo;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Start extends Activity {

	public static MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);

		SharedPreferences settings = getSharedPreferences("COLORS", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("lineColor", "Black");
		editor.putString("bgColor", "White");
		editor.putString("OColor", "Yellow");
		editor.putString("XColor", "Red");
		editor.commit();
		
		AssetFileDescriptor afd = null;
		try {
			afd = getAssets().openFd("music.mp3");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		player = new MediaPlayer();
		try {
			player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),
					afd.getLength());
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			player.prepare();
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		player.start();

		Thread timer = new Thread() {
			@Override
			public void run() {
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					 Intent newActivity=new Intent(Start.this,Menu.class);
					 startActivity(newActivity);
					 finish();
				}
			}
		};
		timer.start();
	}
}
