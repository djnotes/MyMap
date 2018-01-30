package sematec.mehdi.mymap.user;

import android.content.Context;

/**
 * Created by Mehdi Haghgoo on 1/30/18.
 */

public interface UserContract {
    public interface View {

    }

    public interface Presenter {
        public void attachView(View view);
        public void attachContext(Context context);
    }
}
