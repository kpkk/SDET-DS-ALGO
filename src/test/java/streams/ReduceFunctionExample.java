package streams;

import java8.Student;
import java8.StudentDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ReduceFunctionExample {


    public static Optional<Student> findHighestGPA(){
        List<Student> students = StudentDB.getStudents();
        return students.stream().reduce((a, b) -> a.getGpa() > b.getGpa() ? a : b);
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("geeks", "pradeep", "roger", "mike");

        Optional<String> reduce = list.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        reduce.ifPresent(System.out::println);

        Optional<String> reduce1 = list.stream().reduce((a, b) -> a + "-" + b);
        reduce1.ifPresent(System.out::println);


        List<Integer> integers = Arrays.asList(2, 1, 7, -4, 5);
        Integer reduce2 = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce2);

        // factorial calculation end range is exclusive
        int i = IntStream.range(1, 5)
                .reduce((a, b) -> a * b).
                        orElse(-1);
        System.out.println(i);

        Optional<Student> highestGPA = findHighestGPA();
        System.out.println(highestGPA.isPresent());
        highestGPA.ifPresent(System.out::println);
    }
}
