package week4;

import org.junit.Assert;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class CharacterReprogramming {

    /*

     */

    @Test
    public void test1(){
        String str="URDR";
        Assert.assertEquals(getMaxDeletions(str),2);
    }
    @Test
    public void test2(){
        String str="RRRR";
        Assert.assertEquals(getMaxDeletions(str),4);
    }
    @Test
    public void test3(){
        String str="UDRLRRRLLLL";
        Assert.assertEquals(getMaxDeletions(str),1);
    }
    @Test
    public void test4(){
        String str="UDLR";
        Assert.assertEquals(getMaxDeletions(str),0);
    }

    private int getMaxDeletions(String str) {
        int count=0;
        for (int i=0;i<str.charAt(i);i++){
            if(str.charAt(i)=='U' ||str.charAt(i)=='R'){
                count+=1;
            }else{
                count-=1;
            }
            count = Math.abs(count);
        }
        return count==str.length()?0:str.length()-count;
    }






    private String findPath(String str) {
        if(str.length()==1) return str;
        Stack<Character> stack=new Stack<>();
        for (char ch:str.toCharArray()){
            if(ch=='D'&& stack.contains('U') || ch=='U'&& stack.contains('D')){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else
            stack.push(ch);

        }
        StringBuffer sb=new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

/*

ArrayList<Character> list=new ArrayList<>();
        char[] chars = str.toCharArray();
        int counter=0;
        for (char ch:chars){
            if(list.contains('U') && ch=='D'){
                counter-=2;
            }else if(list.contains('D')&& ch=='U'){
                counter-=2;
            }
            else if(list.contains('L')&& ch=='R'){
                counter-=2;
            }
            else if(list.contains('R')&& ch=='L'){
                counter-=2;
            }
            list.add(ch);
            counter++;
        }
        return counter<0?counter*-1:counter;

    }

 */