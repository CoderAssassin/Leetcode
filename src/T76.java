/**
 * @Author:Aliyang
 * @Data: Created in 下午5:37 18-6-11
 * set-matrix-zeroes：别人解法
 * 思路：用第一行第一列来表示是否该行或者该列有0，首先记录第一行和第一列是否有零，需要最后处理。然后先遍历一波记录有零的行和列，然后更新
 **/
public class T76 {

    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        boolean row_flag=false,col_flag=false;//记录第一行和第一列是否有0

//        判断第一行和第一列是否有零，防止被覆盖
        for (int i=0;i<row;i++)
            if (matrix[i][0]==0){
            col_flag=true;
            break;;
            }
        for (int i=0;i<col;i++){
            if (matrix[0][i]==0){
                row_flag=true;
                break;
            }
        }

//        遍历矩阵，用第一行和第一列记录0的位置
        for (int i=1;i<row;i++)
            for (int j=1;j<col;j++)
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }

//        根据记录清零
        for (int i=1;i<row;i++)
            for (int j=1;j<col;j++)
                if (matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;

//        最后处理第一行
        if (row_flag)
            for (int i=0;i<col;i++)
                matrix[0][i]=0;
        if (col_flag)
            for (int i=0;i<row;i++)
                matrix[i][0]=0;
    }
}
