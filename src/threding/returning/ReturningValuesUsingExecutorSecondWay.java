package threding.returning;

import commons.CalculationTaskB;
import commons.LoopTaskA;
import commons.NamedThreadFactory;
import commons.TaskResult;

import java.util.concurrent.*;

public class ReturningValuesUsingExecutorSecondWay {

    public static void main(String[] args) {
        System.out.println("[" + Thread.currentThread().getName() + "] main thread Started here....");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
        CompletionService<TaskResult<String ,Integer>> completionService=new ExecutorCompletionService<TaskResult<String ,Integer>>(executorService);
        

        completionService.submit(new CalculationTaskB(5, 7, 2));
        completionService.submit(new CalculationTaskB(1, 2, 3));
        completionService.submit(new CalculationTaskB(10, 9, 2));
//        Future<?> res4 = executorService.submit(new LoopTaskA());
        completionService.submit(new LoopTaskA(), new TaskResult<>("LoopTaskA-1",999));

        executorService.shutdown();

        try {
           for(int i=0;i<4;i++){
               System.out.println("Result = "+completionService.take().get());
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("[" + Thread.currentThread().getName() + "] main thread Stopped here....");
    }
}
