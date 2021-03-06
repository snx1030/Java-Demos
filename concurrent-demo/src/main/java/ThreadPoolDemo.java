import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static class MyTask implements Runnable{


        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+":Thread Id:"
                                +Thread.currentThread().getId());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyTask task = new MyTask();

        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
    }
}
