package threding;

import java.util.concurrent.TimeUnit;

public class FirstWayThread {
    public static void main(String[] args) {
        System.out.println("Thread Start here...........");
        new FirstTask();
        Thread t= new FirstTask();
        System.out.println("Thread end here...........");
    }
}

class FirstTask extends Thread{
    private static int count;
    private int id;
    @Override
    public void run() {
        for(int i=10;i>0;i--) {
            System.out.println("<"+id+">TICK TICK " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            }catch (Exception e){}
        }
    }
    public FirstTask(){
        this.id=++count;
        this.start();
    }
}