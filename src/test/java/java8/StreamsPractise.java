package java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsPractise {

    @Test
    public void countEmployees(){
        HashMap<String, Integer>map=new HashMap<String, Integer>(){
            {
                put("Roger",39);
                put("Nadal",37);
                put("Tsonga",29);
                put("Djockovic",34);
                put("Murray",34);
                put("Tsitsipas",21);
                put("Zverve",24);
                put("Murray",33);

            }
        };
        Collection<Integer> values = map.values();
        System.out.println(map.values().stream().filter(age->age>30).count());


        List<String> players= Arrays.asList("Roger","Nadal","Tsonga","Djockovic","Murray","Tsitsipas","Zverve","Murray");

        // to eliminate the duplicates
        List<String> collect = players.stream().distinct().collect(Collectors.toList());
        System.out.println( players.stream().iterator().next());

        System.out.println(collect);
        int sum = IntStream.rangeClosed(0, 10).parallel().sum();
        System.out.println(sum);
        List<Integer>list=Arrays.asList(1,2,2,3,4,5,5,6,6,6,7);
        list.stream().distinct().forEach(x-> System.out.println(x));
    }
}
