package com.EricWWright.dialogex;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.*;
import android.content.DialogInterface;
import android.widget.*;

public class Main extends Activity implements OnClickListener {
	
	public static class MyAlertDialog extends DialogFragment {
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	    	// your dialog creation code goes here
	    	AlertDialog.Builder builder = 
                    new AlertDialog.Builder(getActivity());
	    	builder.setMessage("Do you like this dialog?");
	    	builder.setCancelable(false);  // prevent user from canceling alert or not
	    	builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int id) {
					// the positive button was clicked!
				    Main myActivity = (Main)getActivity();
				    TextView myView = 
				                  (TextView)myActivity.findViewById(R.id.textView1);
				    myView.setText("I agree!");
					
				}
	    		
	    	});
	    	builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int id) {
					// the negative button was clicked!
				    Main myActivity = (Main)getActivity();
				    TextView myView = 
				                  (TextView)myActivity.findViewById(R.id.textView1);
				    myView.setText("I dont agree!");
					
				}
	    		
	    	});
	    	builder.setNeutralButton ("Don't care", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int id) {
					// the neutral button was clicked!
				    Main myActivity = (Main)getActivity();
				    TextView myView = 
				                  (TextView)myActivity.findViewById(R.id.textView1);
				    myView.setText("I don't care!");
					
				}
	    		
	    	});
	    	return builder.create();
	    }
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(this);
		
		
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
	
	@Override
	public void onClick(View v) {
		DialogFragment newFragment = new MyAlertDialog();
		newFragment.show(getFragmentManager(), "myDialog");
	}

	
}
