package Java8.lambda.stream;

import commons.Customer;
import commons.DataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    private static Customer getCustomerByEmail(String email){
        List<Customer> customers = DataBase.getAll();
        return  customers.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email)).findAny().orElseThrow(()-> new RuntimeException("no customer present"));
    }

    public static void main(String[] args) {

        Customer customer = new Customer(101, "afdffd sdf", "john@gmail.com", Arrays.asList("397937955", "21654725"));

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        //this will check null
        Optional<String> email = Optional.of(customer.getEmail());
        System.out.println(email);

        Optional<String> name = Optional.ofNullable(customer.getName());
        System.out.println(name);

        if(name.isPresent())
            System.out.println(name.get());
        System.out.println(name.orElse("name "));

//        System.out.println(name.orElseThrow(() ->new IllegalArgumentException("Name not present")));

        System.out.println(name.map(String::toUpperCase).orElseGet(()->"default name"));

        System.out.println(getCustomerByEmail("prq"));
    }
}
