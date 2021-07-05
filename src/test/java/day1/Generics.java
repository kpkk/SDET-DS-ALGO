package day1;

import java.util.ArrayList;
import java.util.List;

class Myclass<T     > {

    T id;

    public Myclass(T id) {
        this.id = id;


    }
}

/*


 * Java primitive types are not reference types (e.g. an int is not an Object)
 * Java does generics using type-erasure of reference types (e.g. a List<?> is really a List<Object> at run-time

 */


public class Generics {

    public static void main(String[] args) {

    }
}

