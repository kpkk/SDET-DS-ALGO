package oopsPractise;

class ObjTest {

        void print (){
        System.out.println("hello");
        }
        }
        class B extends ObjTest {

        void print (){
        System.out.println("world");
       }
        }

        class Mains {
            public static void main(String[] args) {
                ObjTest obj1 = new ObjTest();
                ObjTest obj2 = new B();
               //  B obj3= (B)new ObjTest();

                obj1.print();
                obj2.print();
              //    obj3.print();

            }
        }

