package commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataBase {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(176, "Roshan", "IT", 600000));
        list.add(new Employee(388, "Bikash", "CIVIL", 900000));
        list.add(new Employee(470, "Bimal", "IT", 500000));
        list.add(new Employee(624, "Sourav", "CORE", 400000));
        list.add(new Employee(176, "Prakash", "IT", 1200000));
        return list;
    }

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());

    }

    public static List<Employee> getRandomEmp(){
        List<Employee> list = new ArrayList<>();
        for(int i=0;i<1000;i++) {
            list.add(new Employee(i, "employee"+i, "IT",  new Random().nextInt(1000*100)));
        }
        return list;
    }
}