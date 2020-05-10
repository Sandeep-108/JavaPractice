package threding.returning;

import commons.ValueReturningTaskA;

public class ReturningValueFirstWay {

    public static void main(String[] args) {
        System.out.println("["+Thread.currentThread().getName()+"] main thread Started here....");

        ValueReturningTaskA taskA=new ValueReturningTaskA(2,3,2);
        Thread t1=new Thread(taskA,"Thread-1");

        ValueReturningTaskA taskB=new ValueReturningTaskA(2,4,1);
        Thread t2=new Thread(taskB,"Thread-2");

        ValueReturningTaskA taskC=new ValueReturningTaskA(5,3,3);
        Thread t3=new Thread(taskC,"Thread-3");

        t1.start();
        t2.start();;
        t3.start();

        System.out.println("Sum value: "+taskA.getSum());
        System.out.println("Sum value: "+taskB.getSum());
        System.out.println("Sum value: "+taskC.getSum());

        System.out.println("["+Thread.currentThread().getName()+"] main thread stopped here....");
    }
}
