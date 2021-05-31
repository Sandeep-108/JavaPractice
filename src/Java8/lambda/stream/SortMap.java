package Java8.lambda.stream;

import commons.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("eight", 8);
        map.put("four", 4);
        map.put("ten", 10);
        map.put("three", 3);
        map.put("one", 1);

        Map<Employee, Integer> empMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
        empMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
        empMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
        empMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
        empMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
        empMap.put(new Employee(176, "Prakash", "SOCIAL", 1200000), 120);

        empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);
        System.out.println(empMap);


//        List<Map.Entry<String,Integer>> entries = new ArrayList<>(map.entrySet());
//
//        Collections.sort(entries, (o1,o2) -> o1.getKey().compareTo(o2.getKey()));
//
//        for(Map.Entry e :entries) {
//            System.out.println(e);
//        }
//        System.out.println("**********************************************");
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
    }
}
