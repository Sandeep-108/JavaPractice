package Java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String> {
    @Override
    public String get() {
        return "Supplier return";
    }

    public static void main(String[] args) {
//        Supplier<String> supplier = new SupplierDemo();
        //Using Lambda
        Supplier<String > supplier = () -> "Supplier demo";
        System.out.println(supplier.get());
        List<String> list2 = Arrays.asList();

        System.out.println(list2.stream().findAny().orElseGet(supplier));
        System.out.println(list2.stream().findAny().orElseGet(() -> "this is from lambda"));

    }
}
