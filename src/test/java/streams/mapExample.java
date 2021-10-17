package streams;

import java8.Student;
import java8.StudentDB;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class mapExample {

    public static void main(String[] args) {
        List<Student> students = StudentDB.getStudents();
        List<String> collect = students.stream().map(Student::getName).map(String::toUpperCase).collect(toList());
        System.out.println(collect);

    }
}
