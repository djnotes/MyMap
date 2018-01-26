package sematec.mehdi.mymap.map;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.security.PublicKey;

import sematec.mehdi.mymap.R;
import sematec.mehdi.mymap.util.PublicMethods;

@EActivity(R.layout.activity_map)
public class MapActivity extends FragmentActivity implements OnMapReadyCallback, MapContract.View {

    private GoogleMap mMap;
    private MapContract.Presenter mPresenter;

    @ViewById
    EditText searchBar;


    @AfterViews
    void init() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mPresenter = new MapPresenter();
        mPresenter.attachView(this);
        mPresenter.attachContext(this);
     }
    @Click
    void searchBar() {
        mPresenter.onInputChanged();
    }
    @Click
    void go() {
        String keyword = searchBar.getText().toString();
        mPresenter.lookupAddress(keyword);
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onNavToPosition(double lat, double lng) {
        LatLng latLng = new LatLng(lat, lng);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onGetLocation(double lat, double lng) {
        PublicMethods.showToast(this, "Lat, Lng: " + lat + " , " + lng );
        LatLng loc = new LatLng(lat, lng);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lng)));
        mMap.addMarker(new MarkerOptions().position(loc).title("Here"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(loc.latitude, loc.longitude), 12.0f));    }
}
