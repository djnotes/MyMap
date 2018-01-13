package sematec.mehdi.mymap.util;

/**
 * Created by johndoe on 1/13/18.
 */

public abstract class Constants {
    public static WebServiceInterface webInterface = RetrofitServiceGenerator.createService(WebServiceInterface.class);
    public static final String GOOGLE_API_KEY = "AIzaSyCCih-tzM2G1Vx9LGdo-k8RfuAu402uTvc";
}
