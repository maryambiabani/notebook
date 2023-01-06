package net.behsazan.appone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import net.behsazan.ppone.R;

public class LocationActivity extends AppCompatActivity {
double longitude=0.0;
double latitude=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        GPSTracker gpsTracker=new GPSTracker(this);

        if (gpsTracker.canGetLocation()){

            Log.e("","");
latitude=gpsTracker.getLatitude();
longitude=gpsTracker.getLongitude();
        }else {
            Log.e("","");
            gpsTracker.showSettingsAlert();


        }
    }
}