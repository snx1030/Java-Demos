package geym.conc.ch5.guava.future;

import java.util.concurrent.Executors;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import geym.conc.ch5.future.RealData;

public class FutrueDemo {
    public static void main(String args[]) throws InterruptedException {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture<String> task = service.submit(new RealData("x"));

        task.addListener(() -> {
            System.out.print("异步处理成功:");
            try {
                System.out.println(task.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, MoreExecutors.directExecutor());

        System.out.println("main task done.....");
        Thread.sleep(3000);
    }
}
