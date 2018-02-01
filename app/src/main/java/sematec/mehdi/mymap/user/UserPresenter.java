package sematec.mehdi.mymap.user;

import android.content.Context;


/**
 * Created by Mehdi Haghgoo on 1/30/18.
 */

public class UserPresenter implements UserContract.Presenter {
    private UserContract.View mView;
    private UserModel mModel;
    private Context mContext;

    public UserPresenter(UserContract.View view, Context context) {
        mView = view;
        mContext = context;
        mModel = new UserModel(this);
    }

    public void onRegisterFailed() {
            mView.onRegisterFailed();
    }

    @Override
    public void onRegister(String fullName, String emailText, String passwordText, String mobile) {
        mModel.register(fullName, emailText, passwordText, mobile);
    }

    @Override
    public void onLogin(String emailText, String passwordText) {
        mModel.login(emailText, passwordText);
    }

    @Override
    public void onLoginSuccess() {
        mView.onLoginSuccess();
    }

    @Override
    public void onLoginFailed() {
        mView.onLoginFailed();
    }

    public void onRegisterSuccess() {
        mView.onRegisterSuccess();
    }
}
