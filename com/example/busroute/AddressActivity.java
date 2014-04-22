package com.example.busroute;

import android.os.Bundle;
import android.os.Debug;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class AddressActivity extends Activity implements OnClickListener  {

	static final String[] AddressList = new String[] {
		"1578 Neil Ave Columbus, OH 43210",
		"1739 N High St Columbus, OH 43210",
		"1850 College Rd Columbus, OH 43210",
		"29 W Woodruff Ave Columbus, OH 43210",
		"2024 Neil Ave Columbus, OH 43210",
		"2015 Neil Ave Columbus, OH 43210",
		"337 W 17th Ave Columbus, OH 43210",
		"1578 Neil Ave Columbus, OH 43210"};
	
	static final String[] EmptyAddressList = new String[] {
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		""};
	
	private EditText addressField;
	
	//not sure if we need this if we did it in main but dunno how to find it from context
	DBAdapter db = new DBAdapter(this);


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Pulls us the address activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);
		
		// Hides action bar to make it full screen
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		// Gets text box id for address input
		addressField = (EditText) findViewById(R.id.addressField);
		
		// Sets click listeners for the buttons
		View saveaddButton = (Button) findViewById(R.id.saveAddressButton);
		saveaddButton.setOnClickListener(this);
		
		View mapButton = (Button) findViewById(R.id.graphicalPlan);
		mapButton.setOnClickListener(this);
	}

	public void onClick(View view) {
		
		 if (view.getId() == R.id.saveAddressButton) 
		 {
			 if(addressField.getText().toString().length() > 0) //makes sure input is there
			 {
				 // Profiler testing/ Displays user input
				 Debug.startMethodTracing();
				 Toast.makeText(getApplicationContext(),addressField.getText().toString(), Toast.LENGTH_SHORT).show();
				 Debug.stopMethodTracing();
				 
				 // Puts input into the database
				db.open();
				db.insertRow(addressField.getText().toString());
				
				// Launches recorder for this address, tries to pass on address for use when saving audio

				Intent recordIntent = new Intent(AddressActivity.this, AudioActivity.class);
				
				recordIntent.putExtra("com.example.busroute.address", addressField.getText().toString());
	
	            startActivityForResult(recordIntent, 0);
				
			 }

		 }
		 else if (view.getId() == R.id.graphicalPlan) 
		 {
			 // Starts up the old address input where the user had to tap and hold
			 // create a point
			 Intent myIntent = new Intent(view.getContext(), RoutePlannerActivity.class);
			 startActivityForResult(myIntent, 0);	
		 }
	}
	@Override
	public void onPause() {
		super.onPause();
		db.close();
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		db.close();
	}



}
