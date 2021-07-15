package day2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

class Address{
    String city;
    String street;
}

public class pojo {

    int id;
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

    public pojo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        while (integers.iterator().hasNext()){
            System.out.println(integers.iterator().next());
        }

    }
}



