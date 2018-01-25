package sematec.mehdi.mymap.map;

import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sematec.mehdi.mymap.util.Constants;
import sematec.mehdi.mymap.util.RetrofitServiceGenerator;
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
    public static WebServiceInterface WebServiceInterface = RetrofitServiceGenerator.create(WebServiceInterface.class);


    public void lookupAddress(String address) throws IOException {

        WebServiceInterface .lookupAddress(Constants.GOOGLE_API_KEY, address).enqueue(
                new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {

                        Log.i(TAG, "onResponse: " + response.toString());
                        Log.i(TAG, "Location : " + mResLocation.getLat() + " : " + mResLocation.getLat());
                        mResLocation = response.body().getGeometry().getLocation();
                        mPresenter.onSearchSuccess(mResLocation);
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {mPresenter.onSearchFailed("Search failed");
                    }
                }
        );
    }
    public interface WebServiceInterface {

        @GET("json")
        Call<Result> lookupAddress(@Query("key") String apiKey, @Query("address") String searchTerm);
    }

}

