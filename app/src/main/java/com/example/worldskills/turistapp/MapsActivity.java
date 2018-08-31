package com.example.worldskills.turistapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    int permisos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String a=getIntent().getExtras().getString("ubicacion");
        if (a.equals("1")){
            LatLng juana = new LatLng(4.672065, -74.0705079);
            LatLng grafata = new LatLng(4.6128583, -74.0728357);
            LatLng criterion = new LatLng(4.6591583, -74.1039294);
            LatLng tramonti = new LatLng(4.6554579, -74.055213);
            LatLng divina = new LatLng(4.6918426, -74.0340631);
            mMap.addMarker(new MarkerOptions().position(juana).title("Juana la Loca"));
            mMap.addMarker(new MarkerOptions().position(grafata).title("La fragata Giratoria"));
            mMap.addMarker(new MarkerOptions().position(criterion).title("Criterion"));
            mMap.addMarker(new MarkerOptions().position(tramonti).title("Tramonti"));
            mMap.addMarker(new MarkerOptions().position(divina).title("Tratoria La Divina Comedia"));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(juana,11));
        }else
        if (a.equals("3")){
            LatLng continental = new LatLng(4.6010598, -74.05126);
            LatLng tequendama = new LatLng(4.6810056, -74.04333);
            LatLng marriot = new LatLng(4.6517161, -74.058187);
            LatLng hilton = new LatLng(4.6677515, -74.0530483);
            LatLng nh = new LatLng(4.653567, -74.0571337);
            mMap.addMarker(new MarkerOptions().position(continental).title("Hotel Continental Bluedoors"));
            mMap.addMarker(new MarkerOptions().position(tequendama).title("Hotel Tequendama y centro de convenciones"));
            mMap.addMarker(new MarkerOptions().position(marriot).title("Bogota Marriot Hotel"));
            mMap.addMarker(new MarkerOptions().position(hilton).title(" Hilton Bogota"));
            mMap.addMarker(new MarkerOptions().position(nh).title("Hotel NH Collection Bogota"));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(continental,11));
        }else
        if (a.equals("2")){
            LatLng monserrate = new LatLng(4.6056941, -74.0642803);
            LatLng metro = new LatLng(4.6482361, -74.3009552);
            LatLng bolivar = new LatLng(4.5981259, -74.0782322);
            LatLng andino = new LatLng(4.6667313, -74.0553429);
            LatLng mayor = new LatLng(4.5926585, -74.1263605);
            mMap.addMarker(new MarkerOptions().position(monserrate).title("Cerro de Monserrate"));
            mMap.addMarker(new MarkerOptions().position(metro).title("Parque Metropolitano Simon Bolivar"));
            mMap.addMarker(new MarkerOptions().position(bolivar).title("Plaza de Bolivar"));
            mMap.addMarker(new MarkerOptions().position(andino).title("Centro Comercial Andino"));
            mMap.addMarker(new MarkerOptions().position(mayor).title("Centro Comercial Centro Mayor"));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(monserrate,11));

        }else {
            Toast.makeText(this,"Ningun numero",Toast.LENGTH_LONG).show();
        }




        if (ContextCompat.checkSelfPermission(MapsActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, permisos);
        } else {
            mMap.setMyLocationEnabled(true);
            }
        }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (ContextCompat.checkSelfPermission(MapsActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(),"Permisos no Aceptados",Toast.LENGTH_LONG).show();
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else{
        mMap.setMyLocationEnabled(true);}
    }
}