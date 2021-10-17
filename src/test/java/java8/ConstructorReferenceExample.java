package java8;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> supplier=Student::new;
    static Function<String,Student>studentFunction=Student::new;

    public static void main(String[] args) {

        System.out.println(supplier.get());
        System.out.println(studentFunction.apply("pradeep"));

    }
}
