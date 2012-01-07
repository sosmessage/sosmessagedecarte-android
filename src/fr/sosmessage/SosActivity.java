package fr.sosmessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.codehaus.jackson.map.ObjectMapper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import fr.sosmessage.domain.Message;

public abstract class SosActivity extends Activity {

	public static String[] CATEGORIES = { "4ef65b69e4b0fdb1a330261c",// anniv
			"4ebf92a4e4b0c140632178c1",// pot
			"4ef22510e4b0bd586e6f569d", // voeux
			"4ef2330ee4b0bd586e6f56c2", // saint valentin
			"4ec0d549e4b05ecd78eeceb1", // rupture
	};
	private static final String SERVER_URL = "";
	private static final String ERROR_MESSAGE = "Ooops ! Il semblerait qu'il soit impossible de récuper des messages.\nPeut-être pourriez-vous réessayer plus tard.";

	protected String category;
	private Typeface messageFont;
	protected ImageView logo;
	protected TextView messageView;
	protected TextView pseudoView;
	protected Button sosButton;

	protected DefaultHttpClient client = new DefaultHttpClient();

	public SosActivity(String category) {
		this.category = category;
		client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "SosMessageDeCarte user agent");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		messageFont = Typeface.createFromAsset(getAssets(), "fonts/Georgia.ttf");

		logo = (ImageView) findViewById(R.id.logo);

		messageView = (TextView) findViewById(R.id.text);
		messageView.setMovementMethod(ScrollingMovementMethod.getInstance());
		messageView.setTypeface(messageFont);

		sosButton = (Button) findViewById(R.id.myButton);
		sosButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				update();
			}
		});
	}

	protected void update() {
		Message message = getRandomMessage(category);
		messageView.setText(message.getText());
		pseudoView = (TextView) findViewById(R.id.pseudo);
		String pseudo = message.getContributorName();
		if (pseudo != null && pseudo.length() != 0)
			pseudoView.setText("—" + pseudo);
		else
			pseudoView.setText("");
	}

	protected void alert(String message) {
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setMessage(message);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		alertDialog.show();
	}

	protected Message getRandomMessage(String category) {
		String url = String.format("%s/api/v1/categories/%s/message", SERVER_URL, category);
		try {
			HttpResponse response = client.execute(new HttpGet(url));
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				out.close();
				return new ObjectMapper().readValue(out.toString(), Message.class);
			} else {
				alert(ERROR_MESSAGE);
				return null;
			}
		} catch (ClientProtocolException e) {
			alert(ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			alert(ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
	}
}