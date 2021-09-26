package week11;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class StringComma {

    /*
    # 1. If a word in the string is after a comma, insert a comma before every duplicate of the same word
# 2. If a word in the string is before a comma, insert a comma after every duplicate of the same word
# Write a method to change text according to the rules until no more commas can be added.
# Input:
# pray jump spy. jump spy, jump. spy ally now ally.
# Output:
# pray, jump spy. jump spy, jump. spy, ally now, ally.
     */

    @Test
    public void test1(){
        String s="pray jump spy. jump spy, jump. spy ally now ally.";
        Assert.assertEquals(addCommas(s),"pray, jump spy. jump spy, jump. spy, ally now, ally.");
    }

    /*
    Solution:-
    - Initialize a hash map to count the occurrences of word, string as key, integer as value
    - Initialize a String builder to append the characters
    - split the string into a char array
    - if the string occurs only once then append to string builder
    - if the string is a duplicate
    - take the substring last index of the duplicate
    - check that if there is comma before the word
    - if yes, then add , then append the string
    - else add comma after duplicate
     */
    private String addCommas(String s) {
        HashMap<String, Integer>map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        String[] split = s.split(" ");
        for (String str:split){
            String words = str.replaceAll(" ", "");
            map.put(words,map.getOrDefault(words,0)+1);
        }
        for (int i=0;i<split.length;i++){
            if(map.get(split[i])==1){
                sb.append(split[i]+" ");
            }
            if(map.get(split[i].replaceAll("[^a-zA-Z0-9]", ""))>1){
                String substring = s.substring(0, s.lastIndexOf(split[i])+split[i].length());
                String[] s1 = substring.split(" ");
                for (int j=0;j<s1.length;j++){
                    if(s1[j].contains(",") && s1[j+1].equals(split[i])){
                        sb.append(s1[j+1]+" "+",");
                    }else if(s1[j].contains(",") && s1[j-1].equals(split[i])){
                        sb.append(" "+","+s1[j+1]);
                    }
                }
                sb.append(split[i]);
            }
        }
        return sb.toString();
    }
}
