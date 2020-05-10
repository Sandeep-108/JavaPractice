package threding.naming;

import commons.LoopTask;
import commons.LoopTaskA;
import commons.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingExecutorThread {
    public static void main(String[] args) {
        System.out.println("Main Thread Start Here.............");

        //Create Executor Service
        ExecutorService executorService= Executors.newCachedThreadPool(new NamedThreadFactory());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());

        executorService.shutdown();

        System.out.println("Main Thread Stop Here.............");
    }
}
