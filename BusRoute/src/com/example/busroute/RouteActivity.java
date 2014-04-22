package com.example.busroute;

import android.app.Activity;
import android.app.ActionBar;
import android.os.Bundle;
import android.widget.Toast;
import android.location.Location;
import android.location.LocationListener;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.LocationService;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;
import com.esri.core.tasks.geocode.Locator;


public class RouteActivity extends Activity implements LocationListener {

	MapView mMapView;
	ArcGISTiledMapServiceLayer basemap;
	GraphicsLayer locationLayer;
	Locator locator;
	Point mLocation = null;
	
	final SpatialReference wm = SpatialReference.create(102100);
	final SpatialReference egs = SpatialReference.create(4326);

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

		// Set up location listener to find your location
		LocationService ls = mMapView.getLocationService();
		ls.setLocationListener(this);
		ls.start();
		ls.setAutoPan(false);
	}

	protected void onPause() {
		super.onPause();
		mMapView.pause();
	}

	protected void onResume() {
		super.onResume();
		mMapView.unpause();
	}

	@Override
	public void onLocationChanged(Location loc) {
		// TODO Auto-generated method stub
		if (loc == null)
		{
			return;
		}
		
		boolean zoomToMe = (mLocation == null) ? true : false;
		mLocation = new Point(loc.getLongitude(), loc.getLatitude());
		
		// Zoom the map to device location
		if (zoomToMe) {
			Point gpsLoc = (Point) GeometryEngine.project(mLocation, egs, wm);
			mMapView.zoomToResolution(gpsLoc, 20.0);
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "GPS Disabled",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "GPS Enabled",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	

}
