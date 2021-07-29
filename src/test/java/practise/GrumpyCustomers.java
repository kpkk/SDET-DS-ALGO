package practise;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GrumpyCustomers {
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
    public void test1(){
        int[] customers={1,0,1,2,1,1,7,5};
        int[] grumpy={0,1,0,1,0,1,0,1};
        Assert.assertEquals(findHappyCustomers(grumpy,customers,3),16);
    }

    /*
    Solution:-

    -Initialize variables maxCustomer=0 and currentCustomer=0
    - Traverse the grumpy array and sum all the customer values where grumpy[i]=0
    - Assign the currentCustomer value to maxCustomer
    - Traverse through the grumpy array from left to right and add the instances where grumpy[i]=1 to the currentCustomers
    - check if the value of i is >X then remove the last element and add the next element
    - keep calculating the maxSum
    -Return the maxCustomerSum
     */

    private int findHappyCustomers(int [] grumpy, int[] customers, int k){
       int currentCustomers=0, maxCustomers=0;
       for (int i=0;i<grumpy.length;i++){
           if(grumpy[i]==0)
           currentCustomers+=customers[i];
       }
       maxCustomers=currentCustomers;
       for (int i=0;i<grumpy.length;i++){
           if(grumpy[i]==1)
               currentCustomers+=customers[i];
           if(i>=k){
               if(grumpy[i-k]==1) currentCustomers-=customers[i-k];

           }
           maxCustomers=Math.max(currentCustomers, maxCustomers);

       }
       return maxCustomers;
    }
}
