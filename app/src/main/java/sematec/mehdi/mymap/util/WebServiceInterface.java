package sematec.mehdi.mymap.util;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import sematec.mehdi.mymap.webmodels.Geometry;

/**
 * Created by johndoe on 1/13/18.
 */

public interface WebServiceInterface {

    @GET("json")
    Call<Geometry> lookupAddress(@Query ("key") String apiKey, @Query("address") String searchTerm);
}
