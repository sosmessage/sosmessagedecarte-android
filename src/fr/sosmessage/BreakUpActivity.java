package fr.sosmessage;

import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.method.ScrollingMovementMethod;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BreakUpActivity extends SosActivity {

	private static final String CATEGORY = "4ec0d549e4b05ecd78eeceb1";

	private TextView message;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.breakup);

		logo = (ImageView) findViewById(R.id.logo);
		logo.setImageResource(R.drawable.logo_break_up);

		message = (TextView) findViewById(R.id.text);
		message.setMovementMethod(ScrollingMovementMethod.getInstance());
		message.setTypeface(messageFont);
		message.setText(getRandomMessage(CATEGORY));

		registerForContextMenu(message);

		Button myButton = (Button) findViewById(R.id.myButton);
		myButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				message.setText(getRandomMessage(CATEGORY));
			}
		});
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		menu.add(0, v.getId(), 0, "Iuse");
		menu.add(0, v.getId(), 1, "Iuse");

		// place your TextView's text in clipboard
		ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		clipboard.setText(message.getText());
	}
}