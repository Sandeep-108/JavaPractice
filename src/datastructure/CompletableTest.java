package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CompletableTest {

    public static void main(String[] args) {

        List<CompletableFuture> future=new ArrayList<>();
        for(Integer i: Arrays.asList(1,2,3,4,5,6,7,8,9)){
            CompletableFuture<Boolean> fu =CompletableFuture.supplyAsync(()->
             i%2==0);
            CompletableFuture<Integer> f=fu.thenApplyAsync((b)->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return b? null:i;
            });
            future.add(f);
        }
        Long t1=System.currentTimeMillis();
        System.out.println("loop ended here");
       List<Integer> iList=future.stream().map(f -> {
           Integer i=null;
           try {
               i= (Integer) f.get();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
           return i;
       }).collect(Collectors.toList());
        System.out.println("List is "+iList);
        System.out.println("time in second"+(System.currentTimeMillis()-t1)/1000);

    }
}
