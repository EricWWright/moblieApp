package teencoder.androidprogramming;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Options extends Activity implements OnClickListener {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        
        setUpSpinner();
        
        Button playButton = (Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
        
        loadSettings();
	}

	@Override
	public void onClick(View v) {
		if (v.getId() != R.id.playButton) {
			return;
		}
		
		Intent myIntent = new Intent(this, Game.class);
		
		int difficulty;
		
		EditText ev = (EditText)findViewById(R.id.etName);
		RadioButton easy = (RadioButton)findViewById(R.id.rbEasy);
		RadioButton medium = (RadioButton)findViewById(R.id.rbMedium);
		RadioButton hard = (RadioButton)findViewById(R.id.rbHard);
		SeekBar sb = (SeekBar)findViewById(R.id.sbDuration);
		Spinner sp = (Spinner)findViewById(R.id.numMoles);
		
		if (easy.isChecked()) 
			difficulty = 3;
		else if (medium.isChecked())
			difficulty = 2;
		else
			difficulty = 1;
		
		String name = ev.getText().toString();
		int duration = sb.getProgress();
		
		int numMoles = sp.getSelectedItemPosition() + 3;
		
		//saveSettingsInIntent(difficulty, name, numMoles, duration, myIntent);
		saveSettingsInPrefs(difficulty, name, numMoles, duration);
		startActivity(myIntent);
	}

	private void setUpSpinner() {
		Spinner spn = (Spinner)findViewById(R.id.numMoles);
		String[] moles = {"3", "4", "5", "6", "7", "8"};
		ArrayAdapter<String> myAdapter = 
				   new ArrayAdapter<String> (this, 
				                         android.R.layout.simple_spinner_item, moles);
		spn.setAdapter(myAdapter);
	}
	
	private void saveSettingsInIntent(int difficulty, String name,
			int numMoles, int duration, Intent myIntent) {
		myIntent.putExtra("Name", name);
		myIntent.putExtra("Difficulty", difficulty);
		myIntent.putExtra("Moles", numMoles);
		myIntent.putExtra("Difficulty", duration);
	}
	
	private void saveSettingsInPrefs(int difficulty, String name,
									int numMoles, int duration) {
		SharedPreferences prefs = getSharedPreferences("WhackSettings", MODE_PRIVATE);
		
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.putString("Name", name);
		editor.putInt("Difficulty", difficulty);
		editor.putInt("Moles", numMoles);
		editor.putInt("Duration", duration);
		
		editor.commit();
	}
	
	private void loadSettings() {
		SharedPreferences prefs = getSharedPreferences("WhackSettings", MODE_PRIVATE);
		
		String playerName = prefs.getString("Name", "Default");
		int difficultyLevel = prefs.getInt("Difficulty", 2);
		int numMoles = prefs.getInt("Moles", 8);
		int duration = prefs.getInt("Duration", 20);
		
		EditText ev = (EditText)findViewById(R.id.etName);
		RadioButton easy = (RadioButton)findViewById(R.id.rbEasy);
		RadioButton medium = (RadioButton)findViewById(R.id.rbMedium);
		RadioButton hard = (RadioButton)findViewById(R.id.rbHard);
		SeekBar sb = (SeekBar)findViewById(R.id.sbDuration);
		Spinner sp = (Spinner)findViewById(R.id.numMoles);
		
		ev.setText(playerName);
		sp.setSelection(numMoles - 3);
		sb.setProgress(duration);
		
		if (difficultyLevel ==3)
			easy.setChecked(true);
		else if (difficultyLevel == 2)
			medium.setChecked(true);
		else
			hard.setChecked(true);
		
	}

}
