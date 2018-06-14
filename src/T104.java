import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:39 18-6-14
 * permutations：我的解法
 * 思路：dfs，差点超时
 **/
public class T104 {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        if (num.length==0)
            return res;
        ArrayList<Integer> cur=new ArrayList<>();
        boolean[] visit=new boolean[num.length];
        recur(num,visit,cur,0);
        return res;
    }

    private void recur(int[] num,boolean[] visit,ArrayList<Integer> cur,int count){

        ArrayList<Integer> now=new ArrayList<>(cur);

        if (count==num.length){
            res.add(now);
            return;
        }

        for (int i=0;i<num.length;i++){//这里每次都要重新循环，复杂度过高
            if (!visit[i]){
                visit[i]=true;
                now.add(num[i]);
                count++;
                recur(num,visit,now,count);
                now.remove(now.size()-1);
                count--;
                visit[i]=false;
            }
        }
    }

    public static void main(String[] args){
        T104 t=new T104();
        int[] num=new int[]{1,2,3};
        ArrayList<ArrayList<Integer>> res=t.permute(num);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
