package ally;

import org.junit.Assert;
import org.junit.Test;

public class RotateNumberByKtimes {

    @Test
    public void test1(){
        int n=1234;
        int k=1;
        Assert.assertEquals(shiftDigits(n,k),2341);
    }
    @Test
    public void test2(){
        int n=1234;
        int k=2;
        Assert.assertEquals(shiftDigits(n,k),3412);
    }

    /*
    - convert the given number into an array
    - then rotate the numbers
    - construct the array back into a number, return

     */
    private int rotateNumber(int n, int k) {

        int div=1, count=1;
        while (n/div>=10){
            div=div*10;
            count++;
        }
        int [] nums=new int[count];
        int index=nums.length-1;
        for (int i=nums.length-1;i>=0;i--){
            nums[i]=n%10;
            n/=10;
        }
        for(int i=0;i<k;i++){
            for(int j=0;j<nums.length-1;j++){
                int temp=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=temp;
            }
        }

        int total=0;
        for(int num: nums){
            total=total*10+num;
        }
        return total;
    }


    public int findNumberOfDigits(int n){
       int div=1, count=1;
       while (n/div>=10){
           div*=10;
           count++;
       }
       return count;
    }

    public int shiftDigits(int n, int k){

        int digitCount=findNumberOfDigits(n);
        k=k%digitCount;

        int removedDigit=(int)(n/Math.pow(10,digitCount-k));
        n=(int)(n%Math.pow(10,digitCount-k));
      int noOfdigitsremoved= findNumberOfDigits(removedDigit);
      return (int)(n*Math.pow(10,noOfdigitsremoved)+removedDigit);
    }
}
