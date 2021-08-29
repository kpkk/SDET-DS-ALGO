package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

public class P3_LongestPalindromicString {
    /*

    Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
     */

    /*
    Input- String
    output- String

     */

    @Test
    public void test1(){
        String s="babad";
        Assert.assertEquals(findLongestPalindrome(s),"bab");
    }
    @Test
    public void test2(){
        String s="abcd";
        Assert.assertEquals(findLongestPalindrome(s),"a");
    }
    @Test
    public void test3(){
        String s="bbada";
        Assert.assertEquals(findLongestPalindrome(s),"ada");
    }
    @Test
    public void test4(){
        String s="\"esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq\"";
        Assert.assertEquals(findLongestPalindrome(s),"yvvy");
    }

    /*
    Solution:-
    - if the string has one character/ empty return the whole string
    - initialize a string variable and length=0
    - Convert the string into a character array
    - iterate the array from start index until end
    - add the first character to the output string
    - iterate the array from one position after i (inner loop)
    - add the character to the string then reverse it
    - compare that with the substring from the original index
    - if both match then get the length
    - if the current length is bigger then the existing length update the string
    - return the string
     */

    private String findLongestPalindrome(String s) {
        if(s.length()==1 || s.trim().length()==0) return s;
        String output="",finalStr=""; int length=0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            output+=chars[i];
            for (int j=i+1;j<chars.length;j++){
                StringBuffer sb=new StringBuffer();
                output+=chars[j];
                sb.append(output);
                if(sb.reverse().toString().equals(s.substring(i,j+1)) && output.length()>length){
                    finalStr=s.substring(i,j+1);
                    length=Math.max(length,output.length());
                }

            }
            output="";
        }

        return finalStr.isEmpty()?s.charAt(0)+"":finalStr;
    }
}
