package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitAndSkipFunctionExample {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 4, 5, 7, 8, 9);
        integers.stream()
                .limit(4) // it will print only first 4 numbers
                .forEach(System.out::println);

        // skip example
        Optional<Integer> reduce = integers.stream()
                .skip(3) // will skip first 3 elements
                .reduce(Integer::sum);
        reduce.ifPresent(System.out::println);
    }
}
