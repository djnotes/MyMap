package sematec.mehdi.mymap.map;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sematec.mehdi.mymap.util.Constants;
import sematec.mehdi.mymap.webmodels.Geometry;
import sematec.mehdi.mymap.webmodels.Location;

/**
 * Created by johndoe on 1/14/18.
 */

public class MyModel {
    MapContract.Presenter mPresenter;
    private Location mResLocation;

    public MyModel(MapContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void lookupAddress(String address) throws IOException {

        Constants.webInterface .lookupAddress(Constants.GOOGLE_API_KEY, address).enqueue(
                new Callback<Geometry>() {
                    @Override
                    public void onResponse(Call<Geometry> call, Response<Geometry> response) {
                        mResLocation = response.body().getLocation();
                        mPresenter.onSearchSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<Geometry> call, Throwable t) {
                        mPresenter.onSearchFailed("Search failed");
                    }
                }
        );
    }
}
