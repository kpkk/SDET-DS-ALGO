package paloAltoNetworks;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SumDigits {

    @Test
    public void test1() {
        int[] nums = {51, 17, 71, 42};
        Assert.assertEquals(sumDigits(nums), 93);
    }

    @Test
    public void test2() {
        int[] nums = {42, 33, 60};
        Assert.assertEquals(sumDigits(nums), 102);
    }

    @Test
    public void test3() {
        int[] nums = {51, 32, 43};
        Assert.assertEquals(sumDigits(nums), -1);
    }

    /*
    two pointers opp direction
    get the each number and sum the digits
    if they are equal sum them, move the poointers
     */


    private int sumDigits(int[] nums) {

        int left = 0, right = nums.length - 1, maxSum = Integer.MIN_VALUE;
        while (left <= right) {
            int leftNumber = nums[left];
            int leftsum = digitSums(nums[left]);

            int rightNumber = nums[right];
            int rightSum = digitSums(nums[right]);

            if (rightSum != leftsum) return -1;
            else {
                maxSum = Math.max(leftNumber + rightNumber, maxSum);
            }

            left++;
            right--;
        }
        return maxSum;
    }

    public int digitSums(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        for (int num : A) {
            int sum = digitSum(num);
            if (map.containsKey(sum)) {
                maxSum = Math.max(maxSum, map.get(sum) + num);
                if (map.get(sum) < num) {
                    map.put(sum, num);
                }
            } else {
                map.put(sum, num);
            }
        }
        return maxSum;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public int findMax(int[] num) {
        int[] values = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            values[i] = addNums(num[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] == values[j]) {
                    max = Math.max(max, num[i] + num[j]);
                }
            }
        }
        return max;

    }

    public int addNums(int n) {
        int retVal = 0;
        while (n != 0) {
            retVal += n % 10;
            n /= 10;
        }
        return retVal;

    }
    /*
     * Pseudo code
     * Create a hash map
     * Traverse through the array
     * 		Find sum of the digits of each element
     * 		Add the sum as key and add/update the values[store it as a list]
     * Initialize max as -1
     * Traverse through the map
     * 		For each entry, if the list size is greater than 1
     * 			Sort the list
     * 			Find max between max & sum of last 2 elements
     *  Return max
     */

/*    private int findEqualSum(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0, n = arr[i];
            List<Integer> list = new ArrayList<Integer>();
            while (n > 0) {
                sum += n % 10;
                n = n / 10;
            }
            if (map.containsKey(sum)) {
                list.addAll(map.get(sum));
                list.add(arr[i]);
                map.put(sum, list);
            } else {
                list.add(arr[i]);
                map.put(sum, list);
            }
        }
        int max = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = new ArrayList<Integer>();
                list.addAll(entry.getValue());
                if (list.size() > 1) {
                    Collections.sort(list);
                    max = Math.max(max, list.get(list.size() - 1) + list.get(list.size() - 2));
                }
            }
            return max;
        }


    }*/
}

