package fr.sosmessagedecarte;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnnivActivity extends SosActivity {

	private static final String CATEGORY = "4ef65b69e4b0fdb1a330261c";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anniv);

		logo = (ImageView) findViewById(R.id.logo);
		logo.setImageResource(R.drawable.logo_anniv);

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