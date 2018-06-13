import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 上午11:10 18-6-13
 * spiral-matrix：我的解法
 * 思路:类似T91
 **/
public class T96 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res=new ArrayList<>();

        if (matrix.length==0)
            return res;

        int m=matrix.length;
        int n=matrix[0].length;

//        设置上下左右边界
        int bound_top=-1;
        int bound_bottom=m;
        int bound_left=-1;
        int bound_right=n;

//        设置方向，1右2下3左4上
        int director=1;

        int count=0;//计数

        while (count<m*n){

            for (int i=bound_left+1;i<bound_right&&director==1&&count<m*n;i++){//从左到右
                res.add(matrix[bound_top+1][i]);
                count++;
            }
            bound_top++;
            director=2;

            for (int i=bound_top+1;i<bound_bottom&&director==2&&count<m*n;i++){//从上到下
                res.add(matrix[i][bound_right-1]);
                count++;
            }
            bound_right--;
            director=3;

            for (int i=bound_right-1;i>bound_left&&director==3&&count<m*n;i--){//从右到左
                res.add(matrix[bound_bottom-1][i]);
                count++;
            }
            bound_bottom--;
            director=4;

            for (int i=bound_bottom-1;i>bound_top&&director==4&&count<m*n;i--){//从下到上
                res.add(matrix[i][bound_left+1]);
                count++;
            }
            bound_left++;
            director=1;
        }
        return res;
    }

    public static void main(String[] args){
        T96 t=new T96();
        int[][] matrix=new int[1][];
        matrix[0]=new int[]{2,3};
//        matrix[1]=new int[]{4,5,6};
//        matrix[2]=new int[]{7,8,9};

        ArrayList<Integer> res=t.spiralOrder(matrix);
        for (Integer a:res)
            System.out.print(a+",");
    }
}
