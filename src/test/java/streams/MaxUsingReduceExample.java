package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxUsingReduceExample {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer>al=new ArrayList<>();
        Optional<Integer> reduce = integers.stream()
                .reduce(Integer::max);

        System.out.println(reduce);
        reduce.ifPresent(System.out::println);

        // min calculation- the default value should be set to Integer.MAX or the optional while doing min operation
        Integer reduce1 = integers.stream()
                .reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(reduce1);

    }
}
