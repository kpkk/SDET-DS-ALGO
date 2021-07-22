package practise;

import org.junit.Test;

public class MajorityElement {

    @Test
    public void test1(){
        int [] nums={1,2,2,2,2,3,4};
        int majorityEle = findMajorityEle(nums);
        System.out.println(majorityEle);
    }

    private int findMajorityEle(int[] nums) {
        int majority=0, max=0;
        for (int i=0;i<nums.length;i++){
            int count=0;
            for (int j=0;j<nums.length;j++){
                if(nums[i]==nums[j])
                    count++;
            }
            if(max<count){
                max=count;
                majority=nums[i];
            }
        }
        if(max>nums.length/2){
            return majority;
        }
       // System.out.println(majority);
        return 0;
    }
}
