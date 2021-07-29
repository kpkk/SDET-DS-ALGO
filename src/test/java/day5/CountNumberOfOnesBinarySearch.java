package day5;

import org.junit.Assert;
import org.junit.Test;

public class CountNumberOfOnesBinarySearch {

    /*
    Given a sorted array of integers 0's and 1's find the number of 1 s
    int[] nums={0,0,0,1,1,1,1}
    output-4;
     */

    @Test
    public void test1() {
        int[] nums = {0, 0, 0, 1, 1, 1,1};
        Assert.assertEquals(countNumberOnesUsingBinarySearch(nums), 3);
    }


    @Test
    public void test2() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1};
        Assert.assertEquals(countNumberOnesUsingBinarySearch(nums), 7);
    }

    @Test
    public void test3() {
        int[] nums = {0, 0, 0, 0, 0};
        Assert.assertEquals(countNumberOnesUsingBinarySearch(nums), -1);
    }
    @Test
    public void test4() {
        int[] nums = {0, 0, 0, 1};
        Assert.assertEquals(countNumberOnesUsingBinarySearch(nums), 1);
    }

    /*
    Approach- Binary search
    Time complexity- O(logn)
    Space complexity- O(1)

    Solution:-
    - Initialize variables low=0, high=nums.length-1
    - If the first element is 1 return array length as output
    - If the last element is 0 then return -1
    - While low less than or equal to high
        - calculate the mid
        - if mid is 1 return the difference between high and mid then plus 1
        - if mid is less than 1 set high as mid-1
        - else low= mid+1
    -return -1

     */

    private int countNumberOnesUsingBinarySearch(int[] nums) {
        int low = 0, high = nums.length - 1;
        if (nums[low] == 1) return nums.length;
        if (nums[nums.length - 1] == 0) return -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == 1) return high - mid+1;
            else if (nums[mid] < 1) low = mid + 1;
            else high = mid - 1;

        }
        return -1;
    }
}
