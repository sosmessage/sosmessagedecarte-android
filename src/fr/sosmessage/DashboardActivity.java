package fr.sosmessage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Georgia.ttf");

		TextView anniv = (TextView) findViewById(R.id.textAnniv);
		anniv.setTypeface(tf);
		anniv.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, AnnivActivity.class);
				startActivity(intent);
			}
		});

		TextView pot = (TextView) findViewById(R.id.textPot);
		pot.setTypeface(tf);
		pot.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, PotActivity.class);
				startActivity(intent);
			}
		});

		TextView voeux = (TextView) findViewById(R.id.textVoeux);
		voeux.setTypeface(tf);
		voeux.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, VoeuxActivity.class);
				startActivity(intent);
			}
		});

		TextView valentin = (TextView) findViewById(R.id.textValentin);
		valentin.setTypeface(tf);
		valentin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, ValentineActivity.class);
				startActivity(intent);
			}
		});

		TextView rupture = (TextView) findViewById(R.id.textBreakUp);
		rupture.setTypeface(tf);
		rupture.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, BreakUpActivity.class);
				startActivity(intent);
			}
		});

		TextView newMessage = (TextView) findViewById(R.id.newMessage);
		newMessage.setTypeface(tf);
		newMessage.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, NewMessageActivity.class);
				startActivity(intent);
			}
		});

	}
}
