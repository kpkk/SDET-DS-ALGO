package streams;

import java8.Student;
import java8.StudentDB;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSortExample {

    public static void main(String[] args) {

        List<Student> students = StudentDB.getStudents();
      //  System.out.println(students);
        Collections.sort(students,(a,b)->b.getName().compareTo(a.getName()));
      //  System.out.println(students);

        students.stream().sorted(Comparator.comparing(Student::getGpa).reversed()).forEach(System.out::println);
    }
}
