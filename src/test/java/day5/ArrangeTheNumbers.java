package day5;

import org.junit.Test;

public class ArrangeTheNumbers {
    /*

    2.array of nums, contains equal no of positve and negative, rearrange in an order +ve and then -ve in alternate positions.
	Constraint: cannot use extra space
	eg : int[] input = {12, -90, -100, 15, 98, 99, -56, -2};
			   expected output {12, -90, 15, -100, 98,-56,99,-2}
     */

    @Test
    public void test1() {
        int[] nums = {12, -90, -100, 15, 98, 99, -56, -2};
        int[] output = {12, -90, 15, -100, 98, -56, 99, -2};
        reArrangeNumbersAlternateSign(nums);
    }

    private int[] reArrangeNumbersAlternateSign(int [] nums){
        int j=0, temp=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]<0){
                temp=nums[j];
                nums[j++]=nums[i];
                nums[i]=temp;
            }
        }
        int index=0;
        while ( index<j && index<nums.length&&nums[index]<0){

            temp=nums[index];
            nums[index]=nums[j];
            nums[j++]=temp;
            index+=2;
        }
        return nums;
    }

    private int[] reArrangeNumbers(int[] nums){
        int index=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]<0&& i%2==0){
                index=i;
                while (nums[++index]<0){
                    int temp= nums[index];
                    nums[index]=nums[i];
                    nums[i]=temp;
                }
            }else if(i%2!=0 && nums[i]>0){
                index=i;
                while (nums[++index]>0){
                    int temp= nums[index];
                    nums[index]=nums[i];
                    nums[i]=temp;
                }

            }

            }

        return nums;
        }

    }


