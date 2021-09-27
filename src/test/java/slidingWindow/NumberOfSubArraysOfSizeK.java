package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfSubArraysOfSizeK {

    @Test
    public void test1(){
        int[] arr={2,2,2,2,5,5,5,8};
        int k=3, threshild=4;
        Assert.assertEquals(numOfSubarrays(arr,k,threshild),3);
    }
    @Test
    public void test2(){
        int[] arr={1,1,1,1,1};
        int k=1, threshild=0;
        Assert.assertEquals(numOfSubarrays(arr,k,threshild),5);
    }
    /*
       input - integer array, integer k and threshold
       output - integer
       Solution:-
       - intialize two pointers left=0, right=0 and a variable called sum and sum
       - keep adding the numbers at the index right
       - check if the distance between the right -left+1 is equals k
       - if the distance is equals to k, then calculate the avg
           - if the avg is greater than or equals to threshold then add it to count
           - subtract the value at left index and right from sum
       - return count
       */
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int count=0,sum=0,left=0, right=0;

        while(right<arr.length){
            sum+=arr[right];
            if(right-left+1==k){
                if(sum/k>=threshold)count++;
                sum-=arr[left++];
            }
            right++;
        }
        return count;
    }
}
