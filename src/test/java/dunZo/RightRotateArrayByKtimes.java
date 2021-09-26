package dunZo;

import org.junit.Assert;
import org.junit.Test;

public class RightRotateArrayByKtimes {
    /*
    Rotate an array to right for k times
Input=[1,2,3,4,5] k=3
Output=[3,4,5,1,2]
     */
    @Test
    public void test1(){
        int[] nums={1,2,3,4,5};
        int k=3;
        Assert.assertArrayEquals(rotateOptimized(nums,k),new int[]{3,4,5,1,2});
    }

    /*
    - initialize two pointers left=k-1, right= nums.length-1
    - iterate the loop from index-->1 until k
    - swap the numbers at posyion left and right
     */
    private int[] rightRotate(int[] nums,int k) {

        int left=k-1, right=nums.length-1;
        for (int i=1;i<=k;i++){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left--;
            right--;
        }
        return nums;
    }

    /*

     */
    public int[] rotateArray(int [] nums, int k){
       for (int i=0;i<k;i++){
           for (int j=nums.length-1;j>0;j--){
               int temp=nums[j];
               nums[j]=nums[j-1];
               nums[j-1]=temp;
           }
       }
       return nums;
    }

    public int[] rotateArrayWithSpace(int [] nums, int k){
        int [] output=new int[nums.length];
        int index=0;
        for (int i=k-1;i<nums.length;i++){
            output[index++]=nums[i];
        }
        for (int i=0;i<k-1;i++) {
            output[index++]=nums[i];
        }
        return output;
    }
    public int[] rotateOptimized(int[] nums, int k){
        int index=0;
        int left=0, right=nums.length-1;
        while (left<right){
            int temp=nums[left];
            nums[left++]=nums[right];
            nums[right--]=temp;
        }

         left=0; right=k-1;

        while (left<right){
            int temp=nums[left];
            nums[left++]=nums[right];
            nums[right--]=temp;
        }
        left=k; right=nums.length-1;
        while (left<right){
            int temp=nums[left];
            nums[left++]=nums[right];
            nums[right--]=temp;
        }
        return nums;
    }
}
