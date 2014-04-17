package com.example.busroute;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		addressField = (EditText) findViewById(R.id.addressField);
		
		View saveButton = (Button) findViewById(R.id.saveAddressButton);
		saveButton.setOnClickListener(this);
		
		View mapButton = (Button) findViewById(R.id.graphicalPlan);
		mapButton.setOnClickListener(this);
	}

	public void onClick(View view) {
		
		 if (view.getId() == R.id.saveAddressButton) 
		 {
			 //save the address to the database
			Toast.makeText(getApplicationContext(),addressField.getText().toString(), Toast.LENGTH_SHORT).show();
		 }
		 else if (view.getId() == R.id.graphicalPlan) 
		 {
			 Intent myIntent = new Intent(view.getContext(), RoutePlannerActivity.class);
			  startActivityForResult(myIntent, 0);	
		 }
	}


}
