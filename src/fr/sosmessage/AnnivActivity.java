package fr.sosmessage;

import android.os.Bundle;

public class AnnivActivity extends SosActivity {

	public AnnivActivity() {
		super("4ef65b69e4b0fdb1a330261c");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.anniv);
		super.onCreate(savedInstanceState);

		logo.setImageResource(R.drawable.logo_anniv);
		update();
	}
}