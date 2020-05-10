package commons;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable {

    private int a;
    private int b;
    private static int count;
    private long sleepTime;
    private int sum;
    private String taskId;
    private int instanceNumber;

    private volatile boolean done = false;

    public ValueReturningTaskA(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ReturnValueTaskA-" + instanceNumber;
    }

    @Override
    public void run() {
        System.out.println("##############[" + Thread.currentThread().getName() + "]< TASK " + taskId + "> STARTING ######");
        System.out.println("[" + Thread.currentThread().getName() + "]< TASK " + taskId + "> sleeping for " + sleepTime);
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + Thread.currentThread().getName() + "]< TASK " + taskId + "> awake form sleep");
        sum = a + b;
        done = true;
        System.out.println("[" + Thread.currentThread().getName() + "]< TASK " + taskId + "> Addition done");
        synchronized (this) {
            System.out.println("[" + Thread.currentThread().getName() + "]< TASK " + taskId + "> synchronized ");
            this.notifyAll();
        }
    }

    public int getSum(){
        if(!done){
            synchronized (this){
                System.out.println("["+Thread.currentThread().getName()+"]< TASK "+taskId+"> get sum waiting for result");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("["+Thread.currentThread().getName()+"]< TASK "+taskId+"> Calculation done");
        }
        return sum;
    }

}
