package ally;

import org.junit.Assert;
import org.junit.Test;

public class RotateNumberByKtimes {

    @Test
    public void test1(){
        int n=1234;
        int k=1;
        Assert.assertEquals(rotateDigit(n,k),2341);
    }
    @Test
    public void test2(){
        int n=1234;
        int k=2;
        Assert.assertEquals(shiftDigit(n,k),3412);
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

    /*
    - first count the total number of digits
    - then calculate the k%digitCount and assign it to k
    - perform n/Math.pow(10,digitCount-k) to get the first k digits to be shifted
    - then get the last k digits using n%Math.pow(10, digitcount-k)
    - then count the number of removed digits
    - then return int version of n*math.pow(10, removedDigiCount)+remeoveddigit
     */
    public int shiftDigits(int n, int k){

        int digitCount=findNumberOfDigits(n);
        k=k%digitCount;

        int removedDigit=(int)(n/Math.pow(10,digitCount-k));
        n=(int)(n%Math.pow(10,digitCount-k));
      int noOfdigitsremoved= findNumberOfDigits(removedDigit);
      return (int)(n*Math.pow(10,noOfdigitsremoved)+removedDigit);
    }

    private int rotateDigit(int n, int k){
        int totalInputDigitCount= countDigits(n);
        k%=totalInputDigitCount;
        int removedDigitValue = (int)(n / Math.pow(10, totalInputDigitCount-k));
        int remainingKdigits = (int)(n % Math.pow(10, totalInputDigitCount-k));
        int removedDigitCount = countDigits(removedDigitValue);
        return (int)(remainingKdigits*Math.pow(10,removedDigitCount)+removedDigitValue);
    }

    private int countDigits(int number){
        int count=1;int div=1;
        while (number/div>=10){
            div*=10;
            count++;
        }
        return count;
    }
    private int shiftDigit(int n, int k){
        String result="";
        String digit=String.valueOf(n);
        String toBeRotated=digit.substring(0,k);
        String remainingDigits=digit.substring(k);
        result+=remainingDigits+toBeRotated;
        return Integer.valueOf(result);
    }
}
