import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TraceThreadPoolExecutor extends ThreadPoolExecutor {


    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }

    private Runnable wrap(final Runnable task,final Exception clientTrace,String clientThreadName) {

        return ()->{
            try {
                task.run();
            } catch (Exception e) {
                clientTrace.printStackTrace();
                throw e;
            }
        };
    }

    private Exception clientTrace(){

        return new Exception("Client atack trace");
    }

    private Runnable divTask(int a,int b){

        return ()->{
            double re = a/b;
            System.out.println(re);
        };
    }

    public static void main(String[] args) {
        TraceThreadPoolExecutor pool = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {

            pool.execute(pool.divTask(100,i));


        }
    }
}
