package fr.sosmessage;

import android.os.Bundle;

public class BreakUpActivity extends SosActivity {

	public BreakUpActivity() {
		super("4ec0d549e4b05ecd78eeceb1");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.breakup);
		super.onCreate(savedInstanceState);

		logo.setImageResource(R.drawable.logo_break_up);
		update();
	}

}