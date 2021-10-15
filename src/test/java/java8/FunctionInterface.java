package java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionInterface {

    static Function<String, String> function=(s -> s.toLowerCase());
    static Function<String, String> function1=s->s.toUpperCase().concat("hello");
    static Predicate<Student>p1=student -> student.getGpa()>9;

    static Function<List<Student>,Map<String,Double>> fun=(students) -> {
        HashMap<String, Double> map = new HashMap<>();
        students.forEach(student -> {
            if (p1.test(student)) {
                map.put(student.getName(), student.getGpa());
            }
        });
        return map;
    };

    public static void main(String[] args) {
        String pradeep = function.apply("pradeep");
        System.out.println(pradeep);
        System.out.println(function.andThen(function1).apply("pradeep"));
        System.out.println(function.compose(function1).apply("pradeep"));

        List<Student> students = StudentDB.getStudents();
        System.out.println(fun.apply(students));
    }
}
