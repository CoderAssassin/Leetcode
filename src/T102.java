/**
 * @Author:Aliyang
 * @Data: Created in 上午8:48 18-6-14
 * rotate-image：我的解法
 * 思路：首先，每次需要变动的有n/2个圈数(当n为奇数的时候中间的只有一个数不用换)，然后每次对两行四列各交换一个数，总共需要交换n-1-i次，具体交换有公式
 **/
public class T102 {

    public void rotate(int[][] matrix) {
        if (matrix.length==0)
            return;
        int n=matrix.length;
        for (int i=0;i<n/2;i++){//圈数
            for (int j=i;j<n-1-i;j++){//交换的圈
                int tmp=matrix[i][j];

                matrix[i][j]=matrix[n-1-j][i];//左下换到左上
                matrix[n-1-j][i]=matrix[n-i-1][n-1-j];//右下换到左下
                matrix[n-i-1][n-1-j]=matrix[j][n-i-1];//右上换到右下
                matrix[j][n-i-1]=tmp;//左上换到右上
            }
        }
    }

    public static void main(String[] args){
        T102 t=new T102();
        int[][] matrix=new int[4][];
        matrix[0]=new int[]{1,2,3,4};
        matrix[1]=new int[]{4,5,6,7};
        matrix[2]=new int[]{7,8,9,10};
        matrix[3]=new int[]{10,11,12,13};
        t.rotate(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
    }
}
