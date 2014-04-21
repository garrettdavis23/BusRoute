package com.example.busroute;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends Activity implements OnCheckedChangeListener {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Displays settings activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		// Makes it full screen
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		// Sets up listeners for the 2 switches
		 Switch darkThemeSwitch = (Switch) findViewById(R.id.switch1);
		 if (darkThemeSwitch != null) {
	            darkThemeSwitch.setOnCheckedChangeListener((android.widget.CompoundButton.OnCheckedChangeListener) this);    // note this
	     }
		 
		 Switch soundEffectsSwitch = (Switch) findViewById(R.id.switch2);
		 if (soundEffectsSwitch != null) {
	            soundEffectsSwitch.setOnCheckedChangeListener((android.widget.CompoundButton.OnCheckedChangeListener) this);    // note this
	     }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		
		// Just displays a message when the setting is toggled
	    Toast.makeText(this, "The switch is " + (isChecked ? "on" : "off"),
	                   Toast.LENGTH_SHORT).show();
	    if (isChecked) 
	    {
	        //do stuff when Switch is ON
	    	Log.d("Debug", "!!!!!!!!!!!!!!!!");
	    	//getWindow().getDecorView().setBackgroundColor(Color.RED);
	    	
	    } 
	    else 
	    {
	        //do stuff when Switch if OFF
	    	getWindow().getDecorView().setBackgroundColor(Color.RED);

	    }
	}

}
