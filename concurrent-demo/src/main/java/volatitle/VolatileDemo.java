package volatitle;

/**
 * @program: zhr66-study
 * @description:
 * @author: Rui.Zhou
 * @create: 2019-09-20 19:22
 **/
public class VolatileDemo implements Runnable{


    private boolean flag = true;




    public static void main(String[] args) throws InterruptedException {

        VolatileDemo stopThreadTest = new VolatileDemo();
        Thread thread = new Thread(stopThreadTest);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopThreadTest.flag = false;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(i);
        }
        System.out.println("计数器已经停止");
    }
}
