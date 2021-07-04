package day1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ReverseAnInteger {

    /*
    reverse an integer
    did i understand the problem- yes
    test data, 123, -456, 1, 120000,

     Did i understand the problem? yes
          - If no ask to provide examples
          - if yes, proceed with the next steps
    2. what is the input? integer (which includes +ve, -ve)
    3. what should be the expected output? reversed integer
    4. Do i have any constraints - No constraints
    4. How big is your test data?
    5. test data set
    +ve, -ve and edge
    6. do i've all the information to solve the problem - convert into string and reverse it from end, recursion technique



    Pseudo code:-
    1. assign the input number to a temp variable, to check for the negative value
    2. If the number is less than 0 then multiply by -1
    2. Declare an integer variable to reverse the add the reversed element
    3. as long as n>0 loop through and get the last digit, using mod operator
    4. add the last digit to the reverse variable
    5. if the given number is negative then multiply with -1 then return else return the reverse
     */

    @Test
    public void test(){
        int num=123;
        int i = reverseNumber(num);
        System.out.println(i);
        int i1 = approach2(num);
        System.out.println(i1);

    }

    @Test
    public void test1(){
        int num=-456123;
        int i = reverseNumber(num);
        int i1 = approach2(num);
        System.out.println(i1);
        System.out.println(i);

    }
    @Test
    public void test2(){
        int num=1200000;
        int i = reverseNumber(num);
        System.out.println(i);
        int i1 = approach2(num);
        System.out.println(i1);

    }

    public int reverseNumber(int n){
        int temp=n;
        if (temp<0)
            n*=-1;
        int rev=0;
        while (n>0){
            int lastdigit=n%10;
            n=n/10;
            rev=rev*10+lastdigit;
        }
        if (temp<0)
            return rev*-1;
        return rev;
    }

    public int approach2(int n){
        int temp=n;
        if (temp<0)
            n*=-1;
        ArrayList<Integer>ll=new ArrayList<>();
        while (n>0){
            int lastDigit=n%10;
            ll.add(lastDigit);
            n/=10;
        }
        Iterator<Integer> integerListIterator = ll.iterator();
        int rev=0;
       while (integerListIterator.hasNext()){
           Integer next = integerListIterator.next();
           rev=rev*10+next;
       }
       if(temp<0)
           return rev*-1;
       return rev;

    }


}
