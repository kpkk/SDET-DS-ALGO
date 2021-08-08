package day2;


public interface Inf {

       int a=10;
      int b=10;
       void show();

       public default void demo(){
           System.out.println("can be implemented");
       }
       static void staticmethod(){
           System.out.println("This is static method");
       }

       // interface-> annotation--> abstract--> concrete


}

  class A implements Inf{

    public static void main(String[] args) {
        Inf.staticmethod();
    }


      @Override
      public void show() {

      }

      @Override
      public void demo() {

      }
  }
