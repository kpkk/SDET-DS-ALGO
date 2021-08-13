package queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;

public class InterLeavingArray {
    /*
    Given an array with all odd and even numbers together, arrange them in an order such that elements are arranged in alternate order
    Eg: input=[1,3,5,7,2,4,6,8]
    output=[1,2,3,4,5,6,7,8]
     */
    @Test
    public void test1(){
        int[] data={1,3,5,7,2,4,6,8};
        Assert.assertArrayEquals(interLeavingArray(data),new int[]{1,2,3,4,5,6,7,8});
    }
    @Test
    public void test2(){
        int[] data={1,1,1};
        Assert.assertArrayEquals(interLeavingArray(data),new int[]{1,1,1});
    }
    @Test
    public void test3(){
        int[] data={};
        Assert.assertArrayEquals(interLeavingArray(data),new int[]{});
    }

    /*
    Solution:-
    - Initialize a queue of Integer type
    - initialize two pointers, left=0, right=n/2
    - while right reaches length, add the elements present at left and right index into queue
    - convert the queue into array then return
     */
    private int[] interLeavingArray(int[] data) {
        if (data.length==0) return new int[]{};
        ArrayDeque<Integer>queue=new ArrayDeque<>();
        int left=0,right=data.length/2;
        while (right<data.length){
            queue.offer(data[left++]);
            queue.offer(data[right++]);
        }
        for(int i=0;i<data.length;i++){
            data[i]=queue.poll();
        }
    return data;
    }
}


