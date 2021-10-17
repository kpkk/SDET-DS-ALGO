package streams;

import java8.Student;
import java8.StudentDB;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMethodsExamples {

    public static List<String> getStudentActivities(){
       return StudentDB.getStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static long countNumberOfActivities(){
        return StudentDB.getStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        System.out.println(getStudentActivities());
        System.out.println(countNumberOfActivities());

    }
}
