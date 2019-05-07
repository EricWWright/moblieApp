package com.EricWWright.mypetactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	String[] pets = {"Dog", "Cat", "Bird", "Hamster", 
            "Ferret", "Snake"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
		
		ArrayAdapter<String> myAdapter = 
				   new ArrayAdapter<String> (this, 
				                         android.R.layout.simple_spinner_item, pets);
		Spinner spn = (Spinner)findViewById(R.id.MySpinner);
		spn.setAdapter(myAdapter);
		spn.setSelection(3);
		
		SeekBar sb = (SeekBar)findViewById(R.id.seekBar1);
		sb.setProgress(20);                 // set numeric value to 20
		sb.setMax(100);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
		String myText = "I have ";
		int id = v.getId();
		if (id == R.id.button1) {
			TextView tv = (TextView)findViewById(R.id.textView1);
			Spinner spn = (Spinner)findViewById(R.id.MySpinner);
			SeekBar sb = (SeekBar)findViewById(R.id.seekBar1);
			int seekValue = sb.getProgress();
			myText += seekValue + " ";
			
			int pos = spn.getSelectedItemPosition();
			myText += spn.getItemAtPosition(pos).toString()+"'s";
			
			tv.setText(myText);
		}
	}

}
