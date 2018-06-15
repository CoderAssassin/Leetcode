import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:39 18-6-15
 * combination-sum：我的解法
 * 思路：dfs
 **/
public class T111 {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        ArrayList<Integer> cur=new ArrayList<>();
        find(candidates,target,cur,0,0);
        return res;
    }

    private void find(int[] candidates,int target,ArrayList<Integer> cur,int sum,int start){

        if (sum>target)
            return;

        ArrayList<Integer> now=new ArrayList<>(cur);

        if (sum==target){
            res.add(now);
            return;
        }

        for (int i=start;i<candidates.length;i++){

            if (sum+candidates[i]>target)
                break;
            now.add(candidates[i]);
            sum+=candidates[i];
            find(candidates,target,now,sum,i);
            sum-=candidates[i];
            now.remove(now.size()-1);
        }
    }

    public static void main(String[] args){
        T111 t=new T111();
        int[] candidates=new int[]{2,3,6,7};
        ArrayList<ArrayList<Integer>> res=t.combinationSum(candidates,7);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
