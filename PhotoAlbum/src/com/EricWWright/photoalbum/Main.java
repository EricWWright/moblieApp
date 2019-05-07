package com.EricWWright.photoalbum;

import java.util.ArrayList;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LinearLayout myPhotos = (LinearLayout)findViewById(R.id.myPhotos);
		myPhotos.addView(createImageView(R.drawable.snow1));
		myPhotos.addView(createImageView(R.drawable.snow2));
		myPhotos.addView(createImageView(R.drawable.snow3));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	View createImageView(int resourceID) {
		ImageView iv = new ImageView(getApplicationContext());
		iv.setPadding(5,5,5,5);
		iv.setImageResource(resourceID);
		iv.setLayoutParams(new LayoutParams(180, 150));
		iv.setScaleType(ImageView.ScaleType.FIT_XY);
		return iv;
	}
}
