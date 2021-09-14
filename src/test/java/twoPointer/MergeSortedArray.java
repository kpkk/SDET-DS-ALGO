package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArray {
    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109


Follow up: Can you come up with an algorithm that runs in O(m + n) time?
     */
    @Test
    public void test1(){
        int [] nums2={2,5,6};
        int [] nums1={1,2,3,0,0,0};
        int m=3, n=3;
        Assert.assertArrayEquals(mergeArrays(nums1,nums2,m,n), new int[]{1,2,2,3,5,6});
    }
    @Test
    public void test2(){
        int [] nums1={1};
        int [] nums2={};
        int m=1, n=0;
        Assert.assertArrayEquals(mergeArrays(nums1,nums2,m,n), new int[]{1});
    }
    @Test
    public void test3(){
        int [] nums1={0};
        int [] nums2={1};
        int m=0, n=1;
        Assert.assertArrayEquals(mergeArrays(nums1,nums2,m,n), new int[]{1});
    }
    @Test
    public void test4(){
        int [] nums1={1,2,3,0,0,0};
        int [] nums2={4,5,6};
        int m=3, n=3;
        Assert.assertArrayEquals(mergeArrays(nums1,nums2,m,n), new int[]{1,2,3,4,5,6});
    }

    /*
   - Initialize an int variable called index=m+n-1
   - reduce m and n by one as we need to access the 0 based index
   - compare value at the indices in both the arrays
   - which ever us bigger, fill that value at the end and move the index pointer
   - repeat the above step until all the m and n values are filled in
   - return the array nums1
     */
    // time complexity - O(n)
    //space complexity - O(1)
    private int[] mergeArrays(int[] nums1, int[] nums2,int m, int n) {
        int index=m+n-1;
        m--;n--;
        while (m>=0 && n>=0){
            if(nums1[m]>nums2[n]) nums1[index--]=nums1[m--];
            else nums1[index--]=nums2[n--];
        }
        while (m>=0){
            nums1[index--]=nums1[m--];
        }
        while (n>=0){
            nums1[index--]=nums2[n--];
        }
        return nums1;
    }
}
