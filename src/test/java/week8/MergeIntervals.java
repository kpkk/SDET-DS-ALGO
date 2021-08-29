package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {

    /*

Given an array of intervals [[1,3],[2,4],[6,9]], merge the overlapping intervals, i.e to [[1,4],[6,9]]


[1,3][2,4][3,6] —[1,6]

     */
    @Test
    public void test1(){ // {1 3}- {1,4}
        int[][] intervals={{1,3},{2,4},{6,9}};
        Assert.assertArrayEquals(mergeIntervals(intervals),new int[][]{{1,4},{6,9}});
       // System.out.println(mergeIntervals1(intervals));

    }
    @Test
    public void test2(){
        int[][] intervals={{1,3},{2,4},{3,6}};
        Assert.assertArrayEquals(mergeIntervals(intervals),new int[][]{{1,6}});

    }
    @Test
    public void test3(){
        int[][] intervals={{1,4},{3,4},{5,7},{8,10},{9,13}};
        Assert.assertArrayEquals(mergeIntervals(intervals),new int[][]{{1,4},{5,7},{8,13}});

    }
    @Test
    public void test4(){
        int[][] intervals={{1,3},{3,4}};
        Assert.assertArrayEquals(mergeIntervals(intervals),new int[][]{{1,4}});

    }
    @Test
    public void test5(){
        int[][] intervals={{1,13},{3,4},{5,7},{8,10},{9,11}};
        Assert.assertArrayEquals(mergeIntervals(intervals),new int[][]{{1,13}});
    }

    /*
    Input- two dimensional int array
    output- 2d- int array
    [[1,4],[3,4],[5,7],[8,10],[9,13]]
    [[1,13],[3,4],[5,7],[8,10],[9,11]]

    conditions
    startTime, Endtime
    end time of first meet >start time of next
    end time of first meet less than end time of next

    Pseudo code:-
    - Sort the array based start time
    - initialize an list of array list of integer type
    - initialize variables startTime=first meet start time and end time=first meet end time
    - iterate the array from index 1
    - check if end time of first meeting(i-1) is greater than or equals to start time of current meeting(i)
       - calculate tha max end time and continue
    - else add the start time and end time to the list
    - if the end is reached add the current start time and end time to the list

     */
    private int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals,(i,j)->{if(i[0]!=j[0]) return i[0]-j[0]; else return i[1]-j[1];});
        List<List> list=new ArrayList<>();
        int startTime=intervals[0][0], endTime=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=endTime){
                endTime=Math.max(endTime,intervals[i][1]);

            }else{
                list.add(Arrays.asList(startTime,endTime));
                startTime=intervals[i][0];
                endTime=intervals[i][1];
            }
        }
        list.add(Arrays.asList(startTime,endTime));
        int[][] output=new int[list.size()][2];
        for (int i=0;i<list.size();i++){
            int j=0;
            List list1 = list.get(i);
            Iterator iterator = list1.iterator();
            while (iterator.hasNext()){
                output[i][j++]=(int)iterator.next();
            }
        }
        return output;
    }

}

