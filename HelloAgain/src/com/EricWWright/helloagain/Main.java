package com.EricWWright.helloagain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.Intent;

public class Main extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button osButton = (Button)findViewById(R.id.osButton);
		osButton.setOnClickListener(this);
		
		Button timeButton = (Button)findViewById(R.id.timeButton);
		timeButton.setOnClickListener(this);
		
		Button colorsButton = (Button)findViewById(R.id.colorsButton);
		colorsButton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.osButton) {
			Intent startosscreen = new Intent(Main.this, Second.class);
			startosscreen.putExtra("build", android.os.Build.VERSION.RELEASE);
			startActivity(startosscreen);
		}
		else if(id == R.id.timeButton) {
			Intent starttimescreen = new Intent(Main.this, Second.class);
			starttimescreen.putExtra("time", android.os.SystemClock.uptimeMillis());
			startActivity(starttimescreen);
		}
		else if (id == R.id.colorsButton) {
			Intent startcolorscreen = new Intent(Main.this, Third.class);
			startActivityForResult(startcolorscreen, 0);
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bundle bun = data.getExtras();
		String strval = bun.getString("color");
		if (strval != null) {
			TextView tv = (TextView)findViewById(R.id.helloWorld);
			tv.setText("Received color back: " + strval);
			RelativeLayout layout = (RelativeLayout)findViewById(R.id.MainLayout);
		}
	}

}
