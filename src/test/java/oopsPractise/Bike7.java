package oopsPractise;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.security.spec.ECFieldF2m;
import java.util.Calendar;

class Bike7{
    int speed;

    Bike7(){
        System.out.println("speed is "+speed);
    }

    {
        speed=100;
        System.out.println("this is instance block");
    }

    public static void main(String args[]){
        Bike7 b1=new Bike7();
        Bike7 b2=new Bike7();
    }
}
class B1 extends Bike7{
    int x;
    B1(){
        super();
        System.out.println("this is b2 class "+x);
    }
    {
        x=100;
        System.out.println("this is child instance block");
    }

    public static void main(String[] args) {
        B1 b=new B1();

    }
}
class Bike11{

    int cube(final int n){
        //n=n+2;
       return n*n*n;
    }
    public static void main(String args[]){
        Bike11 b=new Bike11();
        b.cube(5);
    }
}
class Parent{
    int i=10;
    void msg()  {
        System.out.println("parent");
    }
}

class TestExceptionChild extends Parent {
    int i=20;
    @Override
    void msg() {
        System.out.println("TestExceptionChild");
    }

    public static void main(String args[]) {
        Parent p = new TestExceptionChild();
        p.msg();
        int c=p.i;
        System.out.println(c);
    }
}


class Parent1{
    void msg(){System.out.println("parent");}
}

class TestExceptionChild1 extends Parent1{
    void msg()throws ArithmeticException{
        System.out.println("child");
    }
    public static void main(String args[]){
        Parent1 p=new TestExceptionChild1();
        p.msg();
        double d= 10.0/-0;
        if(d==Double.POSITIVE_INFINITY) System.out.println("+ve");
        else System.out.println("-ve");
    }
}
class Tiptop {
    static final Integer i1=1;
    final Integer i2=2;
    Integer i3=3;

    public static void main(String[] args) {
        final Integer i4=4;
        Integer i5=5;
        class Inner{
             final Integer i6=6;
             Integer i7=7;
            Inner(){
                System.out.println(i6+i7);
            }
        }

    }

}
class Exc0 extends Exception{

}
class Exc1 extends Exc0{

}
class Test {
    public static void main(String[] args) {
        try {
            throw new Exc1();
        }catch (Exc0 e0){
            System.out.println("exco caught");
        }catch (Exception e){
            System.out.println("exception occurred");
        }
        new Test().foo(false,true);

    }
    public void foo(boolean a ,boolean b){
        if(a){
            System.out.println("a");
        }
        else if(a && b){
            System.out.println("a && b");
        }else{
            if (!b){
                System.out.println("notB");
            }else{
                System.out.println("else");
            }
        }

    }
}
class D{
        int add(int i, int j){
            return i*j;
        }
}
class E extends D{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c=Class.forName("E");
        E o =(E)c.newInstance();
        short s=9;
       // System.out.println(add(9,6));
    }
}

class Employee{
    float bonus=40000;
    final void method(){
        System.out.println("this is final");

    }
    void salary(){
        System.out.println("employee salary");
    }
}
class Programmer extends Employee{
    int bonus=10000;
    @Override
    void salary(){
        System.out.println("programmer salary");
    }


    public static void main(String args[]){
        Programmer p=new Programmer();
        System.out.println("Programmer salary is:"+p.bonus);
       p.salary();
    }
}
class Adder{
    static int add(int a,int b){return a+b;}
  //  static int add(int a,int b){return a+b;}
}
class TestOverloading3{
    public static void main(String[] args){
        System.out.println(Adder.add(11,11));//ambiguity
    }}

class Demo {
    public void show(int x)
    {
        System.out.println("In int" + x);
    }
    public void show(String s)
    {
        System.out.println("In String" + s);
    }
    public void show(byte b)
    {
        System.out.println("In byte" + b);
    }
}
class UseDemo {
    public static void main(String[] args)
    {
        byte a = 25;
        Demo obj = new Demo();
        obj.show(a); // it will go to
        // byte argument
        obj.show("hello"); // String
        obj.show(250); // Int
        obj.show('A'); // Since char is
        // not available, so the datatype
        // higher than char in terms of
        // range is int.
        obj.show("A"); // String
       // obj.show(7.5); // since float datatype
// is not available and so it's higher
// datatype, so at this step their
// will be an error.
    }
}

/* Java program to show that if static method is redefined by
a derived class, then it is not overriding. */

// Superclass
class Base {

    // Static method in base class which will be hidden in subclass
    public static void display() {
        System.out.println("Static or class method from Base");
    }

    // Non-static method which will be overridden in derived class
    public void print() {
        System.out.println("Non-static or Instance method from Base");
    }
}

// Subclass
class Derived extends Base {

    // This method is hidden by display() in Base
    public static void display() {
        System.out.println("Static or class method from Derived");
    }
    {
        super.print();
    }


    // This method overrides print() in Base
    @Override
    public void print() {
      //  super.print();
        System.out.println("Non-static or Instance method from Derived");
    }
}

// Driver class
 class Test4 {
    public static void main(String args[ ]) {
        Base obj1 = new Derived();

        // As per overriding rules this should call to class Derive's static
        // overridden method. Since static method can not be overridden, it
        // calls Base's display()
        obj1.display();

        // Here overriding works and Derive's print() is called
        obj1.print();
    }
}
class A{
      void msg(){System.out.println("Hello java");}
}

class Simple extends A{
     void msg(){System.out.println("Hello java");}//C.T.Error
    public static void main(String args[]){
        Simple obj=new Simple();
        obj.msg();
    }
}
class Person
{
    Person()
    {
        System.out.println("Person class Constructor");
    }
}

/* subclass Student extending the Person class */
class Student extends Person
{
    Student()
    {
        // invoke or call parent class constructor
      //  super();

        System.out.println("Student class Constructor");
    }
}

/* Driver program to test*/
class Test6
{
    public static void main(String[] args)
    {
        Student s = new Student();
    }
}