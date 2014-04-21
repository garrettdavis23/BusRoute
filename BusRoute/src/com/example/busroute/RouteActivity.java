package com.example.busroute;

import android.app.Activity;
import android.app.ActionBar;
import android.os.Bundle;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.esri.core.tasks.geocode.Locator;



public class RouteActivity extends Activity {

	MapView mMapView;
	ArcGISTiledMapServiceLayer basemap;
	GraphicsLayer locationLayer;
	Locator locator;

	public void onCreate(Bundle savedInstanceState) {
		
		// Launch route activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_route);
		
		// Make it full screen
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		// Retrieve the map from XML layout
		mMapView = (MapView)findViewById(R.id.map);
		
		// Add map layer on the screen
		mMapView.addLayer(new ArcGISTiledMapServiceLayer("" +
		"http://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer"));

	}

	protected void onPause() {
		super.onPause();
		mMapView.pause();
	}

	protected void onResume() {
		super.onResume();
		mMapView.unpause();
	}
	

}
