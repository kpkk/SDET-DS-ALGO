package streams;

import com.google.common.base.Supplier;
import java8.Student;
import java8.StudentDB;

import java.util.List;

public class MatchFunctionsExample {

    public static void main(String[] args) {

        // all match
        boolean b = StudentDB.getStudents().stream()
                .allMatch(student -> student.getGpa() > 3);
        System.out.println(b);

        // any match
        boolean b1 = StudentDB.getStudents().stream()
                .anyMatch(student -> student.getGradeLevel() > 11);
        System.out.println(b1);

        // none match
        boolean b2 = StudentDB.getStudents().stream()
                .noneMatch(student -> student.getGradeLevel() > 11);
        System.out.println(b2);


    }
}
