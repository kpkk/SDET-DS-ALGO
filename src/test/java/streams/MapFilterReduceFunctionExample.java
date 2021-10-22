package streams;

import java8.Student;
import java8.StudentDB;

public class MapFilterReduceFunctionExample {

    public static void main(String[] args) {
        Double reduce = StudentDB.getStudents().stream()
                .filter((student) -> student.getGpa() > 9)
                .map(Student::getGpa)
                .reduce(0.0, Double::sum);
        System.out.println(reduce);

    }
}
