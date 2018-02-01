package sematec.mehdi.mymap.user;

import android.content.Context;
import android.text.Editable;

/**
 * Created by Mehdi Haghgoo on 1/30/18.
 */

public interface UserContract {
    interface View {

        void onRegisterFailed();

        void onRegisterSuccess();

        void onLoginFailed();

        void onLoginSuccess();
    }

    interface Presenter {

        void onRegisterFailed();

        void onRegister(String name, String emailText, String passwordText, String mobileText);

        void onLogin(String emailText, String passwordText);

        void onLoginSuccess();

        void onLoginFailed();
    }
}
