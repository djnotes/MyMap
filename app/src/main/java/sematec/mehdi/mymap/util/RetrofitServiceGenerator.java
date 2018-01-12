package sematec.mehdi.mymap.util;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johndoe on 1/13/18.
 */

public class RetrofitServiceGenerator {
    public static final String API_BASE_URL = "http://maps.googleapis.com/maps/api/geocode/json";
    private static OkHttpClient httpClient =
            new OkHttpClient();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}