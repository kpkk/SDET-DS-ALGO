
package oopsPractise;

public class ClassDemo {

    public void show(int x) {
        System.out.println("In int" + x);
    }

    public void show(String s) {
        System.out.println("In String" + s);
    }

    public void show(byte b) {
        System.out.println("In byte" + b);
    }
}

    class UseDemos {
        public static void main(String[] args)
        {
            byte a = 25;
            ClassDemo obj = new ClassDemo();
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




class Parents {
    // Can't be overridden
    final void show() {}
}

class Child extends Parents {
    // This would produce error
 //   void show() {}
}
class te{
    public static void main(String[] args) {

    }
}

// A Java program to demonstrate that overridden
// method can be called from sub-class

// Base Class
class Parents1 {
    void show()
    {
        System.out.println("Parent's show()");
    }
}

// Inherited class
class Childs extends Parents1 {
    // This method overrides show() of Parent
    @Override
    void show()
    {

        System.out.println("Child's show()");
        super.show();
    }
}

// Driver class
class Main {
    public static void main(String[] args)
    {
        Parents1 obj = new Childs();
        obj.show();
    }
}

