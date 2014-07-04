package com.google.minhalocalizacao;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {

	 private TextView latituteField;
	 private TextView longitudeField;
	 private TextView funcao;
	 private LocationManager locationManager;
	 private String provider;

	  
	/** Called when the activity is first created. */

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    latituteField = (TextView) findViewById(R.id.TextView02);
	    longitudeField = (TextView) findViewById(R.id.TextView04);
	    funcao = (TextView) findViewById(R.id.TextView06);

	    // Get the location manager
	    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    // Define the criteria how to select the locatioin provider -> use
	    // default
	    Criteria criteria = new Criteria();
	    provider = locationManager.getBestProvider(criteria, false);
	    Location location = locationManager.getLastKnownLocation(provider);

	    // Initialize the location fields
	    if (location != null) {
	      System.out.println("Provedor " + provider + " selecionado.");
	      onLocationChanged(location);
	    } else {
	      latituteField.setText("Localiza��o nao encontrada");
	      longitudeField.setText("Localiza��o nao encontrada");
	      
	    }
	    funcao.setText("onCreate");
	  }

	  /* Request updates at startup */
	  @Override
	  protected void onResume() {
	    super.onResume();
	    locationManager.requestLocationUpdates(provider, 400, 1, this);
	    funcao.setText("onResume");
	  }

	  /* Remove the locationlistener updates when Activity is paused */
	  @Override
	  protected void onPause() {
	    super.onPause();
	    locationManager.removeUpdates(this);
	    funcao.setText("onPause");
	  }

	  @Override
	  public void onLocationChanged(Location location) {
	    double lat = (double) (location.getLatitude());
	    double lng = (double) (location.getLongitude());
	    latituteField.setText(String.valueOf(lat));
	    longitudeField.setText(String.valueOf(lng));
	    funcao.setText("onLocationChanged");
	  }

	  @Override
	  public void onStatusChanged(String provider, int status, Bundle extras) {
	    // TODO Auto-generated method stub
		  funcao.setText("onStatusChanged");
	  }

	  @Override
	  public void onProviderEnabled(String provider) {
		  Toast.makeText(this, "Enabled new provider " + provider,
	      Toast.LENGTH_SHORT).show();
		  funcao.setText("onProviderEnabled");
	  }

	  @Override
	  public void onProviderDisabled(String provider) {
		  Toast.makeText(this, "Disabled provider " + provider,
	      Toast.LENGTH_SHORT).show();
		  funcao.setText("onProviderDisabled	");
	  }

}
