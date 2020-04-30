package com.example.theweatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
     private static String forecastDaysNum = "3";
     String city = "Philadelphia, PA";

     private RadioButton unit;
     private Spinner verbosity;
     private EditText lowTemp;
     private EditText midTemp;
     private EditText highTemp;
     private Button save;
    private Button page2;
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    public static final String SHARED_PREFS = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forecast);


        unit = (RadioButton) findViewById(R.id.unit);
        verbosity = (Spinner) findViewById(R.id.verbosity);
        lowTemp = (EditText) findViewById(R.id.lowTemp);
        midTemp = (EditText) findViewById(R.id.midTemp);
        highTemp = (EditText) findViewById(R.id.highTemp);
        save = (Button) findViewById(R.id.save);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        page2 = (Button) findViewById(R.id.addyourown);
        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    // Create a new user with a first and last name
    Map<String, Object> user = new HashMap<>();
user.put("first", "Ada");
user.put("last", "Lovelace");
user.put("born", 1815);

// Add a new document with a generated ID
db.collection("users")
        .add(user)
        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
        @Override
        public void onSuccess(DocumentReference documentReference) {
        }
    });

}}


