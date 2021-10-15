package java8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    static Comparator<Integer>comparator=( i1,i2)->i1.compareTo(i2);
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator= (a,b)->a+b;
        System.out.println(binaryOperator.apply(4,5));
        System.out.println(BinaryOperator.maxBy(comparator).apply(4,5));
        System.out.println(BinaryOperator.minBy(comparator).apply(10,15));

    }
}
