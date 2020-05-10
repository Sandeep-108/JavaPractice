package threding.naming;

import commons.LoopTask;
import commons.LoopTaskA;

import java.util.concurrent.TimeUnit;

public class NamingThreadSecondWay {
    public static void main(String[] args) {

        String name=Thread.currentThread().getName();
        System.out.println("["+name+"] Main thread start here...........");

        new Thread(new LoopTaskA('A'),"MyThread-1").start();
        Thread t=new Thread(new LoopTaskA('A'));
//        t.setName("MyThread-2");
        t.start();
        try {
            TimeUnit.MILLISECONDS.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.setName("MyThread-2");
        System.out.println("["+name+"] Main thread end here...........");
    }
}
