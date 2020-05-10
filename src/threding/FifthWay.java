package threding;

public class FifthWay {
    public static void main(String[] args) {
        System.out.println("Main thread start here..................");
      //Using Lambda
       Thread t= new Thread(()->{
           for(int i=10;i>0;i--)
               System.out.println("<1> TICK TICK " + i);
       });
       t.start();

       //Using Java 7
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=10;i>0;i--)
                    System.out.println("<2> TICK TICK " + i);
            }
        }).start();
        System.out.println("Main thread stop here..................");
    }
}
