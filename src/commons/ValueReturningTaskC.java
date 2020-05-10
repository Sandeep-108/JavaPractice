package commons;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskC implements Runnable {

    private int a;
    private int b;
    private static int count;
    private long sleepTime;
    private int sum;
    private String taskId;
    private int instanceNumber;


    public ValueReturningTaskC(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ReturnValueTaskC-" + instanceNumber;
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
        System.out.println("[" + Thread.currentThread().getName() + "]< TASK " + taskId + "> Addition done");
        synchronized (this) {
            System.out.println("[" + Thread.currentThread().getName() + "]< TASK " + taskId + "> synchronized ");
            this.notifyAll();
        }
    }

    public int getSum(){
        return sum;
    }

}
