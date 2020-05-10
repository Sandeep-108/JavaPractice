package commons;

import java.util.concurrent.TimeUnit;

public class LoopTask implements Runnable{

    private static int count;
    private int id;
    private String taskId;
    @Override
    public void run(){
        Thread.currentThread().setName("Amazing-Thread-"+id);
        String name=Thread.currentThread().getName();
        System.out.println("##############["+name+"]<"+taskId+"> STARTING ######");

        loopExecution(taskId);
        System.out.println("##############["+name+"]< TASK "+taskId+"> ENDING ######");
    }
    public LoopTask(){
       id=++count;
        taskId=""+ id;
    }
    public LoopTask(char c){
        id=++count;
        taskId="LoopTask"+c+id;
    }

    public static void loopExecution(String taskId){
        for(int i=10;i>0;i--){
            System.out.println("["+Thread.currentThread().getName()+"]<"+taskId+"> TICK TICK "+i);
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
