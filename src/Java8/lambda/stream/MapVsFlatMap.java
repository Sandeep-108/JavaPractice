package Java8.lambda.stream;

import commons.Customer;
import commons.DataBase;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    public static void main(String[] args) {

        List<Customer> customers = DataBase.getAll();

        //List<Customer> converts to List<String> Data transformation
        //customer -> customer.getEmail()  one to one mapping
        List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
        System.out.println(emails);

        //customer -> customer.getPhoneNumbers() -->>> one to many mapping
        List<List<String>> phoneNumbers = customers.stream().map(customer -> customer.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        //List<Customer> converts to List<String> Data transformation and Data Flattering
        //customer -> customer.getPhoneNumbers()  one to many mapping
        List<String> phones = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phones);
    }
}
