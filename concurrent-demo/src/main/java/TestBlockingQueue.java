import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueue {


    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);

        Random random = new Random();


        Runnable consumer = () -> {
            try {
                Thread.sleep(random.nextInt(10));
                System.out.println(Thread.currentThread().getName() + "trying...");
                String temp = queue.take();//如果队列为空，会阻塞当前线程
                System.out.println(Thread.currentThread().getName() + " get a job " + temp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Runnable producer = () -> {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(random.nextInt(10));
                    String task = Thread.currentThread().getName() + " made a product " + i;
                    System.out.println(task);
                    queue.put(task);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }

        };


        for (int i = 0; i < 3; i++) {
            new Thread(producer, "Producer" + (i + 1)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(consumer, "Consumer" + (i + 1)).start();
        }

        new Thread(producer, "Producer" + (5)).start();

    }


}
