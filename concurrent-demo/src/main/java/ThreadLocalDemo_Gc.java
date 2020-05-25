import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo_Gc {

    static volatile ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected void finalize(){
            System.out.println(this.toString()+"is gc");
        }
    };

    static volatile CountDownLatch cd = new CountDownLatch(10000);

    private static Runnable warp(int i){

        return ()->{

            try {
                if(t1.get() == null){

                    t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS" ){
                        @Override
                        protected void finalize() {
                            System.out.println(this.toString()+"is gc");
                        }
                    });

                    System.out.println(Thread.currentThread().getId() +": create simpleDataFormat");
                }

                Date t = t1.get().parse("2020-02-02 19:29:" + i % 60);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {

                cd.countDown();
            }
        };

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {

            es.execute(warp(i));

        }

        cd.await();

        System.out.println("mission complete");

        t1 = null;

        System.gc();

        System.out.println("first gc complete");

        t1 =new ThreadLocal<SimpleDateFormat>();

        cd = new CountDownLatch(10000);

        for (int j = 0; j < 10000; j++) {

            es.execute(warp(j));

        }

        cd.await();

        Thread.sleep(1000);

        System.gc();

        System.out.println("second gc complete");
    }
}
