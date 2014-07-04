package com.aula.localizacao;

import android.os.Bundle;  
import android.support.v4.app.*;  
  
import com.google.android.gms.common.*;  
import com.google.android.gms.maps.*;  
import com.google.android.gms.maps.model.*;   
  
public class MainActivity extends FragmentActivity {  
  
  protected void onCreate(Bundle savedInstanceState) {  
	  super.onCreate(savedInstanceState);  
	  setContentView(R.layout.activity_main);  
	   
	  SupportMapFragment fragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);  
	  GoogleMap map = fragment.getMap();  
	  
	  LatLng latLng = new LatLng(-19.919068,-43.938575);  
	  map.addMarker(new MarkerOptions()
	      .position(latLng)  
	      .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
	      .title("Praça Sete")
	      .snippet("Belo horizonte"));  
	    
	  configuraPosicao(map, latLng);  
  }  
  
  private void configuraPosicao(GoogleMap map, LatLng latLng) {  
	  map.setMapType(GoogleMap.MAP_TYPE_NORMAL);  
	  map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));  
  }  
} 