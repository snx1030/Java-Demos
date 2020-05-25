import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(10);

        Runnable r1= ()->{

            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis()/1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        };

        exec.scheduleAtFixedRate(r1,0,2, TimeUnit.SECONDS);
    }
}
