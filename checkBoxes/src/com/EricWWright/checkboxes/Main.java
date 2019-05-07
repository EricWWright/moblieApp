package com.EricWWright.checkboxes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Main extends Activity implements OnClickListener{

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
			CheckBox cbDog = (CheckBox)findViewById(R.id.checkBox1);
			CheckBox cbCat = (CheckBox)findViewById(R.id.checkBox2);
			CheckBox cbBird = (CheckBox)findViewById(R.id.checkBox3);
			if (cbDog.isChecked()) {
				myText += cbDog.getText().toString() + " ";
			}
			if (cbCat.isChecked()) {
				myText += cbCat.getText().toString() + " ";
			}
			if (cbBird.isChecked()) {
				myText += cbBird.getText().toString() + " ";
			}
			tv.setText(myText);
		}
		
	}

}
