package sematec.mehdi.mymap.user;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import sematec.mehdi.mymap.R;
import sematec.mehdi.mymap.WelcomeActivity;
import sematec.mehdi.mymap.map.MapActivity_;
import sematec.mehdi.mymap.util.BaseActivity;
import sematec.mehdi.mymap.util.Util;

@EActivity(R.layout.activity_user)
public class UserActivity extends BaseActivity implements UserContract.View {

    private static final String TAG = UserActivity.class.getSimpleName();
    private UserContract.Presenter mPresenter;
    private boolean isLogin = false;

    @ViewById
    MaterialEditText fullName;

    @ViewById
    MaterialEditText email;

    @ViewById
    MaterialEditText password;

    @ViewById
    MaterialEditText passwordConfirm;

    @ViewById
    MaterialEditText mobile;

    @ViewById
    Button submit;


    @AfterViews
    void init() {
        mPresenter = new UserPresenter(this, this);
        isLogin = getIntent().getBooleanExtra(WelcomeActivity.EXTRA_LOGIN, false);
        if (isLogin) {
            passwordConfirm.setVisibility(View.GONE);
            fullName.setVisibility(View.GONE);
            mobile.setVisibility(View.GONE);
            submit.setText(R.string.login);
        }
        else {
            submit.setText(R.string.register);
        }

        //Set click listene
    }

    @Click
    void submitClicked() {

        String name, passwordConfirmText, mobileText;
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        if (!isLogin) {
            name = fullName.getText().toString();
            passwordConfirmText = passwordConfirm.getText().toString();
            mobileText = mobile.getText().toString();
             mPresenter.onRegister(name, emailText, passwordText, mobileText);
        }
        else {
            mPresenter.onLogin(emailText, passwordText);
        }
    }


    @Override
    public void onRegisterFailed() {
        Util.showToast(mContext, R.string.registration_failed);
    }

    @Override
    public void onRegisterSuccess() {
        Util.showToast(mContext, R.string.registration_successful);
    }

    @Override
    public void onLoginFailed() {
        Util.showToast(mContext, R.string.login_failed);
    }

    @Override
    public void onLoginSuccess() {
        Util.showToast(mContext, R.string.login_success);

        //Open map activity
        Intent intent = new Intent(this, MapActivity_.class);
        startActivity(intent);

    }

}
