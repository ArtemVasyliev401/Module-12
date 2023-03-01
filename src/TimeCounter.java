import java.util.concurrent.TimeUnit;

public class TimeCounter {

    public static void counterSecond() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsed = currentTime - startTime;
            System.out.println("Elapsed time: " + TimeUnit.MILLISECONDS.toSeconds(elapsed) + " seconds");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printMessage() {
        while (true) {
            System.out.println("Минуло 5 секунд");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}