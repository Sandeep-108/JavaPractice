package commons;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {

    public static int count=0;
    public static String threadName="MyThread-";

    @Override
    public Thread newThread(Runnable r) {
        Thread thread=new Thread(r,threadName+ ++count);

        return thread;
    }
}
