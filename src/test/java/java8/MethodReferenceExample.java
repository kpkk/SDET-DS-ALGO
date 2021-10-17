package java8;

import com.google.common.base.Supplier;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class MethodReferenceExample {

    public static void main(String[] args) {

        Function<String,String>function=String::toUpperCase;

        Supplier<List<Student>> getStudents = StudentDB::getStudents;

        System.out.println(function.apply("hello"));
        System.out.println(getStudents.get());
    }
}
