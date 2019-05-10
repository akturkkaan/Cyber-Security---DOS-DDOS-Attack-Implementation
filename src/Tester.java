import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;
public class Tester {


    public static void main (String []args) throws Exception
    {
        String url = "localhost";
        String port = "5056";

        //Test of HTTP FLOOD DDOS
        HTTPFloodDDos httpFloodDdos = new HTTPFloodDDos(url,port);
                    //httpFloodDdos.startHTTPFloodDDos(url,port);


        //Test of HTTP FLOOD DOS
        //HTTPFloodDos httpFloodDos = new HTTPFloodDos(url, port, 3, 2000);

    }
}
