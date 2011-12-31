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
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class SosActivity extends Activity {

	private static final String SERVER_URL = "";
	private static final String ERROR_MESSAGE = "Ooops ! Il semblerait qu'il soit impossible de récuper des messages.\nPeut-être pourriez-vous réessayer plus tard.";
	protected Typeface messageFont;

	protected TextView message;
	protected ImageView logo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		messageFont = Typeface.createFromAsset(getAssets(), "fonts/Georgia.ttf");
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

	protected String getRandomMessage(String category) {
		String url = String.format("%s/api/v1/categories/%s/message", SERVER_URL, category);
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams()
					.setParameter(CoreProtocolPNames.USER_AGENT, "SosMessageDeCarte user agent");

			HttpResponse response = client.execute(new HttpGet(url));
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				out.close();
				JSONObject object = (JSONObject) new JSONTokener(out.toString()).nextValue();
				return object.getString("text");
			} else {
				alert(ERROR_MESSAGE);
				return "HTTP status code " + statusLine.getStatusCode();
			}
		} catch (ClientProtocolException e) {
			alert(ERROR_MESSAGE);
			return e.getMessage();
		} catch (IOException e) {
			alert(ERROR_MESSAGE);
			return e.getMessage();
		} catch (JSONException e) {
			return e.getMessage();
		}
	}
}