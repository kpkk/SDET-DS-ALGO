package java8;

import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BiPredicateExample {

    static BiPredicate<Integer, Double> biPredicate=(grade, gpa)->grade>3 && gpa>=5.5;

    static Consumer<Student> consumer=(student -> System.out.println(student));


    public static void main(String[] args) {

        List<Student> students = StudentDB.getStudents();
        students.forEach(student -> {if(biPredicate.test(student.getGradeLevel(),student.getGpa())){
        consumer.accept(student);
        }
        });
    }
}
