package sematec.mehdi.mymap.map;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import sematec.mehdi.mymap.webmodels.Geometry;
import sematec.mehdi.mymap.webmodels.Location;

/**
 * Created by johndoe on 1/12/18.
 */

public interface MapContract {
    interface Presenter {
        void attachView(View view);
        void attachContext(Context context);

        void onInputChanged();

        void onSearchFailed(String s);

        void lookupAddress(String keyword);

        void onSearchSuccess(Geometry loc);

    }

    interface View {
        void onNavToPosition(double lat, double lng);

        void onGetLocation(double lat, double lng);
    }
}
