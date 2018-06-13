import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:35 18-6-13
 * n-queens：我的解法
 * 思路：
 * 规则：同一行同一列同一斜行都不能有重复的Q，使用dfs，定义3个数组分别用来剪枝同一行同一列和同一斜线上是否已经有Q，其中斜线分为左上到右下（规律是同一斜线上的
 * 数，x-y+n-1相等）和右上到左下(同一斜线上x+y相等)
 **/
public class T99 {


    ArrayList<String[]> res=new ArrayList<>();
    public ArrayList<String[]> solveNQueens(int n) {

        if (n==0)
            return res;

        String[] cur=new String[n];
        boolean[] col_visit=new boolean[n];//判断列是否有子
        boolean[] dia_left=new boolean[2*n-1];//判断左上往右下斜的对角线上是否有子
        boolean[] dia_right=new boolean[2*n-1];//判断右上往左下斜的对角线上是否有子
        find(cur,col_visit,dia_left,dia_right,0);

        return res;
    }

    private void find(String[] cur,boolean[] col_visit,boolean[] dia_left,boolean[] dia_right,int row){

        if (row==col_visit.length){
            res.add(cur);
            return;
        }

        String[] newCur=new String[col_visit.length];
        for (int i=0;i<row;i++)
            newCur[i]=new String(cur[i]);
        StringBuilder sb=new StringBuilder();

        for (int i=0;i<col_visit.length;i++){
            if (!col_visit[i]&&!dia_left[row-i+col_visit.length-1]&&!dia_right[row+i]){//判断位置是否合理
                for (int j=0;j<i;j++)
                    sb.append('.');
                sb.append('Q');
                for (int j=i+1;j<col_visit.length;j++)
                    sb.append('.');
//                更新剪枝数组
                col_visit[i]=true;
                dia_left[row-i+col_visit.length-1]=true;
                dia_right[row+i]=true;

                newCur[row]=sb.toString();
                find(newCur,col_visit,dia_left,dia_right,row+1);
//                回溯剪枝数组
                col_visit[i]=false;
                dia_left[row-i+col_visit.length-1]=false;
                dia_right[row+i]=false;
                sb=new StringBuilder();
            }
        }
    }

    public static void main(String[] args){
        T99 t=new T99();
        ArrayList<String[]> res=t.solveNQueens(9);
        for (String[] cur:res){
            for (String s:cur){
                System.out.println(s);
            }
            System.out.println();
        }

    }
}
