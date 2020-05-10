package threding;

import java.util.concurrent.TimeUnit;

public class FourthWay {
    public static void main(String[] args) {
        System.out.println("Main thread start here................");
        new Thread(new FourthTask()).start();
        Thread t=new Thread(new FourthTask());
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        }catch (Exception e){}
        t.start();
        System.out.println("Main thread stop here................");
    }
}



class FourthTask implements Runnable{
    private static int count;
    private int id;
    public String name="parent";
    @Override
    public void run() {
        for (int i=10;i>0;i--){
            System.out.println("<"+id+"> TICK TIK "+i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            }catch (Exception e){}
        }
    }

    public FourthTask(){
        this.id=++count;
    }
}

class SS extends FourthTask{
    public String name;
    public SS(){
        name="child";
        System.out.println(super.name);
    }
}