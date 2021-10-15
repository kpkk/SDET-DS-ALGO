package java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

   static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> biFunction=(students, studentPredicate) -> {
        HashMap<String, Double>map=new HashMap<>();
        students.forEach(student ->{
            if (studentPredicate.test(student)) {
                map.put(student.getName(),student.getGpa());
            }
        });
        return map;
    };


    public static void main(String[] args) {

        List<Student> students = StudentDB.getStudents();
        Predicate<Student>p1=student -> student.getGpa()>8;
        System.out.println( biFunction.apply(students,p1));


    }
}
