package sematec.mehdi.mymap.map;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by johndoe on 1/12/18.
 */

public interface MapContract {
    interface Presenter {
        void attachView(View view);

    }

    interface View {
        void onNavToPosition(double lat, double lng);

    }
}
