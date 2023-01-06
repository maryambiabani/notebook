package net.behsazan.appone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import net.behsazan.ppone.R;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {
    SupportMapFragment supportMapFragment;
double longitude=0.0;
double latitude=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        supportMapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_location);
        GPSTracker gpsTracker=new GPSTracker(this);

        if (gpsTracker.canGetLocation()){

            Log.e("","");
latitude=gpsTracker.getLatitude();
longitude=gpsTracker.getLongitude();
        }else {
            Log.e("","");
            gpsTracker.showSettingsAlert();


        }

        supportMapFragment.getMapAsync(this::onMapReady);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng latLng=new LatLng(35.72564,51.37231);
        MarkerOptions markerOptions=new MarkerOptions().title("my home")
                .snippet("this is extra note")
                .position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        CameraPosition cameraPosition=new CameraPosition.Builder()
                .target(latLng).zoom(10).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        LatLng latLng1=new LatLng(35.62564,51.37231);
        MarkerOptions markerOptions1=new MarkerOptions().title("point1")
                .position(latLng1)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        googleMap.addMarker(markerOptions1);
        LatLng latLng2=new LatLng(35.52564,51.27231);
        MarkerOptions markerOptions2=new MarkerOptions().title("point2")
                .position(latLng2)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        googleMap.addMarker(markerOptions2);
        LatLng latLng3=new LatLng(35.52564,51.27231);
        MarkerOptions markerOptions3=new MarkerOptions().title("point3")
                .position(latLng3)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        googleMap.addMarker(markerOptions3);
        LatLng latLng4=new LatLng(35.82564,51.17231);
        MarkerOptions markerOptions4=new MarkerOptions().title("point4")
                .position(latLng4)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        googleMap.addMarker(markerOptions4);
        LatLng latLng5=new LatLng(35.72564,51.17231);
        MarkerOptions markerOptions5=new MarkerOptions().title("point5")
                .position(latLng5)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        googleMap.addMarker(markerOptions5);

        googleMap.addMarker(markerOptions);
        googleMap.addPolygon(new PolygonOptions()
                .add(new LatLng(35.82564,51.17231),
                        new LatLng(35.72564,51.37231),
                        new LatLng(35.62564,51.37231),
                        new LatLng(35.52564,51.27231),
                        new LatLng(35.72564,51.17231)

                )
                .strokeColor(0xFF00AA00)
                .fillColor(0x2200FFFF)
                .strokeWidth(2));
    }
}