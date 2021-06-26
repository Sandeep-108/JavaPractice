package Java8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalPractice {

    static  ExecutorService threadPool =  Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            int id=i;
            Thread.sleep(5);
            threadPool.submit(()->{
                String op = null;
                Long time = System.currentTimeMillis();
                op = ThreadSafeFormatter.threadLocal.get().getBirthDayDate(time,id);
                SimpleDateFormat df = new SimpleDateFormat("dd-mm-yy hh:mm:sss:SSS");
                System.out.println("2id: "+id+" ,"+op +"date :"+df.format(new Date(time)));
            });
//            new Thread(()-> {
//                String op = null;         
//                    Long time = System.currentTimeMillis();
//                    op = formatter.getBirthDayDate(time,id);
//                SimpleDateFormat df = new SimpleDateFormat("dd-mm-yy hh:mm:sss:SSS");
//                System.out.println("2id: "+id+" ,"+op +"date :"+df.format(new Date(time)));
//            }).start();
        }

    }

}

class ThreadSafeFormatter{
    public static ThreadLocal<Formatter> threadLocal = new ThreadLocal<Formatter>(){

        @Override
        protected Formatter initialValue(){
            return new Formatter();
        }
    };
}

class Formatter{
    static int count =0;
    static String sdf = new String();
    public String getBirthDayDate(Long date, int id)  {
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yy hh:mm:sss:SSS");
        sdf = df.format(new Date(date));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sdf+" id:"+count++;
    }
}