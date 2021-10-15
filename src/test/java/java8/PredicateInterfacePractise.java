package java8;

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


    }
}
