package com.EricWWright.ch20ex;

import android.app.Activity;
import android.os.Bundle;

import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.Intent;

public class Screen3 extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen3);
		
		Button secondScreen = (Button)findViewById(R.id.secondScreen);
		secondScreen.setOnClickListener(this);
		
		Button homeScreen = (Button)findViewById(R.id.homeScreen);
		homeScreen.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.secondScreen) {
			Intent screenSwap = new Intent(Screen3.this, Screen2.class);
			startActivity(screenSwap);
		}
		else if (id == R.id.homeScreen) {
			Intent screenSwap = new Intent(Screen3.this, Main.class);
			startActivity(screenSwap);
		}
		
	}

}
