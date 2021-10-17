package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollections {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "def", "ghi", "jkl", "mno");
        ArrayList<String>al=new ArrayList<>(list);
        al.remove("mno");
        System.out.println(al);

        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        // stream can be iterated only once, illegalStateException while trying to iterate second time
        stream.forEach(System.out::println);

    }
}
