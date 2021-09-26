package dunZo;

public class Queue {
    int front;
    int rear;
    int size;
    int capacity;
    int [] queue;

    public Queue(int capacity){
        this.capacity=capacity;
        queue=new int[capacity];
    }

    public void enQueue(int value){
        if(getSize()==capacity){
            System.out.println("queue is full");
        }else{
            queue[rear]=value;
            rear=((rear+1)%capacity);
            size++;
        }

    }

    public int deQueue(){
        int number=Integer.MIN_VALUE;
        if(!isEmpty()){
            number= queue[front];
            front=(front+1)%capacity;
            size--;

        }else{
            System.out.println("nothing is present to remove");
        }
        return number;
    }
    public void printQueue(){
        for (int i=0;i<size;i++){
            System.out.print(queue[(front+i)%capacity]+" ");
        }
        System.out.println("");
    }
    public boolean isFull(){
        return getSize()==capacity;
    }
    public boolean isEmpty(){
        return getSize()==0;
    }
    public int peek(){
        return queue[front];
    }
    public int getSize(){
        return size;
    }

}
class Test{
    public static void main(String[] args) {
        Queue queue=new Queue(3);

        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(7);
      //  queue.enQueue(9);
        queue.printQueue();
        queue.deQueue();
        queue.enQueue(8);
        queue.enQueue(9);
        System.out.println(queue.getSize());
        queue.printQueue();
     //   System.out.println(queue.isEmpty());
     //   System.out.println(queue.isFull());

    }
}
