package com.example.busroute;

import android.os.Bundle;
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
		Log.d("Debug", "onCreate has been called!");
		
		View v = findViewById(R.id.routebutton);
		//set event listener
	        v.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
	    super.onResume();
	    // Log the action
	    Log.d("Debug", "onResume() has been called!");
	}
	@Override
	public void onDestroy() {
	    
	    // Log the action
	    Log.d("Debug", "onDestroy() has been called!");
	}
	
	

	
	
	public void onClick (View view) {
		  
		  if (view.getId() == R.id.routebutton) 
		  {
			  Intent myIntent = new Intent(view.getContext(), RouteActivity.class);
			  startActivityForResult(myIntent, 0);
		  }
		  else if (view.getId() == R.id.settingsbutton) 
		  {
			  Toast.makeText(this, "Yep, you pressed settings", Toast.LENGTH_LONG).show();
		  }
		  else if (view.getId() == R.id.logoutbutton) 
		  {
			  Toast.makeText(this, "Yep, you pressed log out", Toast.LENGTH_LONG).show();
		  }
		  
		} 

}
