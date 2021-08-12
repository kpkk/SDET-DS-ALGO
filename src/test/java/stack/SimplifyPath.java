package stack;

import org.junit.Assert;
import org.junit.Test;

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
    //   /etc/../bin//home/./  --> /etc/bin/home

    @Test
    public void test1(){
        String s="/home/";
        Assert.assertEquals(simplifyPath(s),"/home");
    }
    @Test
    public void test2(){
        String s="/etc/../bin//home/./";
        Assert.assertEquals(simplifyPath(s),"/bin/home");
    }

    /*
    Approach: using stack
    Solution:-
    - Initialize a stack of character type
    - Split the string using the delimiter /
    - traverse the array from start till the end
    - if the String at the current index is either empty or . , just continue
    - if the string at the current index is .. then pop the string
    - else push into the stack
    - while the stack is not empty
        - insert into the stringbuffer at 0 index
        - insert a / at 0 index

     */
    private String simplifyPath(String s) {
       Stack<String> stack=new Stack<>();
        String[] split = s.split("/");
        for (String str:split){
            if(str.isEmpty() || str.equals(".")) continue;
            else if(str.equals("..")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else stack.push(str);
        }
        StringBuffer sb=new StringBuffer();
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        return sb.toString();
    }

}
