package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        Supplier<Student> supplier=()->{
            return new Student("abc","male",7.5,3, Arrays.asList("swimming","eating","gaming"));
        };

        System.out.println( supplier.get());

        Supplier<List<Student>> supplier1=()->{return StudentDB.getStudents();};
        System.out.println(supplier1.get());

    }
}
