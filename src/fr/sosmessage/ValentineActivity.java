package fr.sosmessage;

import android.os.Bundle;

public class ValentineActivity extends SosActivity {

	public ValentineActivity() {
		super("4ef2330ee4b0bd586e6f56c2");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.valentine);
		super.onCreate(savedInstanceState);

		logo.setImageResource(R.drawable.logo_valentine);
		update();
	}
}