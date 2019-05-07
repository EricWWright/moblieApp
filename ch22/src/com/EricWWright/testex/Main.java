package com.EricWWright.testex;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		String myText ="";
		int id = v.getId();
		if (id == R.id.button1) {
			TextView tv = (TextView)findViewById(R.id.textView1);
//			EditText et = (EditText)findViewById(R.id.editText1);
//			myText = et.getText().toString();
			
		RadioButton rbRed = (RadioButton)findViewById(R.id.rbRed);
		RadioButton rbBlue = (RadioButton)findViewById(R.id.rbRed);
		
		if (rbRed.isChecked()) {
			myText = rbRed.getText().toString();
		}
		else if (rbBlue.isChecked()) {
			myText = rbBlue.getText().toString();
		}
		tv.setText(myText);
		}
		
	}

}
