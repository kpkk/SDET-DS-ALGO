package customImplementation;

import org.junit.Test;

public class Stack {
    int count;
    int [] stack;
    int capacity;
    public Stack(int capacity){
        stack=new int[capacity];
        this.capacity=capacity;
        count=0;
    }

    public void push(int value){
        if(count==capacity){
            int [] newStack=new int[2 * capacity];
            System.arraycopy(stack,0,newStack,0,capacity);
            capacity=2*capacity;
            stack=newStack;
        }
        stack[count++]=value;
    }

    public int pop(){
       int value= stack[count-1];
       stack[count-1]=0;
        return value;
    }

    public int peek(){
        return stack[count];
    }
    public void printStack(){
        for (int i=count-1;i>=0;i--){
            System.out.println(stack[i]);
        }
    }
    public int size(){
        return count-1;
    }
    public boolean isEmpty(){
        return count<=0;
    }

}
class Test1{
    public static void main(String[] args) {
        Stack s=new Stack(10);
        s.push(5);
        s.push(7);
        s.push(6);
     //   s.printStack();
        System.out.println( s.pop());
        System.out.println(s.size());
        System.out.println(s.isEmpty());
      //  s.printStack();
    }
}
