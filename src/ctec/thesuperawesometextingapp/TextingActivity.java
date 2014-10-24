package ctec.thesuperawesometextingapp;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TextingActivity extends Activity
{
	private EditText smsMessageField;
	private EditText smsNumberField;
	private Button sendSMSButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_texting);
		
		smsMessageField = (EditText) findViewById(R.id.smsContentEditText);
		smsNumberField = (EditText) findViewById(R.id.smsNumberEditText);
		sendSMSButton = (Button) findViewById(R.id.sendSMSButton);
		
		setupListeners();
	}
	
	private void setupListeners()
	{
		sendSMSButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View currentView)
			{
				try
				{
					String contact = smsNumberField.getText().toString();
					String message = smsMessageField.getText().toString();
					sendSMS(contact, message);
					
					Toast.makeText(currentView.getContext(), "message was sent", Toast.LENGTH_SHORT).show();
				}
				catch(Exception currentException)
				{
					Toast.makeText(currentView.getContext(), "message was not sent", Toast.LENGTH_LONG).show();
					Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	/**
	 * 
	 * @param messageAddress The number this app sends a text to.
	 * @param messageContent The message we send to the person
	 */
	private void sendSMS(String messageAddress, String messageContent)
	{
		SmsManager mySMSManager = SmsManager.getDefault();
		mySMSManager.sendTextMessage(messageAddress, null, messageContent, null, null);
	}
}
