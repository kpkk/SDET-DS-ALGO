package practiseWM;

import java.util.ArrayDeque;

public class PriorityQueue {
    int[] arr;
    int counter;
    PriorityQueue(int length){
        arr=new int[length];
    }
    public void insert(int value){
        int i;
        if(counter==arr.length){
            int []newArray=new int[2* arr.length];
            for (int j=0;j<arr.length;j++){
                newArray[j]=arr[j];
            }
            arr=newArray;
        }
        for (i=counter-1;i>=0;i--){
         if(value>arr[i])
             arr[i+1]=arr[i];
         else break;
        }
        arr[i+1]=value;
        counter++;
    }
    public void printPq(){
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public int remove(){
        return arr[--counter];
    }
    public boolean isFull(){
        return counter==arr.length;
    }
    public boolean isEmptpy(){
        return counter==0;
    }
    public int getPeek(){
        return arr[counter-1];
    }

}
class pqApp{
    public static void main(String[] args) {
        PriorityQueue pq=new PriorityQueue(2);
        pq.insert(2);
        pq.insert(1);
        pq.insert(5);
        pq.insert(10);
        pq.printPq();
        System.out.println(pq.getPeek());
        System.out.println(pq.isEmptpy());
        System.out.println(pq.isFull());


    }
}
