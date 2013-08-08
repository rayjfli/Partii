package com.example.partii_study;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView output;
	private Button regButton, logButton;
	private EditText nameText, passText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		output = (TextView) findViewById(R.id.output);
		regButton = (Button) findViewById(R.id.login_regButton);
		logButton = (Button) findViewById(R.id.login_loginButton);
		nameText = (EditText) findViewById(R.id.login_name);
		passText = (EditText) findViewById(R.id.login_password);
		
		regButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				output.setText("hi");
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
