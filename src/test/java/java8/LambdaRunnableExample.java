package java8;

public class LambdaRunnableExample {

    /*
    Prior to java-8
     */
    public static void main(String[] args) {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable method");
            }
        };
        Thread t=new Thread(r);
        t.start();
        System.out.println(t.getName());
        System.out.println(t.getPriority());

        Runnable lamda=()->{
            System.out.println("this is lambda function, implementing runnable interface");
        };
        Thread t1=new Thread(lamda);
        t1.start();
        System.out.println(t1.getName());
        System.out.println(t1.getPriority());
    }


}
