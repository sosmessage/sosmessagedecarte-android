package fr.sosmessagedecarte;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class SosActivity extends Activity {

	private static final String SERVER_URL = "http://sosmessage.arnk.fr";

	private static final String ERROR_MESSAGE = "Ooops ! Il semblerait qu'il soit impossible de récuper des messages.\nPeut-être pourriez-vous réessayer plus tard.";

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
			HttpResponse response = new DefaultHttpClient().execute(new HttpGet(url));
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