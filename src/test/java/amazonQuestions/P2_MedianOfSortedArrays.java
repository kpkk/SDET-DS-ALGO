package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P2_MedianOfSortedArrays {
    /*

    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
     */

    /*
    Input- two integer array
    output-  float/double value
    constraints- O(log(m+n))
    approach: binary search
    clarifications:-
    what if both the arrays are empty
    can the array contain negative values
    can the array contain duplicate values

     */
    @Test
    public void test1(){
        int[] n1={1,2};
        int[] n2={3,4};
        Assert.assertEquals(findMedian(n1,n2),2.5,0.0);
    }
    @Test
    public void test2(){
        int[] n1={1,3};
        int[] n2={2};
        Assert.assertEquals(findMedian(n1,n2),2.0,0.0);
    }
    @Test
    public void test3(){
        int[] n1={1};
        int[] n2={2};
        Assert.assertEquals(findMedian(n1,n2),1.5,0.0);
    }
    @Test
    public void test4(){
        int[] n1={};
        int[] n2={2};
        Assert.assertEquals(findMedian(n1,n2),2.0,0.0);
    }
    @Test
    public void test5(){
        int[] n1={1};
        int[] n2={};
        Assert.assertEquals(findMedian(n1,n2),1.0,0.0);
    }
    @Test(expected = RuntimeException.class)
    public void test6(){
        int[] n1={};
        int[] n2={};
        Assert.assertEquals(findMedian(n1,n2),0,0.0);
    }
    @Test
    public void test7(){
        int[] n1={0,0};
        int[] n2={0,0};
        Assert.assertEquals(findMedian(n1,n2),0,0.0);
    }

    /*
    Solution:-
    - Initialize an array of length n1+n2 length
    - initialize two pointer, both stay at the end index of two arrays
    - compare the values at both index
        - which ever is greater fill at the end index and move that pointer
     - once the arrays are merged then
        - return mid, if its a odd length array
        - return mid+(mid+1)/2 for even length array
     */
    private double findMedian(int[] n1, int[] n2) {
        if(n1.length==0 && n2.length==0) throw new RuntimeException("empty arrays given");
        if(n1.length==0 && n2.length==1) return n2[0];
        if(n2.length==0 && n1.length==1) return n1[0];

        int [] mergedArray=new int[n1.length+n2.length];
        int p1= n1.length-1, p2=n2.length-1, index=mergedArray.length-1;
        while (p1>=0&& p2>=0){
            if(n1[p1]>n2[p2]) mergedArray[index--]=n1[p1--];
            else if(n1[p1]==n2[p2]) mergedArray[index--]=n2[p2--];
            else if(n1[p1]<n2[p2])mergedArray[index--]=n2[p2--];
        }
        while (p1>=0){
            mergedArray[index--]=n1[p1--];
        }
        while (p2>=0){
            mergedArray[index--]=n2[p2--];
        }
        int midPoint=(0+mergedArray.length-1)/2;
        if(mergedArray.length%2==0) return (double)(mergedArray[midPoint]+(mergedArray[midPoint+1]))/2;
        else return (double) mergedArray[midPoint];

    }
}
