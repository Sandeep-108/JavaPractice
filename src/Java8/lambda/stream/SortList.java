package Java8.lambda.stream;

import commons.DataBase;
import commons.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
//        List<Integer> list2 = Arrays.asList(9,8,7,6,5,4,3,2,1);
//        Collections.sort(list2);//ASSENDING
//        Collections.reverse(list2);
//        System.out.println(list2);
//        //Using Stream
//        list2.stream().sorted().forEach(i -> System.out.println(i));//ASSENDING
//        list2.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.println(i));//Descending
        List<Employee> employeeList = DataBase.getEmployees();
//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return (int)( o1.getSalary()- o2.getSalary());
//            }
//        });
//        Collections.sort(employeeList, (o1,o2) -> (int)(o2.getSalary()-o1.getSalary()));
        //Using Stream API
//        employeeList.stream().sorted((o1,o2) -> (int)(o1.getSalary()-o2.getSalary())).forEach(System.out::println);
//        employeeList.stream().sorted(Comparator.comparing(employee -> employee.getSalary())).forEach(System.out::println);
        employeeList.stream().sorted(Comparator.comparing(Employee::getDept).reversed()).forEach(System.out::println);
//        System.out.println(employeeList);

    }
}
