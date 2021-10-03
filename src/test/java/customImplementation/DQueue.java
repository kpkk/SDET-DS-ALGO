package customImplementation;

public class DQueue {
    int rear;
    int front;
    int capacity;
    int queue[];
    int count;
    public DQueue(int capacity){
        this.capacity=capacity;
        queue=new int[capacity];
        count=0;
    }
    public void enqueue(int value){
        queue[rear]=value;
        rear=(rear+1%capacity);
        count++;

    }
    public int dequeue(){
        int value=queue[front];
        front=(front+1%capacity);
        count--;
        return value;
    }
    public int peek(){
        return queue[rear-1];
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public void printQueue(){
        for (int i=0;i<rear;i++){
            System.out.print(queue[(front+i)%capacity]+" ");
        }
    }
}
class Test{
    public static void main(String[] args) {
        DQueue q=new DQueue(5);
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(2);
        q.printQueue();
        q.dequeue();
        q.printQueue();
    }
}
