public class FloodTime implements Runnable {

    public int time;

    public FloodTime(int i) {
        time = i;
        Attack.setFlooding(true);
    }

    public void run() {
        try {
            Thread.sleep(time * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Attack.setFlooding(false);
    }

}