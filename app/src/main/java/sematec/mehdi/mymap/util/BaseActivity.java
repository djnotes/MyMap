package sematec.mehdi.mymap.util;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by johndoe on 1/12/18.
 */

public class BaseActivity extends AppCompatActivity {
    protected Context mContext = this;
    /**
    * This is a parameter we will use much. So I define it in this BaseActivity
     */
    protected Intent mIntent;

}
