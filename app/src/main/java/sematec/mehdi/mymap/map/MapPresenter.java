package sematec.mehdi.mymap.map;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import sematec.mehdi.mymap.util.PublicMethods;
import sematec.mehdi.mymap.webmodels.Location;

/**
 * Created by johndoe on 1/13/18.
 */

public class MapPresenter implements MapContract.Presenter {
    private static final String TAG = MapPresenter.class.getSimpleName();
    private MapContract.View mView;
    private Context mContext;
    private MapModel mModel;

    public MapPresenter() {
        super();
        mModel = new MapModel(this);
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
//        PublicMethods.showToast(mContext,"You clicked inside the search bar");

    }

    @Override
    public void onSearchFailed(String s) {
        PublicMethods.showToast(mContext, s);
    }

    @Override
    public void lookupAddress(String keyword) {
        Log.i(TAG, "queryAddress: " + keyword);
        try {
            mModel.queryAddress(keyword);
        } catch(IOException e) {
            Log.e(TAG, "IOExceptio: " + e.getMessage());
        }
    }

    @Override
    public void onSearchSuccess(Location location) {
        if(location == null) {
            PublicMethods.showToast(mContext, "location null");
            return;
        }
        double lat = location.getLat();
        double lng = location.getLng();
        mView.onGetLocation(lat, lng);
    }

    @Override
    public void onTimeCheck() {
        boolean isDaylight = mModel.isDaylight();
        if(isDaylight) mView.onSetDayStyle();
        else mView.onSetNightStyle();
        Log.i(TAG, "onTimeCheck: " + String.valueOf(isDaylight));
    }
}
