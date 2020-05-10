package commons;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskB implements Callable<TaskResult<String ,Integer>> {

    private static int count=0;
    private int a;
    private int b;
    private int instanceNumber;
    private long sleepTime;
    private String taskId;

    public CalculationTaskB(int a, int b, long sleepTime){
        this.a=a;
        this.b=b;
        this.sleepTime=sleepTime;
        this.instanceNumber=++count;
        this.taskId="CallTaskB <"+instanceNumber+">";
    }
    @Override
    public TaskResult<String ,Integer> call() throws Exception {
        System.out.println("##############["+Thread.currentThread().getName()+"]< TASK "+taskId+"> STARTING ######");
        System.out.println("["+Thread.currentThread().getName()+"]< TASK "+taskId+"> sleeping for "+sleepTime);
        TimeUnit.SECONDS.sleep(sleepTime);
        System.out.println("["+Thread.currentThread().getName()+"]< TASK "+taskId+"> awake form sleep");
        return new TaskResult<>(taskId,a+b);
    }
}
