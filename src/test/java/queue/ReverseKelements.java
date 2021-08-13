package queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseKelements {

    /*
    Given an array of integers and an integer value reverse only elements until k and return

    eg: input- [1,2,3,4,5,6,7,8] k=4
    output- [4,3,2,1,5,6,7,8]

     */

    @Test
    public void test1(){
        int[] data={1,2,3,4,5,6,7,8};
        int k=4;
        Assert.assertArrayEquals(reverseElements(data,k),new int[]{4,3,2,1,5,6,7,8});
    }
    @Test
    public void test2(){
        int[] data={1,2};
        int k=2;
        Assert.assertArrayEquals(reverseElements(data, k),new int[]{2,1});
    }

    /*
    - Initialize a stack and queue of integer type
    - Iterate the array from start index until k, add them to the stack
    - iterate from start until array length, first fill the stack elements then queue elements
    - return the array
     */

    private int[] reverseElements(int[] data,int k) {
        Stack<Integer>stack=new Stack<>();
        ArrayDeque<Integer>queue=new ArrayDeque<>();
        for (int i=0;i<k;i++){
            stack.push(data[i]);
        }
        for (int i=0;i<k;i++){
            data[i]=stack.pop();
        }
        return data;
    }
}
