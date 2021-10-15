package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RotateArray {
    public int[] rotateArray(int[] nums, int k) {
        k = k % nums.length;
        if(nums.length == 1 || k==0){
            return nums;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = nums.length - k; i < nums.length; i++){
            queue.add(nums[i]);
        }
        for(int i = nums.length - 1; i >= k; i--){
            nums[i] = nums[i - k];
        }
        for(int i = 0; i < k; i++){
            nums[i] = queue.poll() ;
        }
        return nums;
    }

}
