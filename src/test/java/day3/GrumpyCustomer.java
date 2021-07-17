package day3;

import org.junit.Assert;
import org.junit.Test;

public class GrumpyCustomer {

    /*

    2) Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
Return the maximum number of customers that can be satisfied throughout the day.

Example 1:
Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
     */

    @Test
    public void test1() {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;
        Assert.assertTrue(findSatisfiedCustomers3pass(customers, grumpy, x) == 16);
    }

    @Test
    public void test2() {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {1, 1, 1, 1, 1, 1, 1, 1};
        int x = 2;
        Assert.assertTrue(findSatisfiedCustomers3pass(customers, grumpy, x) == 12);
    }

    @Test
    public void test3() {
        int[] customers = {0, 0, 0, 0};
        int[] grumpy = {0, 0, 0, 0};
        int x = 2;
        Assert.assertTrue(findSatisfiedCustomers3pass(customers, grumpy, x) == 0);
    }
    /*

    Solution:
    1. initialize a int variables called maxCustomers=0 and currentCustomers=0
    2. Traverse through the grumpy array and calculate the number of satisfied customers (grumpy[0]==0) and store it in currentCustomers and store in maxCustomers
    3. Traverse through the grumpy array  up until x if(grumpy[i]==1) then add that to currCustomers
    5. Traverse the grumpy array from i=1 to i+length-1
            -  remove the last element from the window (i-1) and add i
            - if the element removed grumpy[i-1]==1 then remove the customers count of that index
            - calculate the max and return the same
    6. return the maxSum


                 */

    private int findSatisfiedCustomers(int[] customers, int[] grumpy, int X) {
        int maxCustomers = 0, currCustomers = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) currCustomers += customers[i];
        }
        maxCustomers = currCustomers;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 1)
                currCustomers += customers[i];
            if (i >= X) {
                if (grumpy[i - X] == 1)
                    currCustomers -= customers[i - X];
            }
            maxCustomers = Math.max(maxCustomers, currCustomers);

        }

        return maxCustomers;
    }

    private int findSatisfiedCustomers3pass(int[] customers, int[] grumpy, int X) {
        int maxCustomers = 0, currCustomers = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) currCustomers += customers[i];
        }
        maxCustomers = currCustomers;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) currCustomers += customers[i];
        }
        maxCustomers = Math.max(currCustomers, maxCustomers);
        for (int i = 1; i < grumpy.length - X + 1; i++) {
            if (grumpy[i - 1] == 1) currCustomers -= customers[i - 1];
            if (grumpy[i + X - 1] == 1) currCustomers += customers[i + X - 1];
            maxCustomers = Math.max(currCustomers, maxCustomers);
        }
        return maxCustomers;
    }
}
