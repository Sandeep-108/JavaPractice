package Java8.lambda.paralelstream;

import commons.DataBase;
import commons.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        IntStream.range(1,100).forEach(System.out::print);
        long end = System.currentTimeMillis();
        System.out.println("time taken: "+ (end-start));

        System.out.println("=========================================");
        start = System.currentTimeMillis();
        IntStream.range(1,100).parallel().forEach(System.out::print);
        end = System.currentTimeMillis();
        System.out.println(" Parrlel time taken: "+ (end-start));

        //Check multi core execution

        IntStream.range(1,10).forEach(x->
                System.out.println("ThreadName: "+ Thread.currentThread().getName()+": "+x));
        System.out.println("=========================================");
        IntStream.range(1,10).parallel().forEach(x->
                System.out.println("ThreadName: "+ Thread.currentThread().getName()+": "+x));
        System.out.println("=========================================");
        List<Employee> employees = DataBase.getRandomEmp();
        start = System.currentTimeMillis();
        OptionalDouble avgSalaryPlain = employees.stream().map(Employee::getSalary).mapToDouble(i -> i).average();
        end = System.currentTimeMillis();
        System.out.println(" Emp plain time taken: "+ (end-start)+" avg: "+avgSalaryPlain.getAsDouble());
        System.out.println("=========================================");
        start = System.currentTimeMillis();
        OptionalDouble averageparalel = employees.parallelStream().mapToDouble(Employee::getSalary).average();
        end = System.currentTimeMillis();
        System.out.println(" Emp parrlel time taken: "+ (end-start)+" avg: "+averageparalel.getAsDouble());

    }
}
