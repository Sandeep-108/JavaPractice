package Java8.lambda.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Albert");
        list.add("Charlee");
        list.add("ABravo");
        list.add("Daavid");
        list.add("riva");

        Predicate<String> predicate = t -> t.startsWith("A");
        list.stream().filter(predicate).forEach(t -> System.out.println(t));
        list.stream().filter(t -> t.startsWith("A")).forEach(t -> System.out.println(t));

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

        map.forEach((k,v) -> System.out.println(k+":"+v));

        map.entrySet().stream().filter(obj -> obj.getKey()%2 != 0).forEach(obj -> System.out.println(obj));

//        Consumer<String> consumer = t -> System.out.println(t);
//        for(String s: list) {
//            consumer.accept(s);
//        }
    }
}
