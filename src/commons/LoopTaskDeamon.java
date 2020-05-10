package commons;

import java.util.concurrent.TimeUnit;

public class LoopTaskDeamon implements Runnable{

    private static int count;
    private long sleepTime;
    private int id;
    private String taskId;
    @Override
    public void run(){
//        String name=Thread.currentThread().getName();
        boolean isDaemonThread=Thread.currentThread().isDaemon();
        String threadType= isDaemonThread?"DAEMON":"USER";
//        System.out.println("##############["+name+"]<"+taskId+"> STARTING ######");
        System.out.println("##############["+Thread.currentThread().getName()+" , "+threadType+"]< TASK "+taskId+"> STARTING ######");

        for(int i=10;i>0;i--) {
            System.out.println("[" + Thread.currentThread().getName() + ", "+threadType+"]<" + taskId + "> TICK TICK " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("##############["+name+"]< TASK "+taskId+"> ENDING ######");
        System.out.println("##############["+Thread.currentThread().getName()+" , "+threadType+"]< TASK "+taskId+"> ENDING ######");
    }
    public LoopTaskDeamon(){
       id=++count;
        taskId=""+ id;
    }
    public LoopTaskDeamon(long sleepTime){
        this.sleepTime=sleepTime;
        id=++count;
        taskId="TaskD"+ id;
    }
}
