package sematec.mehdi.mymap.map;

import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

import java.io.IOException;
import java.util.Calendar;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sematec.mehdi.mymap.util.Constants;
import sematec.mehdi.mymap.util.RetrofitServiceGenerator;
import sematec.mehdi.mymap.webmodels.Geometry;
import sematec.mehdi.mymap.webmodels.GoogleMapModel;
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


    public void queryAddress(String address) throws IOException {

        WebServiceInterface.lookupAddress(Constants.GOOGLE_API_KEY, address)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onResponse, this::onError, this::onComplete);

    }

//                .enqueue(
//                new Callback<GoogleMapModel>() {
//                    @Override
//                    public void onResponse(Call<GoogleMapModel> call, Response<GoogleMapModel> response) {
//                        mResLocation = response.body().getResults().get(0).getGeometry().getLocation();
//                        if (mResLocation == null) {
//                            Log.e(TAG, "onResponse: body null ");
//                            return;
//                        }
//
//                        mPresenter.onSearchSuccess(mResLocation);
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<GoogleMapModel> call, Throwable t) {
//                        mPresenter.onSearchFailed("Search failed");
//                    }
//                }
//        );

    private void onComplete() {
        Log.i(TAG, "onComplete: ");
    }

    private void onError(Throwable throwable) {
        mPresenter.onSearchFailed("Error");
    }

    private void onResponse(GoogleMapModel googleMapModel) {
        Location location = googleMapModel.getResults().get(0).getGeometry().getLocation();
        if(location == null) {
            Log.e(TAG, "onResponse: location null" );
            mPresenter.onSearchFailed("Failure");
        }
        else {
            mPresenter.onSearchSuccess(location);
        }
    }


    public boolean isDaylight() {
        Calendar time = Calendar.getInstance();

        int hour = time.get(Calendar.HOUR_OF_DAY);
        Log.d(TAG, "isDaylight: Hour: " + hour);

        return (5 < hour && hour < 20);
    }

    public interface WebServiceInterface {

        @GET("json")
        Observable<GoogleMapModel> lookupAddress(@Query("key") String apiKey, @Query("address") String searchTerm);
    }

}

