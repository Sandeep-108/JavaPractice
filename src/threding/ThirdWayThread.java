package threding;

public class ThirdWayThread {

    public static void main(String[] args) {
        System.out.println("Main Thread start here........ ");
        new ThirdTask();
        new ThirdTask();
        System.out.println("Main Thread stop here........ ");
    }
}


class ThirdTask implements Runnable{
    private static int count;
    private int id;

    @Override
    public void run() {
        for(int i=10;i>0;i--)
            System.out.println("<"+id+"> TICK TICK "+i);
    }

    public ThirdTask(){
        this.id=++count;
        new Thread(this).start();
    }
}