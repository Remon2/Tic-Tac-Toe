package com.example.xo;

import com.example.xo.R.color;
import com.example.xo.R.string;

import android.R.menu;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract.Colors;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Options extends Activity {

	// String[] colors = { "Default", "White", "Black", "Blue", "Red", "Yellow",
	// "gray", "green" };

	String[] colors = { "Default","White", "Black", "Blue", "Red", "Yellow", "silver",
			"gray", "maroon", "green", "Ivory", "FloralWhite", "Orange",
			"LightSalmon", "DarkOrange", "Tomato", "DeepPink", "Peru" };
	ToggleButton musicToggle;
	String bgColor = "", linesColor = "", OColor = "", XColor = "";
	TableLayout table;
	Spinner bgSpinner, lineSpinner, oSpinner, xSpinner;
	Button apply, cancel;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);

		musicToggle = (ToggleButton) findViewById(R.id.toggle);
		musicToggle.toggle();
		musicToggle.setChecked(true);
		table = (TableLayout) findViewById(R.id.play_grid);
		bgColor = "White";
		linesColor = "Black";
		OColor = "Red";
		XColor = "Green";
		apply = (Button) findViewById(R.id.ok);
		cancel = (Button) findViewById(R.id.cancel);
		bgSpinner = (Spinner) findViewById(R.id.colorSpinner);

		lineSpinner = (Spinner) findViewById(R.id.lineSpinner);
		oSpinner = (Spinner) findViewById(R.id.oSpinner);
		xSpinner = (Spinner) findViewById(R.id.xSpinner);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, colors);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		bgSpinner.setAdapter(adapter);
		lineSpinner.setAdapter(adapter);
		oSpinner.setAdapter(adapter);
		xSpinner.setAdapter(adapter);
		addListenerOnSpinnerItemSelection();
		addButtonListener();
	}

	@SuppressLint("ShowToast")
	private void addButtonListener() {

		musicToggle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (musicToggle.isChecked()) {
					Start.player.start();
					Toast.makeText(getApplicationContext(), "ON", 1000).show();
				} else {
					Toast.makeText(getApplicationContext(), "OFF", 1000).show();
					Start.player.pause();
				}
			}
		});

		apply.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("ResourceAsColor")
			@Override
			public void onClick(View v) {
				if (XColor.equalsIgnoreCase(bgColor)
						|| OColor.equalsIgnoreCase(bgColor)) {
					if ((!XColor.equalsIgnoreCase(colors[0]) || !OColor
							.equalsIgnoreCase(colors[0]))
							&& !bgColor.equalsIgnoreCase(colors[0])) {
						Toast.makeText(
								getApplicationContext(),
								"Color of the background must be different from the markers.",
								1000).show();
						return;
					}
				}
				if ((XColor.equalsIgnoreCase("Default") && bgColor
						.equalsIgnoreCase("Black"))
						|| (XColor.equalsIgnoreCase("White") && bgColor
								.equalsIgnoreCase("Default"))) {
					Toast.makeText(
							getApplicationContext(),
							"The color of X marker and the color of the background are the same!!!",
							1000).show();
					return;
				}
				if ((OColor.equalsIgnoreCase("Default") && bgColor
						.equalsIgnoreCase("Red"))
						|| (OColor.equalsIgnoreCase("White") && bgColor
								.equalsIgnoreCase("Default"))) {
					Toast.makeText(
							getApplicationContext(),
							"The color of O marker and the color of the background are the same!!!",
							1000).show();
					return;
				}
				SharedPreferences settings = getSharedPreferences("COLORS", 0);
				SharedPreferences.Editor editor = settings.edit();
				editor.putString("lineColor", linesColor);
				editor.putString("bgColor", bgColor);
				editor.putString("OColor", OColor);
				editor.putString("XColor", XColor);
				editor.commit();
				Intent intent = new Intent(getApplicationContext(), Menu.class);
				startActivity(intent);
//				finish();
			}
		});

		cancel.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("ResourceAsColor")
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getApplicationContext(), Menu.class);
				startActivity(intent);
//				finish();
			}
		});
	}

	private void addListenerOnSpinnerItemSelection() {
		bgSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// Toast.makeText(getApplicationContext(),
				// "Color is " + colors[position], 1000).show();
				bgColor = colors[position];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		lineSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				linesColor = colors[position];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		oSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// Toast.makeText(getApplicationContext(),
				// "Color is " + colors[position], 1000).show();
				OColor = colors[position];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		xSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// Toast.makeText(getApplicationContext(),
				// "Color is " + colors[position], 1000).show();
				XColor = colors[position];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
}
