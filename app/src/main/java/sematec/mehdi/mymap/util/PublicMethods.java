package sematec.mehdi.mymap.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by johndoe on 1/13/18.
 */

public abstract class PublicMethods {
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, @StringRes int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
