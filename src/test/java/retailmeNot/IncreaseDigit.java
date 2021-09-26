package retailmeNot;

import com.google.common.collect.Multimap;
import org.junit.Assert;
import org.junit.Test;
import practise.StrStr;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class IncreaseDigit {

    /*
    N=512, k=10, increase the value of digit by k times
     */
    @Test
    public void test1(){
        int n=512, k=10;
       // System.out.println( getRandomNumberUsingInts(1,1000));
        Assert.assertEquals(increaseNumber(n,k),972);
    }
    @Test
    public void test2(){
        int n=191, k=4;
        Assert.assertEquals(increaseNumber(n,k),591);
    }
    @Test
    public void test3(){
        int n=282, k=20;
        Assert.assertEquals(increaseNumber(n,k),999);
    }

    /*
    - convert the array array into a string
    - get the each character, and increment it until either k is not zero or the digit is not 9
    - repeat this for other numbers
    - return the inter version of string
     */
    private int increaseNumber(int n, int k) {
        String num=String.valueOf(n);
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<num.length();i++){
            int digit = Integer.parseInt(num.charAt(i) + "");
            if(digit!=9){
                while(k!=0 && digit!=9){
                    digit++;
                    k--;
                }
                sb.append(digit);
            }else{
                sb.append(digit);
            }
        }
        return Integer.parseInt(sb.toString());
    }



    public int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}
class Test1 {
     static {
        System.exit(0);
    }
    public static void main(String[] args) {
        IncreaseDigit in = new IncreaseDigit();
        Class<? extends IncreaseDigit> aClass = in.getClass();
        //   Constructor<? extends IncreaseDigit> constructor = aClass.getConstructor();
//        Method[] methods = aClass.getMethods();
//        System.out.println(Arrays.toString(methods));
//       ArrayList<Integer>al=new ArrayList(Arrays.asList(1,2,3,4,5));
//        List<Integer> collect1 = al.stream().mapToInt((x )-> x).summaryStatistics();
//        System.out.println(collect1);
//        List<Integer> collect = al.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
//        al.stream().limit(al.size()).forEach(System.out::println);
//        System.out.println(collect);
        // methods[1].invoke()

        List numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((z) -> (int) z).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }

}
