package practise;

import org.junit.Assert;
import org.junit.Test;

public class FindNextChar {
    /*
     Given a sorted character array and the target find the character, find the next character
    char ch={'b','d','h'} char c=e
     */

    @Test
    public void test(){
        char[] ch={'b','d','h'};
        char c='d';
        Assert.assertEquals(findNextChar(ch,c),'h');
    }

    private char findNextChar(char[] ch, char c) {
        int low=0, high=ch.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(ch[mid]==c && mid!=ch.length-1) return ch[mid+1];
            if(ch[mid]>c && ch[mid-1]<c) return ch[mid];
            if(ch[mid]<c) low=mid+1;
            else high=mid-1;
        }
        return ' ';
    }
}
