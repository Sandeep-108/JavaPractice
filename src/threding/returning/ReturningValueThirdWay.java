package threding.returning;

import commons.ValueReturningTaskC;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ReturningValueThirdWay {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("["+Thread.currentThread().getName()+"] main thread Started here....");

        ValueReturningTaskC taskA=new ValueReturningTaskC(2,3,1);
        Thread t1=new Thread(taskA,"Thread-1");

        ValueReturningTaskC taskB=new ValueReturningTaskC(2,4,2);
        Thread t2=new Thread(taskB,"Thread-2");

        ValueReturningTaskC taskC=new ValueReturningTaskC(5,3,3);
        Thread t3=new Thread(taskC,"Thread-3");

        Map<String ,String > contact=new HashMap();
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        System.out.println("Result 1 Sum value: "+taskA.getSum());
        t2.join();
        System.out.println("Result 2 Sum value: "+taskB.getSum());
        t3.join();
        System.out.println("Result 3 Sum value: "+taskC.getSum());

        System.out.println("["+Thread.currentThread().getName()+"] main thread stopped here....");
    }
}
