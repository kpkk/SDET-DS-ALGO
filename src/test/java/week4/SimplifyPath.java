package week4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {

    /*

    Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system,
    convert it to the simplified canonical path.
In a Unix-style file system, a period '.' refers to the current directory, a double period '..'
refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:
The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

Example 1:
Input: path = "/home/"  / h o m e /
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory

     */


    /*
    Solution:-
    -  Initialize a stack and an arrayList
    -  Convert the string into a String array (split)
    -  Start pushing each character into stack until the end
            - if the character is . or empty ignore
            - if the character .. pop it
    - Convert the stack into a stringBuilder


        sb.insert(0,stack.pop());
            sb.insert(0,"/");
     */

    @Test
    public void test1(){
        String str="/home//foo";
        Assert.assertEquals(simplifypath(str),"/home/foo");
    }
    @Test
    public void test2(){
        String str="/../";
        Assert.assertEquals(simplifypath(str),"/");
    }
    @Test
    public void test3(){
        String str="/root//../users/.//desktop";
        Assert.assertEquals(simplifypath(str),"/root/users/desktop");
    }

    private String simplifypath(String str) {
        Stack<String>stack=new Stack<>();
        String[] split = str.split("/");
        for (String s:split){
            if(s.isEmpty() || s.equals(".")) continue;
            else if(s.equals("..")){
                if(!s.isEmpty())
                stack.pop();
            }
            else
                stack.push(s);
        }
        StringBuffer sb=new StringBuffer();
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");

           // sb.append("/").append(stack.pop());
        }
       return sb.toString();
    }
}
