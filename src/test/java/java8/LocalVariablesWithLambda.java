package java8;

import java.util.function.Consumer;
import java.util.function.Function;

public class LocalVariablesWithLambda {
    static int i = 0;
    static int value=4;
    public static void main(String[] args) {
      //  int value=4;
        Consumer<Integer> consumer= (i -> {
            value=8;
            System.out.println(i+value);
        });
        consumer.accept(2);
    }
}
