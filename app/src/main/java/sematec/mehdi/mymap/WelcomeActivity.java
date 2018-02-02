package sematec.mehdi.mymap;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.widget.Button;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

import java.util.Locale;

import sematec.mehdi.mymap.map.MapActivity_;
import sematec.mehdi.mymap.user.UserActivity_;
import sematec.mehdi.mymap.util.BaseActivity;
import sematec.mehdi.mymap.util.Util;

/**
 * Created by johndoe on 1/12/18.
 */

@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity {

    public static final String EXTRA_LOGIN = "sematec.mehdi.mymap.extra_login";

@AfterViews
void init() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    builder.setTitle(R.string.app_name);

    builder.setMessage(R.string.please_select_language);
    builder.setPositiveButton(R.string.persian, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //Set locale to Farsi
            Util.setLoale(WelcomeActivity.this, new Locale("fa_IR"));
        }
    });
    builder.setNegativeButton(R.string.english, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //Set locale to English
            Util.setLoale(WelcomeActivity.this, new Locale("en_US"));

        }
    });
    builder.show();

}
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