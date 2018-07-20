/**
 * @Author:Aliyang
 * @Data: Created in 下午2:45 18-7-20
 * set-matrix-zeroes：二刷
 **/
public class T76_again {

    public void setZeroes(int[][] matrix) {

        boolean row=false,col=false;//第一行第一列是否本来就有０
        int rows=matrix.length,cols=matrix[0].length;
        for (int i=0;i<cols;i++){//第一行
            if (matrix[0][i]==0){
                row=true;
                break;
            }
        }
        for (int i=0;i<rows;i++){//第一列
            if (matrix[i][0]==0){
                col=true;
                break;
            }
        }

        for (int i=1;i<rows;i++){//设置０的状态标记
            for (int j=1;j<cols;j++){
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i=1;i<rows;i++){
            for (int j=1;j<cols;j++){
                if (matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if (row==true){
            for (int i=0;i<cols;i++){
                matrix[0][i]=0;
            }
        }
        if (col==true){
            for (int i=0;i<rows;i++){
                matrix[i][0]=0;
            }
        }
    }

    public static void main(String[] args){
        T76_again t=new T76_again();
        int[][] matrix={{1,1,2,0},{1,1,0,1},{2,1,0,1}};
        t.setZeroes(matrix);
        System.out.println(1);
    }
}
