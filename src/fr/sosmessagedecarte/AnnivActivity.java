package fr.sosmessagedecarte;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnnivActivity extends SosActivity {

	private static final String CATEGORY = "4ef65b69e4b0fdb1a330261c";

	private TextView text;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anniv);

		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Georgia.ttf");
		text = (TextView) findViewById(R.id.text);
		text.setMovementMethod(ScrollingMovementMethod.getInstance());
		text.setTypeface(tf);
		text.setText(getRandomMessage(CATEGORY));

		Button myButton = (Button) findViewById(R.id.myButton);
		myButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				text.setText(getRandomMessage(CATEGORY));
			}
		});
	}
}