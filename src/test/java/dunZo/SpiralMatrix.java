package dunZo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    /*
        spiral matrix
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    @Test
    public void test1(){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        Assert.assertEquals(printSpiralMatrix(matrix), Arrays.asList(1,2,3,6,9,8,7,4,5));
    }

    private List<Integer> printSpiralMatrix(int[][] matrix) {
        List<Integer>list=new ArrayList<>();
        if (matrix.length==0) return list;
        int rowBegin=0, rowEnd=matrix.length-1;
        int columnBegin=0, columnEnd=matrix[0].length-1;
        while (rowBegin<=rowEnd && columnBegin<=columnEnd){

            for (int i=columnBegin;i<=columnEnd;i++){
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for (int i=rowBegin;i<=rowEnd;i++){
                list.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            if(rowBegin<=rowEnd){
                for (int i=columnEnd;i>=columnBegin;i--){
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(columnBegin<=columnEnd){
                for (int i=rowEnd;i>=rowBegin;i--){
                    list.add(matrix[i][columnBegin]);
                }
            }
            columnBegin++;

        }

return list;

    }
}
