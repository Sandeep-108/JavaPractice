package Java8.lambda.stream;

import commons.DataBase;
import commons.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,9,3,2,7,5,6);

        List<String> words = Arrays.asList("java","Spring", "hibernate");


        int sum = list.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
        Integer rsum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(rsum);

        Optional<Integer> reduceSumWithMethodRefrence = list.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodRefrence.get());

        System.out.println("multiply "+list.stream().reduce(1,(a,b)->a*b));

        Integer maxValue = list.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxValue);
        Integer maxValueWithMethodReference = list.stream().reduce(Integer::max).get();
        System.out.println(maxValueWithMethodReference);

        String longWord = words.stream().reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2).get();
        System.out.println(longWord);

        //Employee whose dept is IT
        //get Salary
        double avgSalary = DataBase.getEmployees().stream().filter(e -> e.getDept().equalsIgnoreCase("IT"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(avgSalary);

        double sumSalary = DataBase.getEmployees().stream().filter(e->e.getDept().equalsIgnoreCase("IT"))
                .map(Employee::getSalary)
                .mapToDouble(i->i)
                .sum();
        System.out.println(sumSalary);
    }
}
