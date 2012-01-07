package fr.sosmessage;

import android.os.Bundle;

public class PotActivity extends SosActivity {

	public PotActivity() {
		super("4ebf92a4e4b0c140632178c1");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.pot);
		super.onCreate(savedInstanceState);

		logo.setImageResource(R.drawable.logo_pot);
		update();
	}
}