package edu.neu.madcourse.numad22sp_jiayuezhao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity5 extends AppCompatActivity {

    private GpsTracker tracker;
    private TextView lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        lat = findViewById(R.id.latitude);
        lon = findViewById(R.id.longitude);

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        getLocation(findViewById(R.id.activity_5_main));


    }

    public void getLocation(View view){
        tracker = new GpsTracker(Activity5.this);
        if(tracker.canGetLocation()){
            double latitude = tracker.getLatitude();
            double longitude = tracker.getLongitude();
            lat.setText(String.valueOf(latitude));
            lon.setText(String.valueOf(longitude));
        }else{
            tracker.showSettingsAlert();
        }
    }
}

