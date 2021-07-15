package day3;

import org.junit.Assert;
import org.junit.Test;

public class Calories {

    /*

    1) A dieter consumes calories[i] calories on the i-th day. For every consecutive sequence of k days, they look at T, the total calories consumed during that sequence of k days:

If T < lower, they performed poorly on their diet and lose 1 point;
If T > upper, they performed well on their diet and gain 1 point;
Otherwise, they performed normally and there is no change in points.
Return the total number of points the dieter has after all calories.length days.

Note that: The total points could be negative.

Example 1:
Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
Output: 0
Explaination: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.

Example 2:
Input: calories = [3,2], k = 2, lower = 0, upper = 1
Output: 1
Explaination: calories[0] + calories[1] > upper, total points = 1.

Example 3:
Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
Output: 0
Explaination: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.


1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? integer array
        What is the expected output? integer value
        Do I’ve constraints to solve the problem? use sliding window
        Do Ive all the information to go to the next steps yes
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this
5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data
10. If it fails then debug to solve it
11. Optimize the code and remove unnecessary code

     */

    @Test
    public void test1() {
        int[] calaroies = {1, 2, 3, 4, 5};
        int output = 0, k = 1, lower = 3, upper = 3;
        Assert.assertEquals(calculateCaloriesConsumtption(calaroies, lower, upper, k), output);
    }

    @Test
    public void test2() {
        int[] calaroies = {3, 2};
        int output = 1, k = 2, lower = 0, upper = 1;
        Assert.assertEquals(calculateCaloriesConsumtption(calaroies, lower, upper, k), output);
    }

    @Test
    public void test3() {
        int[] calaroies = {6, 5, 0, 0};
        int output = 0, k = 2, lower = 1, upper = 5;
        Assert.assertEquals(calculateCaloriesConsumtption(calaroies, lower, upper, k), output);
    }

    @Test
    public void test4() {
        int[] calaroies = {2, 3, 4, 5, 0, 0};
        int output = -5, k = 1, lower = 5, upper = 10;
        Assert.assertEquals(calculateCaloriesConsumtption(calaroies, lower, upper, k), output);
    }

    /*
    Solution:-
    1. Initialize a variable called sum=0, total=0
    2. Traverse through the array until the k elements and calculate sum, compare with lower and upper values
        - if its less than lower then output-=1
        - If its greater than upper then output+=1
    3. Traverse through the array from 1 index and add the subsequent elements of k window size
    4. compare the sum value with lower and upper values
        - if its less than lower then output-=1
        - If its greater than upper then output+=1
    5. return the output

     */

    private int calculateCaloriesConsumtption(int[] calaroies, int lower, int upper, int k) {

        int sum = 0, total = 0;
        for (int i = 0; i < k; i++) {
            sum += calaroies[i];
        }
        if (sum < lower) total--;
        else if (sum > upper) total++;
        if(calaroies.length==k) return total;
        for (int i = k; i < calaroies.length-k+1; i++) {
            sum += calaroies[i] - calaroies[i - k];
         //  else sum += calaroies[i] - calaroies[i - k];

            if (sum < lower) total--;
            else if (sum > upper) total++;
            else continue;
        }
        return total;
    }
}
