import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 上午11:02 18-6-10
 * subsets：别人解法
 * 思路：动态规划
 **/
public class T71 {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {

        if (S.length==0)
            return res;

        Arrays.sort(S);
        ArrayList<Integer> cur=new ArrayList<>();
        for (int j=0;j<=S.length;j++)//循环子串的长度，从0到S.lengh
            trace(S,j,0,cur);
        return res;
    }

    /**
     *
     * @param S
     * @param k 子串的长度
     * @param start 数组S的下标开始位置
     * @param cur
     */
    private void trace(int[] S,int k,int start,List<Integer> cur){

        if (k<0)
            return;
        else if (k==0)//添加空
            res.add(new ArrayList<>(cur));
        else {
            for (int i=start;i<S.length ;i++){
                cur.add(S[i]);
                trace(S,k-1,i+1,cur);//继续添加子串的下一个数
                cur.remove(cur.size()-1);//回溯
            }
        }

    }

    public static void main(String[] args){
        T71 t=new T71();
        int[] S=new int[]{1,2,3};
        ArrayList<ArrayList<Integer>> res=t.subsets(S);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
