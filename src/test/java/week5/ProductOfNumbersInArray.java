package week5;

import com.sun.tools.hat.internal.parser.HprofReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ProductOfNumbersInArray {
    /*
    Integer array , find the product of all the number except self
int[]a={3,4,5,6}
int[] output={120,90,72,60}
Solve without using division operator
Questions:-
1. Can have negative integers
2. Can’t be sorted always
3. Can it have duplicates
4. In what order should I return the array
{3,4,5,6}—>{120,90,72,60}
{}—>{}
{1,2}—>{2,1}
{2,-2,4,-1}—>{8,-6,4,-16}

     */
    @Test
    public void test() {
        int[] nums = {3, 4, 5, 6};
        int[] output = {120, 90, 72, 60};
        Assert.assertArrayEquals(productExceptSelf(nums), output);
    }

    private int[] findProductBruteForce(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                else prod *= nums[j];
            }
            output[i] = prod;
        }
        return output;

    }

    /*
    - Initialize an integer array of input array size
    - traverse through array from start index till the end
    - multiply all the digits and store the value in temp variable
    - traverse through the array from left and right
    - fill the new array with division value of product by the current index
    - return the new array
     */

    //Time complexity- O(n)
    //Space complexity- O(n)
    //this will not work when we have zeroes in array
    private int[] findProduct(int[] nums) {
        int product = 1;
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = product / nums[i];
        }

        return output;
    }
    /*
    - Create three new integer arrays prefix, suffix and output of input length
    - initialize prefix[0]=1 and suffix[n-1]=1
    - traverse the array from index=1 until the end
        - multiply prefix[i-1] with nums[i-1] and store it in prefix[i]
    - traverse the array in backward direction from index=length-2 until 0
        - multiply suffix[i+1] with nums[i+1] and store it in suffix[i]
    - traverse the array from left to right
        - fill the output array with product of prefix[i]* suffix[i]
    - return the answer
     */

    private int[] prefixAndSuffix(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix[i] * suffix[i];
        }
        return output;
    }

    private int[] productExceptSelf(int[] nums){
       int[] output=new int[nums.length];
       Arrays.fill(output,1);
       int current=1;
       for (int i=0;i<nums.length;i++){
           output[i]*=current;
           current*=nums[i];
       }
       current=1;
       for (int i=nums.length-1;i>=0;i--){
           output[i]*=current;
           current*=nums[i];
       }
       return output;
    }
}
