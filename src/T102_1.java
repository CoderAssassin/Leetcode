/**
 * @Author:Aliyang
 * @Data: Created in 上午9:33 18-6-14
 * rotate-image：别人解法
 * 思路：做两次翻转，先沿右上-左下的对角线翻转，再沿水平中线上下翻转，类似折纸原理
 **/
public class T102_1 {

    public void rotate(int[][] matrix) {
        if (matrix.length==0)
            return;
        int n=matrix.length;
        for (int i=0;i<n;i++){//沿对角线翻转
            for (int j=0;j<n-i;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i]=tmp;
            }
        }
        for (int i=0;i<n/2;i++){
            for (int j=0;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-1-i][j];
                matrix[n-1-i][j]=tmp;
            }
        }
    }
}
