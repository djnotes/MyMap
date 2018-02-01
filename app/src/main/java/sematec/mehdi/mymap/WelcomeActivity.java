package sematec.mehdi.mymap;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.Button;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

import sematec.mehdi.mymap.map.MapActivity_;
import sematec.mehdi.mymap.user.UserActivity_;
import sematec.mehdi.mymap.util.BaseActivity;

/**
 * Created by johndoe on 1/12/18.
 */

@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity {

    public static final String EXTRA_LOGIN = "sematec.mehdi.mymap.extra_login";


    @Click(R.id.register)
    void startRegister() {
        Intent intent = new Intent(this, UserActivity_.class);
        intent.putExtra(EXTRA_LOGIN, false);
        startActivity(intent);
    }

    @Click(R.id.login)
    void startLogin() {
        Intent intent = new Intent(this, UserActivity_.class);
        intent.putExtra(EXTRA_LOGIN, true );
        startActivity(intent);

    }

}