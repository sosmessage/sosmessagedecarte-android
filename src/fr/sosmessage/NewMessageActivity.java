package fr.sosmessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewMessageActivity extends Activity {

	protected DefaultHttpClient client = new DefaultHttpClient();

	public NewMessageActivity() {
		client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "SosMessageDeCarte user agent");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newmessage);

		final Spinner spinner = (Spinner) findViewById(R.id.category);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.category_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		Button cancel = (Button) findViewById(R.id.cancel);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		final EditText editMessage = (EditText) findViewById(R.id.message);
		final EditText editPseudo = (EditText) findViewById(R.id.pseudo);

		Button button = (Button) findViewById(R.id.ok);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println(SosActivity.CATEGORIES[spinner.getSelectedItemPosition()]);
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("text", editMessage.getText().toString()));
				String pseudo = editPseudo.getText().toString();
				if (pseudo != null)
					params.add(new BasicNameValuePair("contributorName", pseudo));
				String request = String.format(
						"http://sosmessagedetest.arnk.fr/api/v1/categories/%s/message",
						SosActivity.CATEGORIES[spinner.getSelectedItemPosition()]);
				HttpPost post = new HttpPost(request);

				try {
					post.setEntity(new UrlEncodedFormEntity(params));
					post.getParams().setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, Boolean.FALSE);
					client.execute(post);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				thanks();
			}
		});
	}

	protected void thanks() {
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog
				.setMessage("Merci pour votre contribution.\nVotre message sera modéré et disponible très prochainement à tous les utilisateurs.");
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		alertDialog.show();
	}

}
