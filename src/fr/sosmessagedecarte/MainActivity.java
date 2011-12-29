package fr.sosmessagedecarte;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	private TabHost tabHost;
	private TabSpec tabSpec;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tabHost = getTabHost();
		tabSpec = tabHost.newTabSpec("pot").setIndicator("Pot")
				.setContent(new Intent(this, PotActivity.class));
		tabHost.addTab(tabSpec);

		tabSpec = tabHost.newTabSpec("anniv").setIndicator("Anniversaire")
				.setContent(new Intent(this, AnnivActivity.class));
		tabHost.addTab(tabSpec);

		tabSpec = tabHost.newTabSpec("voeux").setIndicator("Voeux")
				.setContent(new Intent(this, VoeuxActivity.class));
		tabHost.addTab(tabSpec);
	}
}
