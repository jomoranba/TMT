package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationProviderClient;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//        databaseReference = FirebaseDatabase.getInstance().getReference();
//        final int cantidad = 12;
//        final Double latitud = -8.127444;
//        final Double longitud = -79.041265;

//        fusedLocationProviderClient.getLastLocation()
//            .addOnSuccessListener(this,new OnSuccessListener<Location>(){
//                @Override
//                public void onSuccess(Location location){
//                    if(location != null){
                        //Log.e("Latidud",+location.getLatitude()+"Longitud:"+location.getLongitude());


//                        Map<String,Object> latlang= new HashMap<>();
//                        latlang.put("cantidad",cantidad);
//                        latlang.put("latitud",latitud);
//                        latlang.put("longitud",longitud);
//                        databaseReference.child("Semaforo").push().setValue(latlang);
//                    }
//            }

//        });
    }

    public void Map(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }



}
