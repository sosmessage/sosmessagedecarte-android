package fr.sosmessage;

import android.os.Bundle;

public class VoeuxActivity extends SosActivity {

	public VoeuxActivity() {
		super("4ef22510e4b0bd586e6f569d");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.voeux);
		super.onCreate(savedInstanceState);

		logo.setImageResource(R.drawable.logo_voeux);
		update();
	}

}