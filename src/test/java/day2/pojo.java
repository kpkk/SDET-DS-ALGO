package day2;

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
}



