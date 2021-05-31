package Java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    //Using class implement
//public class PredicateDemo implements Predicate<Integer> {
//    @Override
//    public boolean test(Integer t) {
//       return t%2 == 0 ;
//    }

    public static void main(String[] args) {
//        Predicate<Integer> predicate = new PredicateDemo();
        //Using Anonymous class
//        Predicate<Integer> predicate = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer %2 == 0;
//            }
//        };
        //Using Lambda
        Predicate<Integer> predicate = t -> t % 2 == 0;
        System.out.println("test4: " + predicate.test(4));

        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        list2.stream().filter(predicate).forEach(t -> System.out.println("printing even: " +t));
        //Using lambda instead predicate
        list2.stream().filter(t -> t % 2 == 0 ).forEach(t -> System.out.println("printing even: " +t));

    }
}
