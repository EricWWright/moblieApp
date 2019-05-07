package com.EricWWright.ch20ex;

import android.app.Activity;
import android.os.Bundle;

import android.view.*;
//import android.view.Menu;
import android.view.View.*;
import android.widget.*;
import android.content.Intent;

public class Screen2 extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen2);
		
		// get Intent that launched this activity
		Intent myIntent = getIntent();
		// get Bundle that contains extra data
		Bundle bun = myIntent.getExtras();
		// pull the value from the bundle using our key
		String value = bun.getString("name");
		
		TextView tv = (TextView)findViewById(R.id.textView1);
		tv.setText("Hello " + value);
		
		Intent resultIntent = new Intent();
		resultIntent.putExtra("name", value);
		setResult(RESULT_OK,resultIntent);
		
		Button thirdScreen = (Button)findViewById(R.id.thirdScreen);
		thirdScreen.setOnClickListener(this);
		
		Button homeScreen = (Button)findViewById(R.id.homeScreen);
		homeScreen.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id == R.id.thirdScreen) {
			Intent screenSwap = new Intent(Screen2.this, Screen3.class);
			startActivity(screenSwap);
		}
		else if (id == R.id.homeScreen) {
			Intent screenSwap = new Intent(Screen2.this, Main.class);
			startActivity(screenSwap);
		}
		
		
	}
	
}
