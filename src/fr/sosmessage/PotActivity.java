package fr.sosmessage;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PotActivity extends SosActivity {

	private static final String CATEGORY = "4ebf92a4e4b0c140632178c1";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pot);

		logo = (ImageView) findViewById(R.id.logo);
		logo.setImageResource(R.drawable.logo_pot);

		message = (TextView) findViewById(R.id.text);
		message.setMovementMethod(ScrollingMovementMethod.getInstance());
		message.setTypeface(messageFont);
		message.setText(getRandomMessage(CATEGORY));

		Button myButton = (Button) findViewById(R.id.myButton);
		myButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				message.setText(getRandomMessage(CATEGORY));
			}
		});
	}
}