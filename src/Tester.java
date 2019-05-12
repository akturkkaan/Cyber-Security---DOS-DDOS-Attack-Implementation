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
        //HTTPFloodDDos httpFloodDdos = new HTTPFloodDDos(url,port);

        //Test of HTTP FLOOD DOS
        //HTTPFloodDos httpFloodDos = new HTTPFloodDos(url, port, 3, 2000);

        //Test of UDP FLOOD DOS
        //UDPFlood udpflood = new UDPFlood(url, Integer.parseInt(port) );

        //Attack attack = new UDPFlood(url, Integer.parseInt(port));
        //Attack.begin(50, attack);


        //PacketBeast pBeast = new PacketBeast();
        //String output = pBeast.setInput( url, "10");
        UDPAttack ua =new UDPAttack(url); //<--- check the format of the ip
        ua.start();
        //udpflood.run();
    }
}
