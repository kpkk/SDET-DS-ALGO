package oopsPractise;

import java.util.concurrent.atomic.AtomicLongArray;

public class ConstructorExample implements Cloneable {

     static int a=10;
     int b=10;

     ConstructorExample(){
         a++;
         b++;
         System.out.println(a);
         System.out.println(b);
     }

    public static void main(String[] args) throws CloneNotSupportedException {
        ConstructorExample c1=new ConstructorExample();
        ConstructorExample c2=new ConstructorExample();
        ConstructorExample c3=new ConstructorExample();

        Object clone = c1.clone();
        System.out.println(clone);

        System.out.println();
        System.out.println(c2);
        System.out.println(c3);

    }
}
