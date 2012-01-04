package fr.sosmessage;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewMessageActivity extends SosActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newmessage);

		Spinner spinner = (Spinner) findViewById(R.id.category);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.category_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

	}
}