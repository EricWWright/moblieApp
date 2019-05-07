package com.EricWWright.helloagain;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class Third extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		Button redButton = (Button)findViewById(R.id.redButton);
		redButton.setOnClickListener(this);
		
		Button blueButton = (Button)findViewById(R.id.blueButton);
		blueButton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		Intent colorIntent = new Intent();
		if (id == R.id.redButton) {
			colorIntent.putExtra("color", "red");
		}
		else if (id == R.id.blueButton) {
			colorIntent.putExtra("color", "blue");
		}
		setResult(0, colorIntent);
		finish();
		
	}

}
