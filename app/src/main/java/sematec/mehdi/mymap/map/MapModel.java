package sematec.mehdi.mymap.map;

import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sematec.mehdi.mymap.util.Constants;
import sematec.mehdi.mymap.webmodels.Geometry;
import sematec.mehdi.mymap.webmodels.Location;
import sematec.mehdi.mymap.webmodels.Result;

/**
 * Created by johndoe on 1/14/18.
 */

public class MapModel {
    MapContract.Presenter mPresenter;
    private Location mResLocation;
    private static final String TAG = MapModel.class.getSimpleName();

    public MapModel(MapContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void lookupAddress(String address) throws IOException {

        Constants.WebServiceInterface .lookupAddress(Constants.GOOGLE_API_KEY, address).enqueue(
                new Callback<Result[]>() {
                    @Override
                    public void onResponse(Call<Result[]> call, Response<Result[]> response) {

                        mResLocation = response.body()[0].getGeometry().getLocation();
                        Log.i(TAG, "onResponse: " + response.toString());
                        Log.i(TAG, "Location : " + mResLocation.getLat() + " : " + mResLocation.getLat());
                        mPresenter.onSearchSuccess(mResLocation);
                    }

                    @Override
                    public void onFailure(Call<Result[]> call, Throwable t) {mPresenter.onSearchFailed("Search failed");
                    }
                }
        );
    }
}
