package practiseWM;

public class DynamicArray {

    private int arr[];
    int counter;
    public DynamicArray(int length){
        arr=new int[length];
    }
    public void printArray(){
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public void insert(int value){
        if(counter==arr.length){
            int [] newArray=new int[2* arr.length];

            for (int i=0;i<arr.length;i++){
               newArray[i]= arr[i];
            }
            arr=newArray;
        }
        arr[counter++]=value;
    }
}
class TestArray{
    public static void main(String[] args) {
        DynamicArray array=new DynamicArray(5);
        array.insert(2);
        array.insert(3);
        array.insert(5);
        array.insert(7);
        array.insert(10);
        array.printArray();
    }
}
