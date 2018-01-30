package sematec.mehdi.mymap;

import android.content.Intent;
import android.view.MenuItem;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;

import sematec.mehdi.mymap.map.MapActivity_;
import sematec.mehdi.mymap.util.BaseActivity;

/**
 * Created by johndoe on 1/12/18.
 */

@EActivity(R.layout.activity_welcome)
@OptionsMenu(R.menu.options_menu)
public class WelcomeActivity extends BaseActivity {

    public static final String EXTRA_LOGIN = "sematec.mehdi.mymap.extra_login";
    @OptionsMenuItem
    MenuItem mapItem;

    @Click(R.id.submit)
    void reg() {
        Intent intent = new Intent(this, LoginActivity.class );
        intent.putExtra(EXTRA_LOGIN, false);
        startActivity(intent);
    }

    @Click(R.id.login)
    void login () {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(EXTRA_LOGIN, true);
    }



    boolean mapItem () {
        mIntent = new Intent (mContext, MapActivity_.class);
        startActivity(mIntent);
        return true;
    }

}