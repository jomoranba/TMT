package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Handler;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private DatabaseReference mDatabase;
    private GoogleMap mMap;
    private ArrayList<Marker> tmpRealTimeMarkers = new ArrayList<>();
    private ArrayList<Marker> realTimeMarkers = new ArrayList<>();

    private LatLng ubicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
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
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mDatabase.child("Semaforo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (Marker marker:realTimeMarkers){
                    marker.remove();
                }

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Semaforo sm = snapshot.getValue(Semaforo.class);
                    String Sema = sm.getSema();
                    int cantidad = sm.getCantidad();
                    Double latitud= sm.getLatitud();
                    Double longitud = sm.getLongitud();




                    ubicacion = new LatLng(latitud, longitud);

                    Marker markerOptions = mMap.addMarker(new MarkerOptions()
                            .position(ubicacion)
                            .title("Cantida de Vehiculo:"+cantidad)
                            .visible(true));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(19));
                    markerOptions.showInfoWindow();
                    tmpRealTimeMarkers.add(markerOptions);
                }

                realTimeMarkers.clear();
                realTimeMarkers.addAll(tmpRealTimeMarkers);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

//    @Override
//    public void onStart(){
//        super.onStart();
//
//    }

//    public void moveCamera(View view) {
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(19));
//    }
}
