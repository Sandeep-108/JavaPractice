package threding.excecutor;

import commons.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCachedThreadPool {

    public static void main(String[] args) {
        System.out.println("["+Thread.currentThread().getName()+"] main thread Started here....");
      //Creating Fixed thread pool
        //Initialization phase of executor service
        ExecutorService fixedThreadPoolExecutor= Executors.newCachedThreadPool();
        //Service Phase of executor service
        fixedThreadPoolExecutor.execute(new LoopTaskA());
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
