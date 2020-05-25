import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterDemo {

    static RateLimiter limiter = RateLimiter.create(2);

    public static void main(String[] args) {

        Runnable r = ()->{
            System.out.println(System.currentTimeMillis());
        };

        for (int i = 0; i < 50; i++) {

            if(!limiter.tryAcquire()){
                continue;
            }
            new Thread(r).start();
        }
    }

}
