/**
 * @Author:Aliyang
 * @Data: Created in 下午2:35 18-6-13
 * n-queens-ii：我的解法
 * 思路：和T99一样，就是不需要返回字符结果，更简单
 **/
public class T98 {

    int count=0;
    public int totalNQueens(int n) {
        if (n==0)
            return 0;

        boolean[] col_visit=new boolean[n];//判断列是否有子
        boolean[] dia_left=new boolean[2*n-1];//判断左上往右下斜的对角线上是否有子
        boolean[] dia_right=new boolean[2*n-1];//判断右上往左下斜的对角线上是否有子
        find(col_visit,dia_left,dia_right,0);

        return count;
    }

    private void find(boolean[] col_visit,boolean[] dia_left,boolean[] dia_right,int row){

        if (row==col_visit.length){
            count++;
            return;
        }

        for (int i=0;i<col_visit.length;i++){
            if (!col_visit[i]&&!dia_left[row-i+col_visit.length-1]&&!dia_right[row+i]){//判断位置是否合理

//                更新剪枝数组
                col_visit[i]=true;
                dia_left[row-i+col_visit.length-1]=true;
                dia_right[row+i]=true;

                find(col_visit,dia_left,dia_right,row+1);
//                回溯剪枝数组
                col_visit[i]=false;
                dia_left[row-i+col_visit.length-1]=false;
                dia_right[row+i]=false;
            }
        }
    }

    public static void main(String[] args){
        T98 t=new T98();
        System.out.println(t.totalNQueens(1));
    }
}
