package com.example.busroute;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.esri.android.geotrigger.GeotriggerService;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		//creates db
		DBAdapter db = new DBAdapter(this);
		
		Log.d("Debug", "onCreate has been called!");
		
		View v = findViewById(R.id.routebutton);
	    v.setOnClickListener(this);
	    
	    View v1 = findViewById(R.id.planroutebutton);
	    v1.setOnClickListener(this);
	    
	    View v2 = findViewById(R.id.helpbutton);
	    v2.setOnClickListener(this);
	    
	    View v3 = findViewById(R.id.settingsbutton);
	    v3.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick (View view) {
		  
		  if (view.getId() == R.id.routebutton) 
		  {
			  Intent myIntent = new Intent(view.getContext(), RouteActivity.class);
			  startActivityForResult(myIntent, 0);
		  }
		  else if (view.getId() == R.id.helpbutton) 
		  {
			  Intent myIntent = new Intent(view.getContext(), HelpActivity.class);
			  startActivityForResult(myIntent, 0);
		  }
		  else if (view.getId() == R.id.settingsbutton) 
		  {
			  Intent myIntent = new Intent(view.getContext(), SettingsActivity.class);
			  startActivityForResult(myIntent, 0);		  
		  }
		  else if (view.getId() == R.id.planroutebutton) 
		  {
			  Intent myIntent = new Intent(view.getContext(), AddressActivity.class);
			  startActivityForResult(myIntent, 0);		
		  }
		  
		} 

}
