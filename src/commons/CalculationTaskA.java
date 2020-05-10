package commons;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskA implements Callable<Integer> {

    private static int count=0;
    private int a;
    private int b;
    private int instanceNumber;
    private long sleepTime;
    private String taskId;

    public CalculationTaskA(int a,int b,long sleepTime){
        this.a=a;
        this.b=b;
        this.sleepTime=sleepTime;
        this.instanceNumber=++count;
        this.taskId="CallTaskA <"+instanceNumber+">";
    }
    @Override
    public Integer call() throws Exception {
        System.out.println("##############["+Thread.currentThread().getName()+"]< TASK "+taskId+"> STARTING ######");
        System.out.println("["+Thread.currentThread().getName()+"]< TASK "+taskId+"> sleeping for "+sleepTime);
        TimeUnit.SECONDS.sleep(sleepTime);
        System.out.println("["+Thread.currentThread().getName()+"]< TASK "+taskId+"> awake form sleep");
        return a+b;
    }
}
