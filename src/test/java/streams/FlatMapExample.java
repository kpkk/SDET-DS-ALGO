package streams;

import java8.Student;
import java8.StudentDB;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FlatMapExample {

    public static List<String> printStudentActivities(){
        return StudentDB.getStudents().stream().map(Student::getActivities)
                .flatMap(List::stream).collect(Collectors.toList());
    }

    public static void main(String[] args) {


        List<Student> students = StudentDB.getStudents();

        List<String> collect = students.stream()
                .map(Student::getActivities)
                 .flatMap(List::stream)
                .collect(toList());
        System.out.println(collect);
    }
}
