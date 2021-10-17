package streams;

import java8.Student;
import java8.StudentDB;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        List<Student> students = StudentDB.getStudents();

        Map<String, List<String>> collect = students.stream()
                .filter(student -> student.getGpa()>=9)
                .filter(student -> student.getGradeLevel()>=3)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println(collect);


    }
}
