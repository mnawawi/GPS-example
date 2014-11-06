package com.example.gps;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class GPS extends Activity  implements LocationListener{
	private LocationManager  locationManager;
	private TextView lat;
	private TextView longe;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gps);
		lat= (TextView) findViewById(R.id.textView3);
		longe= (TextView) findViewById(R.id.textView4);
		
		 locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.g, menu);
		return true;
	}

    @Override
    protected void onResume() {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 1, this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        locationManager.removeUpdates(this);
        super.onPause();
    }
    
	@Override
	public void onLocationChanged(Location location) {
     if (location != null) {
	    	 
	    	 lat.setText(""+location.getLatitude());
	    	 longe.setText(""+location.getLongitude());
             //Toast.makeText(this, "Latitude and Longitude " + location.getLatitude() + " " + 
             //        location.getLongitude(), Toast.LENGTH_SHORT).show();
         }
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

        Toast.makeText(this, "Latitude and Longitude Offline ", Toast.LENGTH_SHORT).show();
  
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
