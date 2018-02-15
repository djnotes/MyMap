import android.app.Application;

import com.backtory.java.internal.BacktoryClient;
import com.backtory.java.internal.KeyConfiguration;

import sematec.mehdi.mymap.R;
import sematec.mehdi.mymap.util.Constants;


/**
 * You are free to redistribute this source provided that you include this notice
 * Created by Mehdi Haghgoo on 2/7/18.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        BacktoryClient.init(KeyConfiguration.newBuilder()
                .setAuthKeys(getString(R.string.backtory_auth_id),
                        getString(R.string.backtory_client_key)
                )
                .build(),
         this);
    }
}
