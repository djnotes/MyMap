package sematec.mehdi.mymap.map;

/**
 * Created by johndoe on 1/13/18.
 */

public class MapPresenter implements MapContract.Presenter {
    MapContract.View mView;

    @Override
    public void attachView(MapContract.View view) {
        mView = view;
    }

}
