package threding.excecutor;

import commons.LoopTaskA;
import commons.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingCachedThreadPoolPart2 {

    public static void main(String[] args) {
        System.out.println("["+Thread.currentThread().getName()+"] main thread Started here....");
      //Creating Fixed thread pool
        //Initialization phase of executor service
        ExecutorService fixedThreadPoolExecutor= Executors.newCachedThreadPool(new NamedThreadFactory());
        //Service Phase of executor service
        fixedThreadPoolExecutor.execute(new LoopTaskA());
        fixedThreadPoolExecutor.execute(new LoopTaskA());
//        fixedThreadPoolExecutor.execute(new LoopTaskA());
//        fixedThreadPoolExecutor.execute(new LoopTaskA());
//        fixedThreadPoolExecutor.execute(new LoopTaskA());

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fixedThreadPoolExecutor.execute(new LoopTaskA());
        fixedThreadPoolExecutor.execute(new LoopTaskA());
        fixedThreadPoolExecutor.execute(new LoopTaskA());
        fixedThreadPoolExecutor.execute(new LoopTaskA());

        //Destruction of executor service
        fixedThreadPoolExecutor.shutdown();
        //exception
//        fixedThreadPoolExecutor.execute(new LoopTaskA());


        System.out.println("["+Thread.currentThread().getName()+"] main thread stopped here....");
    }
}
