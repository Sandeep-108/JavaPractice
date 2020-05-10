package commons;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable{

    private static int count;
    private int id;
    private String taskId;
    @Override
    public void run(){
//        String name=Thread.currentThread().getName();
//        System.out.println("##############["+name+"]<"+taskId+"> STARTING ######");
        System.out.println("##############["+Thread.currentThread().getName()+"]< TASK "+taskId+"> STARTING ######");

        LoopTask.loopExecution(taskId);
//        System.out.println("##############["+name+"]< TASK "+taskId+"> ENDING ######");
        System.out.println("##############["+Thread.currentThread().getName()+"]< TASK "+taskId+"> ENDING ######");
    }
    public LoopTaskA(){
       id=++count;
        taskId=""+ id;
    }
    public LoopTaskA(char c){
        id=++count;
        taskId="LoopTask"+c+id;
    }
}
