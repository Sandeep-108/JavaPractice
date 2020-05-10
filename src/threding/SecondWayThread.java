package threding;

import java.util.concurrent.TimeUnit;

public class SecondWayThread {
    public static void main(String[] args) {
        System.out.println("Thread Start here ........");
        Thread t= new SecondTask();
        t.start();
        System.out.println("Thread 1 is alive "+t.isAlive());
        new SecondTask().start();
        System.out.println("Thread End here ........");
    }
}


class SecondTask extends Thread{
    private static int count;
    private int id;
    @Override
    public void run() {
        for (int i=10;i>0;i--){
            System.out.println("<"+id+"> TICK TIK "+i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            }catch (Exception e){}
        }
    }

    public SecondTask(){
        this.id=++count;
    }
}