package com.example.busroute;

import android.app.ActionBar;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
public class RoutePlannerActivity extends ListActivity {
 
	static final String[] AddressList = new String[] { "Address 1", "Address 2", "Address 3", "Address 4", "Address 5", "Address 6",
		"Address 7", "Address 8","Address 9", "Address 10","Address 11", "Address 12"};
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
 
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_route_planner,AddressList));
 
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
 
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    // When clicked, show a toast with the TextView text
			    Toast.makeText(getApplicationContext(),
				((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
 
	}
 
}
