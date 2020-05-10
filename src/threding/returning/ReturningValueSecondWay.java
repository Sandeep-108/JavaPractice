package threding.returning;

import commons.SumObserver;
import commons.ValueReturningTaskB;

public class ReturningValueSecondWay {

    public static void main(String[] args) {
        System.out.println("["+Thread.currentThread().getName()+"] main thread Started here....");

        ValueReturningTaskB taskA=new ValueReturningTaskB(2,3,2,new SumObserver("Task-1"));
        Thread t1=new Thread(taskA,"Thread-1");

        ValueReturningTaskB taskB=new ValueReturningTaskB(2,4,1,new SumObserver("Task-2"));
        Thread t2=new Thread(taskB,"Thread-2");

        ValueReturningTaskB taskC=new ValueReturningTaskB(5,3,3,new SumObserver("Task-3"));
        Thread t3=new Thread(taskC,"Thread-3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("["+Thread.currentThread().getName()+"] main thread stopped here....");
    }
}
