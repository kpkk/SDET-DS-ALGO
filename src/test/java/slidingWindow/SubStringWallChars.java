package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubStringWallChars {

    @Test
    public void test1(){
        String s="abcabc";
        Assert.assertEquals(numberOfSubstrings(s),10);
    }
    @Test
    public void test2(){
        String s="\"aacbacaaabababacabbaaabcacbccbbcbbbaabbbbababccacbaaabaacabcccbcacccbaccabccbccbacbaaabaabbcabcbaacacacbacccababaaccbcabacbbcbabcbbaaabcabbabcabcbccbcaacaaaaacabbccbbbbabaccbaccabababaabaccbaccacabbbccabbaabaccaabaaaacbaabacaacabbcbcbcbbaacbaaabccbbbbbaabcbabacccbcbbacabaabababacccbabbababcbabaccccaaaaababcacaacabbbbaacbaccaaaabbacccbaaaccabcccccaabbcaaccabacbbcbcbcbabbabbacbcaacbcacaabbbcbacaabaacbccbcccaabbcbacbbccccbcaaaccbacabbcbcbacccbcaacccbaabbaccabcbccbbcaccacabcabcaaccccababbbabbacbaabccbacbbabccaacbcaaccabaabacabbcbcbacbbbaacbabaaaccacbcccaacbcbbccbcbaabcbbbcbbcccbacbbacabccccccabccbccbcabcccabcacbcbbbcccccabcaccbcabccacbbaacabbcbccbabbbabcabcaccbabacbaaccacabccbcbacaabbaacccbbcccaabccccbbccabcbabbcbcabccacacbbbabaaccacbccacbbcaaacbbbbaacaccbaaabbbaaaacaacabccccbbcbaccaaababbbaaabbccbabcbbbcaaaaaabbbcbabacaaabaccacbbaabcbaacacaababaaabcacbcacbbbcbbccaaaccabbcccccabcbcaccbcacbcccabaaaaabaacacbcbabaacabcabcbaccbabbababacbbcabbacbabaccabbcbcbaacbcccccccabcaabbcbabbacaabccbbbbbbbccccacaabcbbcabbbbbcbacaaacbcbacccbbcbbbbcbccaaabcacaaabccaaccbcaabaccccaaacacbacbbcbaacbabbcbcabcabbaaccbcbabccccbabbaabcccacabccbccccbcbccbcccbbbacbcacabcabcccabbbbccaaaabbbbbccbbbbabbabaaabbacbbbcbcbcbbbbacbbcbaaaaaacaabababccaaabcacacbbacacccbccabcbabcaaccabacbbccbbacbaabccaacbbccbbccacbbaaccbcbaccbbaacbbcabaababcccacccabbbbcbbbabbcbabacacccbcaacbccacabcbbbaaacbaacccacacaacacccbbbaabcaacabccbbcccbaabbaabaccabaacabbabcabaaabbcccaacbbacbabccacbbacccccbcbcbbacbcaaccaaaabbcabcbcbbabcacbaccbccccccacbbcaaacacabbbbaabbbacabbccccacacabccababccbbbbbcbaabacccaaacaccbcbccbbcacaacbaaacbbcbbccacbbbbbbbcacccaabcacacccbbcacababcabcaaabbcacbcbbbcccabbbcacbbaaabbaacaabbccbaacababbcccaccbacabacabcaaccaabcacabaaccaccccccaabbaccabacacbacaaabbbcbacaccbccbcbcacbcbabbbabcbaccacbbabbbbbbcbaaabaaacccacbcacacbbcaacaacaacbbbcaccacccaababaccbbcaabcabbcbacbacbabccacbbbcaabaacaabccacaccbacabccaccbcacaacbcbccabacaccccabbcbbbbacaacabababccbaaaccabbaaccacbcbaabccababacaabbaccacbabcccbbbbbacbabbccbacccbacbbbcaccaaccaabbbcacbcabcacbbccaabbaacacabbcbbbbcbacacabbcbccaacabbaabcccbaaabcbaccbacacbbbcaabbcaabbcacaccccccbaaaacaccacbbaabbbccbacaabaabcaaaacaacaabbabcbbbcaacaaccbcbcbbabaacccccbccbbacbaccbcccccbccccbcbabccbcbccbbbacabbbacbacbbccabbacababccabbabbbcaacabaccaacbbcbaacccaccccbbbbbcbaabacacacaacbbacacbccbacccbbbacaabbcbcbbcaccbccbbabacbacaccccbbbaaaccccaabaaaacabccaaaaacbbacacababbcccbaaabaaccbabbbaacaccaaaaabaabcaabaaacbbacabaacaaaaaccaacabcbcbacacbabbbbccbcbababbaccaaabbcbbbbbbbbbbcabababcacccaabccaaaacbabcbabbbabacbbaacbacabcaacacbcbcbcccbbcaababccaaabbcbabaabccaaaaabcbaaaabccccccbbccbacbababaaaaaaabbaabacaccaabccacbaccccaabbcaabbcbabacbccccbcbcabbbabaccbaababbbbbbabacbaabbcabbcccbcbcbcabababbccccabbabcaaccaacaaccbcbcbcaccbbabccccbaccbacbbbaccccbabbaaababcbacbbacacabcacabbabbaabaacccbaccbbbccbacccbcabcacababbccccacbbcbbaaacaacbabbabbccacacbbbbbacbaacacacabbbbcabacbbbbbcaabcbccbcababacaaabcaacabababcbbbabbcbbccbccbbbaabababacacbbbcccbccbccbbbcbcaaacacaabcabbabbbcccbababbcbcaabcbccaaacbbacbabababaaccababbbccccbaaaacaaabccababccccbcaabaaacbcbacaacbcaabcabcbabbacbacaacaccbabcaaaabbabcccccbcbabbcbbbbbcaaaaaaaacbbcbcaaacaabbbaaccbbbccacbaccbcabaaccabaabaababcabacbabcccaacccbcccbacbbcbbaaacccbaabaaacccaacbaabbcacbcbbcaccabcbbabbbbcabcaccbbbccabccbccbcccbbcabaaababbbcbaacababbccbcbacacabcabbacbcccacbaacbccccccbacbcbccaaaacaaaccbaacaaaacbccbbcabcaacbaabcbbbbaaacacbbbbcaaaaababbaabacccbabcccabbbcbaaccbcabbcaaabcabccbacbaaabcaabbcccccbbcbacbabaabbcbcaacbbcbbcabacccbccacccabbbabaabcbabccacbbacababcaacababcabaaaacbbbacbcbbacbcabcaaccabbcbcbcacbbcaaaaabbaaaccabbcaaababacbaccbccbbaaaaacbccbacabbcaaaabaccbbbbbbaaacbaaabbcbaacaaaacaccccabcacabacaaaaaabcaccbabacbbbcbbcccbbaabcbacacacabaabbabccbcacaacbcbcbcaaabcbbcacbaccccaaaabaacbbaaaaccbbaacbcacbaaabcbbccbbcabbbbbcabcaacccbaabcbabaccabbcabcabcccbacabcbcbcabcbacbabbacabcccaabcaabbbcbcbccacbcacaaababbacbcccbabbaabccaabcabaaaabaababcccaababccbaaccbbbcbbbbcaabccbabaccccccabbcbbbcbbcbbabcccccabacabcbabcbbaabaaaabaaaabcccbaabacbccabcbabbbcbbaacbcbbbcccbcbaaabbbaccbcaaccacabcabccccaabacacbbbbcacaabaaabbccbbcbbbaccaaccbaaaaaabacbbcccbccbcbacbbaaccbaccaccbcabbcaccbbcacbcbccaccbcccabbcacaaccbbabcaabcccbcacbcbccbccabccbababbcccaccacccbbbbcaccbacbbbabaacababaaaaaaacaccaabbabaabccaaccbabcbcccabcacaacbabaacacbcbccbbbacabccacccabcbabcababbabcacacaacbbcabcbbcbabacbccbaaacabbbabcabbacbaaabbaacbccaaabbcbbcbcaaabbccabaacabcaabcbcbaaabbcbcbbccbbcbbcabacbbbcaaccaacacbbbbcaabaccabcbbabcaccbacbcabbabccbbabbcbababccbbbbabbbabbcbcbcabaacabaccbabacccbaabacbcbcacaabacbaacbccabbcaaabbcccabbbaabbccbcacccabcbcaacbacbcbabababaacbbcbbabababcaaacbcaccbacbbabaccaaaccccbcccaabcacacbcaacbcbaaaacbccbccbaccbbacbcbcaccbbccbccaaccaaabacbaaccacabbbacbbaaacbbbbbbcabbbbcacbabaabababbabbacccbbbbbccbacbbbaacacbbcbcbababcaaacbbacaacacbbcbabcbcaacacaaabcaabbaabccaaacacbbaaaacbabcbacabaaacaaacccacbacbabcbaccbbccccaaccabcbbabccbbccaaabcbaccbcbbabacbcbcaacabacacabcacbbcabaccabcbcababbbacaacacbaacbbbcbacccbbacaccacacbaabcabaabcbcacaacbbbaacbabaaaaccbccbbcccaabacaacbaccabcabcacacabccbbcabbabbabacbbcaabbbcabccacbbaaaacacbbcabccbaccaaabbbbababcbaaccbcbaaabcabacacccaabacccbaaaccaaacbbbaacaabcbcbbcabbbbbbbababacabaaacbacaacbccbaccbacaaabbaacaabccbcabcbaacabacbcabbaaaccbbbbcbbccccaabbccbbcabbaabbccaabcccaacbacabccaacccbcabbaabbcbcbacbacccabbaccbccaacaaabaaccccbcbaaaaccacacaaacbabbcaabbbcacacbaccbbbccbbbbbcacccacabaaacaabaababbbbcccccacbbacaabccbacbbacccbbcbaababbbbbaccccaacbbabacaccbbbcaaccaacacccbcbbbaacbbcccbbcbabacbcbbccbbbbaabbccbcacbaaabcabacbbaaaaabccbabcbbabaacbbccbcbcacccaaacbbaabcbbabbabbccabcbabcbcacaaabbbbababaccccabcbaccbaaccabababcabbcbaaabbbbccabbccbaababaabbaccbcaacbaabaacbccabcbcbbbcccbacaaabaccaaacabaabccbbcccbcccccbbbbaccababcabaabbccabcacabcccbbacccaccbcaaaacaaacbaabbcbcbacabababbbcaacaabccaaacabcabccbcbabaabaacbaabaabccbbaaabacaacaaccbaaacbccabaababbcababcabcaabbcaabbcabcbbbaabcaccccaabccacbbaaaabacaabbcbbbbccccccbbaacbaccababaaccaacbabbcbaacacbbaccaabcaccbbbcaacbaaaaabacbbcbaacbcbbcbcbbaabbbaccbbabbcbcbcccaacabbabacacabbcbccaabacbcabbaabcaababccbccabaccbbbaccbbabcabbbcaacaabcaabcbcaacbcabbcabbcbcbbcacaacaacccbbcaacabaabcccbcbcbbbbbbbbbccbaacbbccbbcbcabcbbbabaccbaabaccccbabcbbbacacbbabbcbbabbbcabaacbaababccbcabaaacbbccbbbabaaacbbbabbbbbccbacbabaccaccbabbabbbcbbabaabbbabcaabaababbacccacacbbccbbbbbbaababacbcccbbaaabbbbbbcabcbcccaccabacababccaaacccaaacbaccccbbcbabcbbcbbbcccabcbbabbcabcaaaccaabbaabbcabccbacbaaaacbcbbabcaccacaacacaaabcbbbcbcabacbbcacbacabbacbccbbacccacbbbbbccbbbcaabbaaabacacbaaabcaacbbcbaaabcbccbcbaabbaaaabababccbcabbcabcbaaccabcabbabbbaaabacaacabbaccacacaaaabaabbabccbcbcacccaaabbacbacbabcbbaaabcaabaaaabaacbbccccbbcaaabccabababbbbccaaaaaacbcbaaccbacbcbaacbabaaababacabbccccbbaacbbbcbacbacbbcacacbbbacaabbcbcaacbabbcabbcabababbaababaccabababbccbcaccaccaabbbcbbcacccccbabccbaacbabacbbabacaabbcccbbccbabaacbccaaacacbaaabacbccbbccbabbaababcbabcbbbabbcabccacbbabcbbbcaacacaabbacabbbcaccabcbbcccbbcbbaaacbcbabccaababbccbbcbabacabacbccaaababaaabaacbaaabacbbbbacbccacaccccbaacccaabaabcbcacbbbabbabbacccabcaccbabaccaaabcbcbcaabbcbacaabcabcccbaabbbbcbcbcbcccaaacaaccbbcaaaacbacacacacaabcbcccbbbbaaccbaabaaabbabcaabccabcbaacacaaabacbcbaccaacabcababbbbaccacacabaccbccbcabbbabcccbaaacabacabbcbcbaaabaccabcccccccbbcabccbcbbabccaaaaabcbcabcbabbbbbaabaaabcccccbccbbcbbcbbabbcbacacaccaabaccbbbabbabaababcccaccbaaababcccabbcaaabacbabbacacababbcacbcccbaaaabbcaacabbcabaabcacbbcacacaacbbbcbacbaababbaacbbbbbccccacaabcaabbcbbcbabcbaabbabccbaccbccaacbbbbbaacbaaabbacccaaabbbbabaaabbaaaabcbbbbacbabbbccbababbcccaabbaabbbaaccccbbbbaabbacabacbcbabacbacbbcacaacccbcccaaacbbccbbcbcbcbcaababcbcbccaacbbcabbbcaaccccaacccbbaccaccaaccbccbccacbcaaaaaabbbaaabaaababbccabccacbbcababcabccbabcbabbbbaabcbcacabaabbbabbbcabaccaaacbbbaaaaabaababbabcabacaccaacabcbcaaacccccbcbcbcbbcccacbabaaaaaacbbcacaccabcccacccabbbcacbcbaacbaccbacbabccbcaccabaaccaacaccaaacbbacccccabbccabbbabaaacacbaccaababccbcaccccacbabacacbcbcccbbbcbcbcabcbacbacbcabccccbcbacbbaabccabcabacbababbaaabbbbaccbababcccbccaabaacababcbbaccacbcacabbcbbbabcacccaccbcccaababccaaccbccbcacabaaabbccbabccbabaccbabbbccccacababbaacbabcbbccccababbcbbbaccacaabbaaccbabcbbabaabcbacacacbbacabcababacbcbaccbbabaaccccbccbbbababababaaaaaaabbbcccbabccbaccacabcbacacccbbbcccaabaacacbabbbcacbccabaccbacccabacaabbacabcabbbcaacbccbccbbbabccccbabacbabacabcccccbacbcabcaaacabaabacababcacbcbabcaacaacbaaabaacaaccaacbcacbbabbcbaccababbcaaacbbaaaaccaaaccbccaccabaaabacbcaaabaccabcabbcccabcaacabbcacabbcbcaccaabbaababccbbccabaccacacbccbaaccbaacbbccabcababcbbacabbacabcbbacaabcbbcaccabcbcccbaccbbcbbbaaaccbcbaaabbbaccbcccbcbccacaabbbcbaabaaabaabcaacabbaacacbcaabcbabccaccaabccaacbabcccbaaccccbbcbbabbabbcbababbabcacabbbbcbabccaccaccababccccaacccabacbbccacacaacbaacaaaccaccccccacbbcacacacabbaaccbbbabbbbbbbccabacccbbcaabababcccbaacacabbccccaaaccbaccbaaacbbaacbbacaabbcacbcbbbccacaccaccacabaabaabacbccbccaccbacbbacacabacbbcaabbacbcbabbaabcacacabbcabbccaccbbcccccbbbbaaccaaabcabbcaabcbaaacacaabaabbbcacabbcaccaacbaaaccabcacaaccacbccbcabbaccbcccbaccbabccabaabbaccbbcaacbbbabbbaabbbacbbbabccaccbbaacaacabbbcababbacbbbbcbccaccabbcaacbcbaacccaacaaaaccaabcbaccabccaacacaaababccacbbbacbbbcbaaacbabbbcccbacaabbcbcabcbbccbaacaccacacbbbbcccccbbbbabcbacabccacaaabbbcbabcacacbbcabaaaabbccabaccaabaccbaccaacaccbaccaabcabacccbbaaccbabcbaacaaaccbcacbaacababacacbaaabcbbcccacacbccaacccbcbcacabcabccbccbbbbbacaaabaaccccacbacbbacabccbccbcaababbbacabcbaaccaaccacacccccaaabbabbbcabaaaaaaabcbbbacababcbbaccbccccaabbbaaabbbccbbcccaccacababbccaababcabbcababbaacacaaabcacbbccbccbbbbcbaaccbcacbbbcacaabcabaccaacacbcacbbccbabcbaccbccacbbcbaababaccaaccababbcbacabaabbaacccaaccaaaabcabcbbbabbccbcabbaaacabcaabccbcabcbabaac\"";
        Assert.assertEquals(numberOfSubstrings(s),10);
    }
    @Test
    public void test3(){
        String s="aaacb";
        Assert.assertEquals(numberOfSubstrings(s),3);
    }

    /*
       - input- string
       - output - integer

       solution:-
       - initialize two pointers left=0, right=0
       - Initialize a hashset and add the three distinct chars a,b,c
       - while left less than or equals reaches s.length-set.size()
       - Initialize another set to add string characters
       - add every char at the right index
       - keep checking if the set sizes are equal
           - if both the sets are equal then increment the count
           - check if right reaches length, if yes remove char at left, left++ and assign left to right
       - return the count
       */
    public int numberOfSubstrings(String s) {
        int left=0, right=0, count=0;
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        while (right<s.length()){
           map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
           while (map.size()>=3){
               if(map.get(s.charAt(left))>1){
                   map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
               }else{
                   map.remove(s.charAt(left));
               }
               left++;

           }
           count+=left;
           right++;
        }
        return count;
    }
    public int numberOfSubstrings1(String s) {
        //use a dynamic sliding window with aux DS
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int numSubstrings = 0;
        int leftWindowIdx = 0;

        //basic window algorithm set up
        for(int rightWindowIdx = 0; rightWindowIdx < s.length(); rightWindowIdx++){
            //increase the window size
            char rightChar = s.charAt(rightWindowIdx);
            //add the freq of a,b,c
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);

            //if a,b,c freq are all >= 1 we can reduce the window until we break OG condition
            while(charFreqMap.size() >= 3){
                //close window and decrease char count for left-most char
                char leftChar = s.charAt(leftWindowIdx);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                //don't forget to remove any empty char count
                if(charFreqMap.get(leftChar) == 0){
                    charFreqMap.remove(leftChar);
                }
                //close window
                leftWindowIdx++;
            }
            //each idx after closing will be equal to the number of substrings after this idx
            numSubstrings += leftWindowIdx;
        }
        return numSubstrings;
    }
}
