import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-6-2 下午1:38
 * triangle：我的解法
 * 思路：利用递归，左边一路和右边一路的最小值和当前的加起来
 */
public class T31 {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

        if (triangle==null||triangle.get(0)==null)
            return 0;

        return dfs(triangle,0,0,0);
    }

    private int dfs(ArrayList<ArrayList<Integer>> triangle,int cur,int row,int col){

        if (row>=triangle.size()){
            return cur;
        }

        int left=dfs(triangle,cur,row+1,col);//左下一路的最大值
        int right=dfs(triangle,cur,row+1,col+1);//右下一路的最大值

        cur=cur+Math.min(left,right)+triangle.get(row).get(col);

        return cur;
    }

    public static void main(String[] args){
        T31 t=new T31();
        ArrayList<ArrayList<Integer>> triangle=new ArrayList<>();
        ArrayList<Integer> ro1=new ArrayList<>();
        ro1.add(2);
        triangle.add(ro1);
        ArrayList<Integer> ro2=new ArrayList<>();
        ro2.add(3);
        ro2.add(4);
        triangle.add(ro2);
        System.out.println(t.minimumTotal(triangle));


    }
}
