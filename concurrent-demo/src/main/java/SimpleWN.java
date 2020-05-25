public class SimpleWN {

    final static Object object = new Object();

    public static void main(String[] args) {

        Runnable r1 =  ()->{

            synchronized (object){

                System.out.println(System.currentTimeMillis()+"T1:start");

                try {

                    System.out.println(System.currentTimeMillis()+"T1: wait for object");

                    object.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(System.currentTimeMillis()+"T1:end");
            }


        };


        Runnable r2 = ()->{


            synchronized (object){
                System.out.println(System.currentTimeMillis()+"T2 start notify one thread");

                object.notify();

                System.out.println(System.currentTimeMillis()+"T2 end");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };


        new Thread(r1).start();

        new Thread(r2).start();


    }

}
