package week5;

import org.junit.Assert;
import org.junit.Test;

public class FindAvgSalary {
    /*

    1491. Average Salary Excluding the Minimum and Maximum Salary
Easy

334

70

Add to List

Share
Given an array of unique integers salary where salary[i] is the salary of the employee i.

Return the average salary of employees excluding the minimum and maximum salary.



Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000)/1= 2000
Example 3:

Input: salary = [6000,5000,4000,3000,2000,1000]
Output: 3500.00000
Example 4:

Input: salary = [8000,9000,2000,3000,6000,1000]
Output: 4750.00000
     */

    /*
    Input- Integer array
    Output- double
    Constraints- O(n)


     */
    @Test
    public void test1(){
        int[] salaries={4000,3000,1000,2000};
        Assert.assertEquals(2500.00,findAvg(salaries),00);
    }
    @Test
    public void test2(){
        int[] salaries={1000,2000,3000};
        Assert.assertEquals(2000.00,findAvg(salaries),00);
    }
    @Test
    public void test3(){
        int[] salaries={6000,5000,4000,3000,2000,1000};
        Assert.assertEquals(3500.00,findAvg(salaries),00);
    }
    @Test
    public void test4(){
        int[] salaries={8000,9000,2000,3000,6000,1000};
        Assert.assertEquals(4750.00,findAvg(salaries),00);
    }
    @Test
    public void test5(){
        int[] salaries={48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        Assert.assertEquals(41111.11111,findAvg(salaries),00);
    }

    /*
    Solution:-
    - Iterate the array and find the min and max and sum
    - sum all the elements except min and max
    - subtract min and max from sum
    - return the division of sum/length-2
     */

    // Time complexity- O(n)
    //space complexity - O(1)
    private double findAvg(int[] salaries) {
        if(salaries.length==1) return salaries[0];
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, sum=0;
        for (int i=0;i<salaries.length;i++){
            max=Math.max(max,salaries[i]);
            min=Math.min(min,salaries[i]);
            sum+=salaries[i];
        }
        return (sum-max-min)/(salaries.length-2);
    }
}
