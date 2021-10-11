package java8;

public interface Samsung extends Android {

    void call();
    void messsage();
    static void samSungImplentation(){
        System.out.println("samsung implementation ");

    }
    @Override
    default void camera(){
        System.out.println("this is samsung mobile camera  implementation");
    }

}
