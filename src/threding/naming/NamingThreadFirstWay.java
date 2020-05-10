package threding.naming;

import commons.LoopTask;

public class NamingThreadFirstWay {
    public static void main(String[] args) {

        String name=Thread.currentThread().getName();
        System.out.println("["+name+"] Main thread start here...........");

        new Thread(new LoopTask('A')).start();
        Thread t=new Thread(new LoopTask('A'));
        t.start();
        System.out.println("["+name+"] Main thread end here...........");
    }
}
