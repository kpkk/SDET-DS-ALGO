package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class CommonEarliestSlot {

    /*

    Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.
If there is no common time slot that satisfies the requirements, return an empty array.
The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

Example 1:
Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:
Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []

     */
    @Test
    public void test1(){
        int [] []slots1={{10,50},{60,120},{140,210}};
        int [] []slots2={{0,15},{60,70}};
        int duration=8;
        Assert.assertArrayEquals(findCommonSlot(slots1,slots2,duration),new int[]{60,68});
    }
    @Test
    public void test2(){
        int [] []slots1={{10,50},{60,120},{140,210}};
        int [] []slots2={{0,15},{60,70}};
        int duration=12;
        Assert.assertArrayEquals(findCommonSlot(slots1,slots2,duration),new int[]{});
    }
    @Test
    public void test3(){
        int [] []slots1={{10,20},{40,70},{80,120}};
        int [] []slots2={{30,35},{125,135}};
        int duration=5;
        Assert.assertArrayEquals(findCommonSlot(slots1,slots2,duration),new int[]{});
    }

    /*
    - initialize pointers as slotOneStart=0,slotOneEnd=0, slotTwoStart=0, slotTwoEnd=0
    - Sort both slots arrays by start time
    - iterate the slots1 and slots2 arrays and find the Max start point and min end time
    - if the diff of max start time and min end time is less than or equals to duration then
    - return the start time and start+duration as an output

     */

    private int[] findCommonSlot(int[][] slots1, int[][] slots2,int duration) {
        int slotOneStart=0, slotTwoStart=0;
        Arrays.sort(slots1,(a,b)->{if(a[1]!=b[1]) return a[1]-b[1]; else return a[0]-b[0];});
        Arrays.sort(slots2,(a,b)->{if(a[1]!=b[1]) return a[1]-b[1]; else return a[0]-b[0];});

        int maxStartTime=0, minEndTime=0;

        while (slotOneStart<slots1.length && slotTwoStart<slots2.length){

            int slot1Diff=Math.abs(slots1[slotOneStart][0]-slots1[slotOneStart][1]); //40

            int slot2Diff=Math.abs(slots2[slotOneStart][0]-slots2[slotOneStart][1]); //15

            int[] bigSlot=new int[2]; //10 50
            int[] smallSlot=new int[2]; //0 15

            if(slot1Diff>slot2Diff){
                bigSlot[0]=slots1[slotOneStart][0]; //40
                bigSlot[1]=slots1[slotOneStart][1]; //50
            }else{
                bigSlot[0]=slots2[slotTwoStart][0];
                bigSlot[1]=slots2[slotTwoStart][1];
            }

            if(slot1Diff<slot2Diff){
                smallSlot[0]=slots1[slotOneStart][0]; //0
                smallSlot[1]=slots1[slotOneStart][1]; //15
            }else{
                smallSlot[0]=slots2[slotTwoStart][0];
                smallSlot[1]=slots2[slotTwoStart][1];
            }

            //0-15 //10-50
            if(smallSlot[0]>=bigSlot[0] && smallSlot[1]<bigSlot[1] || smallSlot[1]>=bigSlot[0] && smallSlot[1]<bigSlot[1]){
                maxStartTime=Math.max(slots1[slotOneStart][0],slots2[slotTwoStart][0]);
                minEndTime=Math.min(slots1[slotOneStart][1],slots2[slotTwoStart][1]);
                if(Math.abs(maxStartTime-minEndTime)>=duration) return new int[]{maxStartTime,maxStartTime+duration};
            }

            slotOneStart++;
            slotTwoStart++;

        }
        return new int[]{};
    }
}

