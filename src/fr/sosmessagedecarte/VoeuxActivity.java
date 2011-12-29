package fr.sosmessagedecarte;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VoeuxActivity extends SosActivity {

	private static final String CATEGORY = "4ef22510e4b0bd586e6f569d";

	private TextView text;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voeux);

		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Bodoni SvtyTwo OS ITC TT.dfont");
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