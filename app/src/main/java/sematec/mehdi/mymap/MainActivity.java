package sematec.mehdi.mymap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;

import sematec.mehdi.mymap.map.MapActivity_;
import sematec.mehdi.mymap.util.BaseActivity;

/**
 * Created by johndoe on 1/12/18.
 */

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.options_menu)
public class MainActivity extends BaseActivity {

    @OptionsMenuItem
    MenuItem mapItem;

    @OptionsItem

    boolean mapItem () {
        mIntent = new Intent (mContext, MapActivity_.class);
        startActivity(mIntent);
        return true;
    }

}