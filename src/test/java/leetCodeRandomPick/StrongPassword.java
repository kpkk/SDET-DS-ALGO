package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;

public class StrongPassword {


    @Test
    public void test1() {
        String s="4700";
        Assert.assertEquals(minimumNumber(4,s),3);
    }

    /*
   - Initialize a map with String as key, boolean as value
   - convert the string into char array
   - iterate the char array from start till the end
   - check if the character at a specified index is , idigit, isUpperCase,isLowerCase
   - accordingly update the map value as true
   - iterate tha map and get the count of number of false
   - if the input string length greater then return the false count
   -  if the string length is lesser than 6, then add false count to the input length then diff
   */
    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        String special_characters = "!@#$%^&*()-+";
        HashMap<String, Boolean> map=new HashMap<String, Boolean>(){
            {
                put("isDigit",false);
                put("isUpper",false);
                put("isLower",false);
                put("isSpecial",false);
            }
        };
        int count=0;
        char[] chars=password.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(Character.isDigit(chars[i])){

                map. put("isDigit",true);
            }
            if(Character.isUpperCase(chars[i])){
                map. put("isUpper",true);
            }
            if( Character.isLowerCase(chars[i])){

               map. put("isLower",true);
            }if(special_characters.contains(chars[i]+"")){

                map.put("isSpecial", true);
            }
        }
        Collection<Boolean> values=map.values();
        for(Boolean value:values){
            if(value==false){
                count++;
            }
        }
        if(n>=6) return count;
        else {
            if((count+n)>=6) return count;
            else return (6-(n+count))+count;
        }
    }
}

