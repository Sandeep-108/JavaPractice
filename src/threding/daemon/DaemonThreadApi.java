package threding.daemon;

import commons.LoopTaskDeamon;

public class DaemonThreadApi {
    public static void main(String[] args) {
        System.out.println("Main Thread Start here..............");
        Thread t1=new Thread(new LoopTaskDeamon(500),"Thread-1");
        t1.setDaemon(true);
        Thread t2=new Thread(new LoopTaskDeamon(1000),"Thread-2");
//        t2.setDaemon(true);
        t1.start();
        t2.start();


        System.out.println("Main Thread Stop here..............");
    }
}
