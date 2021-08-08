package week5;

import org.junit.Assert;
import org.junit.Test;

public class FindKthFactor {
    /*

    Given two positive integers n and k.

A factor of an integer n is defined as an integer i where n % i == 0.

Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.



Example 1:

Input: n = 12, k = 3
Output: 3
Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
Example 2:

Input: n = 7, k = 2
Output: 7
Explanation: Factors list is [1, 7], the 2nd factor is 7.
Example 3:

Input: n = 4, k = 4
Output: -1
Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
Example 4:

Input: n = 1, k = 1
Output: 1
Explanation: Factors list is [1], the 1st factor is 1.
Example 5:

Input: n = 1000, k = 3
Output: 4
Explanation: Factors list is [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000].


Constraints:

1 <= k <= n <= 1000


Input- two integers n,k
output- integer
Constraint- O(n)

     */
    @Test
    public void test1(){
        int n=12, k=3;
        Assert.assertEquals(3,findFactor(n,k));
    }
    @Test
    public void test2(){
        int n=7, k=2;
        Assert.assertEquals(7,findFactor(n,k));
    }
    @Test
    public void test3(){
        int n=4, k=4;
        Assert.assertEquals(-1,findFactor(n,k));
    }
    @Test
    public void test4(){
        int n=1, k=1;
        Assert.assertEquals(1,findFactor(n,k));
    }
    @Test
    public void test5(){
        int n=1000, k=4;
        Assert.assertEquals(5,findFactor(n,k));
    }

    /*
    - Initialize an integer variable counter=0
    - iterate from 1 until the number
    - check if the number is divisible by i value, if yes increment the counter
    - if counter becomes k then return the number
    - if the counter is not k, and loop completed, return -1
     */

    private int findFactor(int n, int k) {

        int counter=0;
        for (int i=1;i<=n;i++){
            if(n%i==0)counter++;
            if(counter==k) return i;
        }
        return -1;
    }
}
