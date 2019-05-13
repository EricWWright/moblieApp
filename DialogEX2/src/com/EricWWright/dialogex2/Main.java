package com.EricWWright.dialogex2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.app.*;
import android.content.DialogInterface;
import android.widget.*;

public class Main extends Activity {
	
	public static class MyAlertDialog extends DialogFragment {
		   String[] pets = {"Dog", "Cat", "Horse"};  
		   // data array for alert list
		
		   public Dialog onCreateDialog(Bundle savedInstanceState) {
			   AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
			   builder.setTitle("What's your favorite pet?");
			   builder.setSingleChoiceItems(pets,
					   -1,
					   new DialogInterface.OnClickListener() {   // anonymous inner class
				   		public void onClick(DialogInterface dialog, int id) {
				   			// the id contains the index into the input array
				   			String pet = pets[id];
		                                   
				   			Main myActivity = (Main)getActivity();
				   			TextView myView = (TextView)myActivity.findViewById(R.id.textView1);
				   			myView.setText("I like my " + pet);
				   			}
			   			}
				);
			   return builder.create();
		   }
	
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
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
}
