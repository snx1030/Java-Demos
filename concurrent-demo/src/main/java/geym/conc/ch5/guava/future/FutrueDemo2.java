package geym.conc.ch5.guava.future;

import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import geym.conc.ch5.future.RealData;

public class FutrueDemo2 {
	public static void main(String args[]) throws InterruptedException {
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		ListenableFuture<String> task = service.submit(new RealData("x"));

		Futures.addCallback(task, new FutureCallback<String>() {
			public void onSuccess(String o) {
				System.out.println("异步处理成功,result=" + o);
			}

			public void onFailure(Throwable throwable) {
				System.out.println("异步处理失败,e=" + throwable);
			}
		}, MoreExecutors.newDirectExecutorService());

		System.out.println("main task done.....");
		Thread.sleep(3000);
	}
}
