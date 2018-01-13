package sematec.mehdi.mymap.map;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import sematec.mehdi.mymap.util.PublicMethods;
import sematec.mehdi.mymap.webmodels.Geometry;
import sematec.mehdi.mymap.webmodels.Location;

/**
 * Created by johndoe on 1/13/18.
 */

public class MapPresenter implements MapContract.Presenter {
    private static final String LOG_TAG = MapPresenter.class.getSimpleName();
    private MapContract.View mView;
    private Context mContext;
    private MyModel mModel;

    public MapPresenter() {
        super();
        mModel = new MyModel(this);
    }

    @Override
    public void attachView(MapContract.View view) {
        mView = view;
    }

    @Override
    public void attachContext(Context context) {
        mContext = context;
    }

    @Override
    public void onInputChanged() {
        PublicMethods.showToast(mContext,"You clicked inside the search bar");

    }

    @Override
    public void onSearchFailed(String s) {
        PublicMethods.showToast(mContext, s);
    }

    @Override
    public void lookupAddress(String keyword) {
        try {
            mModel.lookupAddress(keyword);
        } catch(IOException e) {
            Log.e(LOG_TAG, "IOExceptio: " + e.getMessage());
        }
    }

    @Override
    public void onSearchSuccess(Geometry geometry) {
        Location loc = geometry.getLocation();
        if(loc == null) {
            PublicMethods.showToast(mContext, "location null");
            return;
        }
        double lat = loc.getLat();
        double lng = loc.getLng();
        mView.onGetLocation(lat, lng);
    }
}
