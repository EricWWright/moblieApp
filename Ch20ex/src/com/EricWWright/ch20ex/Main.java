package com.EricWWright.ch20ex;

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
		
		Button secondScreen = (Button)findViewById(R.id.secondScreen);
		secondScreen.setOnClickListener(this);
		
		Button thirdScreen = (Button)findViewById(R.id.thirdScreen);
		thirdScreen.setOnClickListener(this);
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
		if (id == R.id.secondScreen) {
			EditText edit = (EditText)findViewById(R.id.editText1);
			String nameString = edit.getText().toString();
			
			Intent screenSwap = new Intent(Main.this, Screen2.class);
			screenSwap.putExtra("name", nameString);
			
			startActivityForResult(screenSwap,0);
		}
		else if(id == R.id.thirdScreen) {
			Intent screenSwap = new Intent(Main.this, Screen3.class);
			startActivity(screenSwap);
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bundle bun = data.getExtras();
		String value = bun.getString("name");
		
		TextView tv = (TextView)findViewById(R.id.textView1);
		tv.setText("Received name back: " + value);
	}

}
