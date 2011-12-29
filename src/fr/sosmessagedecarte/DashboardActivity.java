package fr.sosmessagedecarte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		TextView anniv = (TextView) findViewById(R.id.textAnniv);
		anniv.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, AnnivActivity.class);
				startActivity(intent);
			}
		});

		TextView pot = (TextView) findViewById(R.id.textPot);
		pot.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, PotActivity.class);
				startActivity(intent);
			}
		});

		TextView voeux = (TextView) findViewById(R.id.textVoeux);
		voeux.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(DashboardActivity.this, VoeuxActivity.class);
				startActivity(intent);
			}
		});
	}
}
