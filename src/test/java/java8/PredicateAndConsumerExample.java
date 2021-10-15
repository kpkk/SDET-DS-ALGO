package java8;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static Predicate<Student> p1=student -> student.getGradeLevel()>3;
    static Predicate<Student>p2=student -> student.getGpa()>7;
    static BiConsumer<String, List<String>> c1=((name,activities)-> {System.out.println(name+" : "+activities);});

    public void printStudentdetails(){
        List<Student> students = StudentDB.getStudents();
        students.forEach((student)->{if(p1.and(p2).test(student))
            c1.accept(student.getName(),student.getActivities());
        });
    }

    public static void main(String[] args) {
      new PredicateAndConsumerExample().printStudentdetails();


    }
}
