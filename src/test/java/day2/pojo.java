package day2;

import java.util.Arrays;
import java.util.List;

class Address{
    String city;
    String street;
}


public class pojo {

     private final int id=10;
     private  String name;
    Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public pojo(int id, String name){

        this.id = id;
        this.name = name;
    }


    public static void main(String[] args) {
        pojo p=new pojo(1,"vcsn");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        while (integers.iterator().hasNext()){
            System.out.println(integers.iterator().next());
        }

    }
}
class Test1 extends pojo{
    static {
         int a=10;
         display();
    }

   /* Test1() {
       // super(id, name);
    }*/

    public static void display(){

    }


    public static void main(String[] args) {
        display();
        Test1.display();
    }

}



