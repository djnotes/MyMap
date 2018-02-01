package sematec.mehdi.mymap.user;

import android.content.Context;
import android.util.Log;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import sematec.mehdi.mymap.util.UserRetrofitGenerator;

/**
 * Created by Mehdi Haghgoo on 1/30/18.
 */

public class UserModel {
    private static final String TAG = UserModel.class.getSimpleName();
    private Context mContext;
    private UserPresenter mPresenter;

    public UserModel(UserPresenter presenter) {
        mPresenter = presenter;
    }

    public void register(String fullName, String email, String password, String mobile) {
        UserWebServiceInterface webInterface = UserRetrofitGenerator.create(UserWebServiceInterface.class);
        webInterface.register(fullName, email, password, mobile)
              .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i(TAG, "onResponse: " + response.message());
                        mPresenter.onRegisterSuccess();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        mPresenter.onRegisterFailed();
                    }
                });

    }

    public void login(String emailText, String passwordText) {
        UserWebServiceInterface webInterface = UserRetrofitGenerator.create(UserWebServiceInterface.class);
        webInterface.login(emailText, passwordText)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Log.i(TAG, "onResponse: " + response.message());
                        mPresenter.onLoginSuccess();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        mPresenter.onLoginFailed();
                    }
                });

    }


    public interface UserWebServiceInterface {
        @FormUrlEncoded
        @POST("/myapi/?action = register")
        Call<Void> register(@Field ("fullName") String fullName, @Field("email") String email, @Field("password") String password, @Field("mobile") String mobile);

        @FormUrlEncoded
        @POST("/myapi/?action=login")
        Call<Void> login(@Field ("email") String emailText, @Field("password") String passwordText);
    }
}
