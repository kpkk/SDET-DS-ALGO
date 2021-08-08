package week5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class InterLeavingArray {



    @Test
	public void test4() {
		int[] data = {1,3,5,7,2,4,6,8};
		int [] output= {1,2,3,4,5,6,7,8};
        Assert.assertArrayEquals(interLeaveElement(data),output);
	}
	@Test
	public void test5() {
		int[] data = {1,2,3,4,11,12,13,14};
		int [] output={1,11,2,12,3,13,4,14};
        Assert.assertArrayEquals(interLeaveElement(data),output);
	}

	/*
	A

	 */

    private int[] interLeaveElement(int[] data) {

        int index=0;
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        int left=0, right=(data.length)/2;
        while (right<data.length){
            queue.offer(data[left++]);
            queue.offer(data[right++]);
        }
        while (!queue.isEmpty()){
            data[index++]=queue.poll();
        }
        return data;
    }


}
