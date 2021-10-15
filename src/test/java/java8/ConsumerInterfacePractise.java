package java8;

import com.google.common.cache.RemovalListener;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ConsumerInterfacePractise {
    static Consumer<Student> c1=(student)-> System.out.println(student);
    static Consumer<Student>c2=(student)-> System.out.println(student.getName());
    static Consumer<Student>c3=(student)-> System.out.println(student.getActivities());



    public static void printStudent(){
        List<Student> students = StudentDB.getStudents();
        students.forEach(c1);

    }
    public static void printNameAndActivity(){
        List<Student> students = StudentDB.getStudents();

        students.forEach(c2.andThen(c3));
    }
    public static void printNameAndActivityusingCondition(){
        List<Student> students=StudentDB.getStudents();
        students.forEach((student)->{if(student.getGradeLevel()>3)
        c2.andThen(c3).accept(student);});
    }

    public static void main(String[] args) {
        Consumer<Integer>c=(a)-> System.out.println(a*a);
        c.accept(12);
        Consumer<String>c1=(s)-> System.out.println(s.toUpperCase());
        c1.accept("pradeep");
      //  System.out.println(StudentDB.getStudents());
     //   printStudent();
      //  printNameAndActivity();
        printNameAndActivityusingCondition();
    }
}
