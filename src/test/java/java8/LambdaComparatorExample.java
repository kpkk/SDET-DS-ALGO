package java8;

import java.util.Comparator;

public class LambdaComparatorExample {

    public static void main(String[] args) {
        Comparator<Integer> cmp=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println( cmp.compare(1,2));

        Comparator<Integer> cmp2= (Integer i1,Integer i2)-> {return i1.compareTo(i2);};
        System.out.println(cmp2.compare(3,4));
    }
}
