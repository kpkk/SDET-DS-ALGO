package java8;

public class Mobile implements Samsung, OnePlus{

    public static void main(String[] args) {
        Mobile m=new Mobile();
        OnePlus.onePlusImplentation();
        Samsung.samSungImplentation();
        m.camera();

    }
    @Override
    public void call() {

    }

    @Override
    public void messsage() {

    }

    @Override
    public void camera() {
        Samsung.super.camera();
    }

    @Override
    public void game() {

    }
}
