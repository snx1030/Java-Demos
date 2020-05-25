package geym.conc.ch3.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.util.concurrent.MoreExecutors;

public class MoreExecutorsDemo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor exceutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
        MoreExecutors.getExitingExecutorService(exceutor);
        exceutor.execute(() -> System.out.println("I am running in " + Thread.currentThread().getName()));
    }
}
