import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:38 18-6-15
 * combination-sum-ii：我的解法
 * 思路：类似T111，最后要去重
 **/
public class T110 {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {

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
            if (!res.contains(now))
                res.add(now);
            return;
        }

        for (int i=start;i<candidates.length;i++){

            if (sum+candidates[i]>target)
                break;
            now.add(candidates[i]);
            sum+=candidates[i];
            find(candidates,target,now,sum,i+1);
            sum-=candidates[i];
            now.remove(now.size()-1);
        }
    }

    public static void main(String[] args){
        T110 t=new T110();
        int[] candidates=new int[]{10,1,2,7,6,1,5};
        ArrayList<ArrayList<Integer>> res=t.combinationSum2(candidates,8);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
