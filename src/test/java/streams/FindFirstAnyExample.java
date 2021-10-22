package streams;

import java8.Student;
import java8.StudentDB;

import java.util.Optional;

public class FindFirstAnyExample {

    public static void main(String[] args) {
        // find any
        Optional<Student> any = StudentDB.getStudents().stream()
                .filter(student -> student.getGpa() >= 7)
                .findAny();
        any.ifPresent(System.out::println);

        // find first
        Optional<Student> first = StudentDB.getStudents().stream()
                .filter(student -> student.getGpa() >= 7)
                .findFirst();
        first.ifPresent(System.out::println);
    }
}
