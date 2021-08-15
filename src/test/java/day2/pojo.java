package day2;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

class Address{
    String city;
    String street;
}


public class pojo {

       int id=10;
       String name;
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

    public pojo(){

    }
    public pojo(int id, String name){
        this();
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
class Test1{
    static {
         int a=10;
         display();
    }
    public void m(){
        System.out.println("");
    }

   /* Test1() {
       // super(id, name);
    }*/

    public static void display(){

    }


    public static void main(String[] args) {
        try {
            display();
            Test1.display();
        }
        catch (Exception e){

        }

    }

}

class ExceptionExample{
    public void display() throws FileNotFoundException {
        System.out.println("");
    }
    public void show(){
    }
}



