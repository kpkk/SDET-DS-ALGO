package java8;

import java.util.Arrays;
import java.util.List;

public class StudentDB {

    public static List<Student> getStudents(){
        Student s1=new Student("abc","male",7.5,3, Arrays.asList("swimming","eating","gaming"));
        Student s2=new Student("def","female",9.5,3, Arrays.asList("dancing","eating","gaming"));

        Student s3=new Student("ghi","female",7.5,3, Arrays.asList("swimming","sleeping","gaming"));
        Student s4=new Student("jkl","male",9.5,3, Arrays.asList("swimming","eating","gaming"));

        Student s5=new Student("mno","female",8.5,6, Arrays.asList("swimming","eating","watching"));
        Student s6=new Student("pqr","male",7.5,6, Arrays.asList("swimming","eating","reading"));

       return Arrays.asList(s1,s2,s3,s4,s5,s6);
    }

    public static void main(String[] args) {

    }
}
