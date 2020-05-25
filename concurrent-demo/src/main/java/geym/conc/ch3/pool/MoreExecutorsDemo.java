package geym.conc.ch3.pool;

import java.util.concurrent.Executor;

import com.google.common.util.concurrent.MoreExecutors;

public class MoreExecutorsDemo {
    public static void main(String[] args) {
        Executor exceutor = MoreExecutors.directExecutor();
        exceutor.execute(() -> System.out.println("I am running in " + Thread.currentThread().getName()));
    }
}
