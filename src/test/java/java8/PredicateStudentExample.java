package java8;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {
    static List<Student> students = StudentDB.getStudents();
    static Predicate<Student> p1=(s)->s.getGradeLevel()==3;
    static Predicate<Student>p2=(s)->s.getGpa()==7.5;

    public static void printStudentsbasedOnGradeNegateScenario(){
        students.forEach((student) ->{ if(p1.negate().test(student)) System.out.println(student);});
    }
    public static void printStudentsbasedOnGrade(){

        students.forEach((student) ->{ if(p1.negate().test(student)) System.out.println(student);});
    }
    public static void combineTwoConditions(){
        students.forEach((student)->{if(p1.and(p2).test(student)) System.out.println(student);});
    }

    public static void main(String[] args) {
        printStudentsbasedOnGrade();
        printStudentsbasedOnGradeNegateScenario();
        combineTwoConditions();
    }
}
