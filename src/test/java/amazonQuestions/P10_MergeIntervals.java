package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class P10_MergeIntervals {
    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
     */
    @Test
    public void test1(){
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        Assert.assertArrayEquals(mergeIntervals(intervals),new int[][]{{1,6},{8,10},{15,18}});
    }
    @Test
    public void test2(){
        int[][] intervals={{1,4},{4,5}};
        Assert.assertArrayEquals(mergeIntervals(intervals),new int[][]{{1,5}});
    }
    @Test
    public void test3(){
        int[][] intervals={{1,4},{5,6}};
        Assert.assertArrayEquals(mergeIntervals(intervals),new int[][]{{1,4},{5,6}});
    }

    /*
    - Sort the arrays based on the start time of the meeting
    - Initialize two pointers start and end
    - If the current meeting end time is greater than the next meeting start time
    - then get the first start time and last end time between those two meetings
    - return the new overlapped array
     */

    private int[][] mergeIntervals(int[][] intervals) {
      if(intervals.length==1) return intervals;
      Arrays.sort(intervals,(a,b)->{if(a[0]!=b[0]) return a[0]-b[0]; else return a[1]-b[1];});
      List<List<Integer>>meetings=new ArrayList<>();
      int startTime=intervals[0][0];
      int endTime=intervals[0][1];
      for (int i=1;i<intervals.length;i++){
          if(intervals[i][0]<=endTime){
              endTime=Math.max(endTime,intervals[i][1]);
          }else{
              meetings.add(Arrays.asList(startTime,endTime));
              startTime=intervals[i][0];
              endTime=intervals[i][1];
          }
      }
      meetings.add(Arrays.asList(startTime,endTime));
      int[][] mergedMeetings=new int[meetings.size()][2];
      for (int i=0;i<meetings.size();i++){
          mergedMeetings[i][0]=meetings.get(i).get(0);
          mergedMeetings[i][1]=meetings.get(i).get(1);
      }
      return mergedMeetings;
    }

    private int[][] mergeMeetingIntervals(int[][] meetings){
        List<List<Integer>>mergedMeetings=new ArrayList<>();
        Arrays.sort(meetings,(a,b)->{if(a[0]!=b[0]) return a[0]-b[0]; else return a[1]-b[1];});
        int startTime=meetings[0][0];
        int endTime=meetings[0][1];
        for (int i=1;i<meetings.length;i++){
            if(meetings[i][0]<=endTime){
                endTime=Math.max(endTime,meetings[i][1]);
            }else{
                mergedMeetings.add(Arrays.asList(startTime,endTime));
                startTime=meetings[i][0];
                endTime=meetings[i][1];
            }
        }
        mergedMeetings.add(Arrays.asList(startTime,endTime));
        int[][] output=new int[mergedMeetings.size()][2];
        for (int i=0;i<mergedMeetings.size();i++){
            output[i][0]=mergedMeetings.get(i).get(0);
            output[i][1]=mergedMeetings.get(i).get(1);
        }
        return output;
    }
}
