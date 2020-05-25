public class JoinMain {

    public volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable r = ()->{

            for ( i = 0; i < 1000000; i++) {

            }
        };

        Thread thread = new Thread(r);

        thread.start();
        thread.join();

        System.out.println(i);

    }
}
