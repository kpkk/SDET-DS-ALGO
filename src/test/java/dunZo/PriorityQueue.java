package dunZo;

import java.util.ArrayDeque;
import java.util.Queue;

public class PriorityQueue {

    int count=0;
    int [] arr;
   public PriorityQueue(int size){
       arr=new int[size];
   }
   public void addElement(int value){
       int i;
       for (i=count-1;i>=0;i--){
           if(arr[i]<value){
               arr[i+1]=arr[i];
           }else{
               break;
           }
       }
       arr[i+1]=value;
       count++;
   }
   public int getSize(){
       return count;
   }
   public void printPriorityQueue(){
       for(int i=0;i<arr.length;i++){
           System.out.println(arr[i]);
       }
   }
}
class Test2{
    public static void main(String[] args) {
        PriorityQueue pq=new PriorityQueue(10);
        pq.addElement(4);
        pq.addElement(3);
        pq.addElement(10);
        pq.printPriorityQueue();
    }
}
