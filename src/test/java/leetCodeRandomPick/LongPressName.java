package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

public class LongPressName {
    /*
    Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.


Constraints:

1 <= name.length <= 1000
1 <= typed.length <= 1000
name and typed contain only lowercase English letters.
     */
    @Test
    public void test1(){
        String name="alex";
        String mistype="aaleexa";
        Assert.assertEquals(findMismatch(name,mistype),false);
    }

    /*
    Input- two string
    output- boolean
    Solution - two pointer
    - Initialize two pointers uni directional, to traverse two strings
    - while the pointers doesn't cross the length ot strings
    - check if the character at index p1, p2 are same
    - if yes increment both p1 and p2
    - else, check if character at p2 and p2-1 are same
        - if not return false
    - if p2 is not still at length, check if all remaining chars are same, if yes return true
        - else false
    - if p1 is not at lenth, check if all the remaining chars are same, if yes return true
        - else false
     - return true
     */

    private boolean findMismatch(String name, String mistype) {
        int p1=0,p2=0;
        while (p1<name.length()&& p2<mistype.length()){
            if(name.charAt(p1)==mistype.charAt(p2)){
                p1++;
                p2++;
            }else{
                if(p2==0) return false;
                if(mistype.charAt(p2)!=mistype.charAt(p2-1)) return false;
                p2++;
            }
        }
        while (p2<mistype.length()){
            if(mistype.charAt(p2)!=mistype.charAt(p2-1)) return false;
            p2++;
        }
        return true;
    }
}
