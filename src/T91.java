/**
 * @Author:Aliyang
 * @Data: Created in 下午8:10 18-6-12
 * spiral-matrix-ii：我的解法
 * 思路：设定方向变量，每次跑一趟，顺时针旋转
 **/
public class T91 {

    public int[][] generateMatrix(int n) {

        if (n==0)
            return new int[n][n];

//        设置上下左右边界
        int bound_top=-1;
        int bound_bottom=n;
        int bound_left=-1;
        int bound_right=n;

//        设置方向，1右2下3左4上
        int director=1;

        int count=0;//计数

        int[][] res=new int[n][n];

        while (count<n*n){

            for (int i=bound_left+1;i<bound_right&&director==1;i++){//从左到右
                res[bound_top+1][i]=++count;
            }
            bound_top++;
            director=2;

            for (int i=bound_top+1;i<bound_bottom&&director==2;i++){//从上到下
                res[i][bound_right-1]=++count;
            }
            bound_right--;
            director=3;

            for (int i=bound_right-1;i>bound_left&&director==3;i--){//从右到左
                res[bound_bottom-1][i]=++count;
            }
            bound_bottom--;
            director=4;

            for (int i=bound_bottom-1;i>bound_top&&director==4;i--){//从下到上
                res[i][bound_left+1]=++count;
            }
            bound_left++;
            director=1;

        }
        return res;
    }

    public static void main(String[] args){
        T91 t=new T91();
        int[][] res=t.generateMatrix(3);
        for (int i=0;i<res.length;i++){
            for (int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }
    }
}
