package threding.returning;

import commons.CalculationTaskA;
import commons.LoopTaskA;
import commons.NamedThreadFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValuesUsingExecutorFirstWay {

    public static void main(String[] args) {
        System.out.println("["+Thread.currentThread().getName()+"] main thread Started here....");

        ExecutorService executorService= Executors.newCachedThreadPool(new NamedThreadFactory());
       Future<Integer> rs1= executorService.submit(new CalculationTaskA(5,7,2));
       Future<Integer> rs2= executorService.submit(new CalculationTaskA(1,2,3));
       Future<Integer> rs3= executorService.submit(new CalculationTaskA(10,9,2));
       Future<?> res4 =executorService.submit(new LoopTaskA());
       Future<Double> res5= executorService.submit(new LoopTaskA(), 99.665);

       executorService.shutdown();

        try {
            System.out.println("Result-1 "+rs1.get());
            System.out.println("Result-2 "+rs2.get());
            System.out.println("Result-3 "+rs3.get());
            System.out.println("Result-4 "+res4.get());
            System.out.println("Result-4 "+res5.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("["+Thread.currentThread().getName()+"] main thread Stopped here....");
    }
}
