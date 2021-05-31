package Java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
//public class ConsumerDemo implements Consumer<Integer> {

//    @Override
//    public void accept(Integer t) {
//        System.out.println("printing: "+t);
//    }

    public static void main(String[] args) {
//        ConsumerDemo cd = new ConsumerDemo();
//        cd.accept(10);
        //Same using Lambda Expression
        Consumer<Integer> consumer = t -> System.out.println("printing: "+t);
        consumer.accept(10);

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);

//        list1.stream().forEach(consumer);
        //WE can directly pass lambda
        list1.stream().forEach(t -> System.out.println("printing: " +t));
    }
}
