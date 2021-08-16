package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalinDromicString {

    @Test
    public void test1(){
        String s="babad";
        Assert.assertEquals(longestPalindrome(s),"bab");
    }
    @Test
    public void test2(){
        String s="cbbd";
        Assert.assertEquals(longestPalindrome(s),"bb");
    }
    @Test
    public void test3(){
        String s="gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv";
        Assert.assertEquals(longestPalindrome(s),"jtdtj");
    }
    @Test
    public void test4(){
        String s="ac";
        Assert.assertEquals(longestPalindrome(s),"a");
    }
    @Test
    public void test5(){
        String s="acccabdhhcchhty";
        Assert.assertEquals(longestPalindrome(s),"hhcchh");
    }

    public String longestPalindrome(String s) {

        /*
        Input- String
        Output- String
        Contraints- No,

        Pseudo code:
        - Initialize a String varibale to hold the output string
        - convert string into char array
        - iterate the char array from start index until end (outer loop)
        - add the character to the output string
        - iterate the array from next index until end (inner loop)
        - add the character at j
            - for every j addition, reverse the string and check if its equal to substring
            - calculate the length of the qualified substring
        - continue the process
        */
        String output="";
        String finalStr="";
        if(s.length()==1)return s;
        int maxLength=Integer.MIN_VALUE;
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            output+=chars[i];
            for(int j=i+1;j<chars.length;j++){
                StringBuffer temp=new StringBuffer();
                output+=chars[j];
                temp.append(output);
                String rev=temp.reverse().toString();
                if(rev.equals(s.substring(i,j+1))){
                    if(rev.length()>maxLength){
                        finalStr= s.substring(i,j+1);
                    }
                    maxLength=Math.max(maxLength,rev.length());
                }
            }
            output="";
        }
        return finalStr.isEmpty()?s.charAt(0)+"":finalStr;
    }
}
