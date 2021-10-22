package java8;

import sun.jvm.hotspot.types.CIntegerType;

import java.util.*;
import java.util.function.Predicate;

public class PredicateInterfacePractise {
    static Predicate<Integer> p=(i)->i%2==0;

    static Predicate<Integer>p1=i -> i%5==0;
    public static void main(String[] args) {
        System.out.println(p.test(7));
        System.out.println( p.and(p1).test(7));
        System.out.println( p.or(p1).test(10));
        // negate function
        System.out.println(p.or(p1).negate().test(10));
        List<Integer> integers = Arrays.asList();
        Integer reduce = integers.stream().filter(p).reduce(0, (a, b) -> a * b);
        System.out.println(reduce);

        System.out.println((int)Math.pow(2,3));


    }
}
