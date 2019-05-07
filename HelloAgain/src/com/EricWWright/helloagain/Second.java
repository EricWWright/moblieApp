package com.EricWWright.helloagain;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class Second extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		Intent secondIntent = getIntent();
		Bundle bun = secondIntent.getExtras();
		String strMsg = "";
		if (bun.getString("build") != null) {
			strMsg = "Your device is running Android version: " + bun.getString("build");
		}
		else if (bun.getLong("time") > 0) {
			strMsg = "The emulator has been running for: " + bun.getLong("time") + " milliseconds.";
			
		}
		
		TextView tv = (TextView)findViewById(R.id.secondText);
		tv.setText(strMsg);
		
	}

}
