package java8;

import leetCodeRandomPick.ArrayNesting;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerInterfacePractise {

    public static void main(String[] args) {

        List<Student> students = StudentDB.getStudents();

        BiConsumer<String, String> biConsumer=(a,b)-> System.out.println(a.concat(b));

        biConsumer.accept("krishna ","pradeep");


        BiConsumer<String, List<String>> biConsumer1=(s, strings) -> System.out.println("name :"+s+" Activities :"+strings);

        students.forEach(student->biConsumer1.accept(student.getName(),student.getActivities()));
    }
}
