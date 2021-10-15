package java8;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperator=s -> s.concat("world");

    public static void main(String[] args) {
        System.out.println(unaryOperator.apply("hello"));
        unaryOperator.apply("second");
    }
}
