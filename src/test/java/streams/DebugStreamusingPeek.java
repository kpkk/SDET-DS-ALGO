package streams;

import java8.Student;
import java8.StudentDB;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DebugStreamusingPeek {

    public static void main(String[] args) {
        List<Student> students = StudentDB.getStudents();
        Predicate<Student>p1=student -> student.getGradeLevel()>=3;
        Predicate<Student>p2=student -> student.getGpa()>=9;

        Map<String, List<String>> collect = students.parallelStream()
                .filter(p1)
                .peek((student)-> System.out.println(student))
                .filter(p2)
                .peek((student)-> System.out.println("second filter "+student))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(collect);
    }
}
