package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersDisAppeared {

    @Test
    public void test1(){
        int[] list= new int[]{4,3,2,7,8,2,3,1};
        Assert.assertEquals(findDisappearedNumbers(list),Arrays.asList(5,6));
    }
    @Test
    public void test2(){
        int[] list= new int[]{1,1};
        Assert.assertEquals(findDisappearedNumbers(list),Arrays.asList(2));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
       int left=0, right=1;
       if(nums.length==2 && nums[0]==nums[1]) return Arrays.asList(2);
       List<Integer>list=new ArrayList<>();
       Arrays.sort(nums);
       while (right<nums.length){
           if(nums[left]!=nums[right]){
               int abs = Math.abs(nums[left] - nums[right]);
               if(abs>1){
                   int count=nums[left];
                   while (abs!=1){
                       list.add(++count);
                       abs--;
                   }
                   count=0;
               }
               nums[++left]=nums[right];
           }
           right++;
       }
       return list;
    }
}

/*
 List<Integer> list= new ArrayList<Integer>();
        List<Integer>set=new ArrayList<>();
        for(int n: nums){
            set.add(n);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i))
                list.add(i);
        }
        return list;
 */