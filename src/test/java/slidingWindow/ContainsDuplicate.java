package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeSet;

public class ContainsDuplicate {

    @Test
    public void test1(){
        int[]nums={1,2,3,1};
        int k=3,t=0;
        Assert.assertEquals(containsDupOptimized(nums,k,t),true);
    }
    @Test
    public void test2(){
        int[]nums={1,5,9,1,5,9};
        int k=2,t=3;
        Assert.assertEquals(containsDupOptimized(nums,k,t),false);
    }
    @Test
    public void test3(){
        int[]nums={-2147483648,2147483647};
        int k=1,t=1;
        Assert.assertEquals(containsDupOptimized(nums,k,t),false);
    }

    private boolean containsDup(int[] nums, int k, int t) {
       for (int i=0;i<nums.length-1;i++){
           if(nums[i]<0){
               nums[i]=nums[i]*-1;
           }

           for (int j=i+1;j<nums.length;j++){
               if(nums[j]<0) {
                   nums[i]=nums[j]*-1;
               }
               if(Math.abs(nums[i]-nums[j])<=t && Math.abs(i-j)<=k)return true;
               else continue;
           }
       }
       return false;
    }

    private boolean containsDupOptimized(int[] nums, int k, int t){
        if(nums.length==0 || nums==null || k<0 || t<0) return false;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer floor = set.floor( nums[i] + t);
            Integer celi=set.ceiling(nums[i]-t);
            if(floor!=null && floor>=nums[i] || celi!=null && celi<=nums[i]){
                return true;
            }
            set.add(nums[i]);
            if(i>=k){
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
}
