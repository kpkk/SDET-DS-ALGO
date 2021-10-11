package oopsPractise;

 class ExecutionSequence {

    {
        System.out.println("I'm on instance block");
    }
    static {
        System.out.println("I'm on static block");
    }
    public ExecutionSequence(){

    }
    public ExecutionSequence(int value){
        System.out.println("i'm overloaded constructor");
    }

    public void print(){
        System.out.println(this.getClass().getClassLoader().getClass().getName());
    }
    public void args(String[] args){

    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ExecutionSequence ob1=new ExecutionSequence();
        ExecutionSequence ob2=new ExecutionSequence(10);
      //  System.out.println(ob2);
    //    System.out.println(ob1);
        ob1.print();
        ob1.args(new String[]{"2","2","3"});
        Class<?> aClass = Class.forName("ExecutionSequence.class");
        ExecutionSequence o = (ExecutionSequence) aClass.newInstance();
        o.print();




    }
}
