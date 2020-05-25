import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = ()->{

            System.out.println(System.currentTimeMillis() +":Thread ID:"
                                +Thread.currentThread().getId());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10),
                r -> {
                    Thread t = new Thread(r);
                    System.out.println("create" + t);
                    return t;
                },
                (r, executor) -> System.out.println(r.toString() + "is discard"));


        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            es.submit(task);

            Thread.sleep(10);
        }


    }
}
