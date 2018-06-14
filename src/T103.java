import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:39 18-6-14
 * permutations-ii：我的解法
 * 思路：借用T104的代码，dfs，visite数组判断每个数字是否已经加入过，hashset用来判断当前数字添加是否出现重复
 **/
public class T103 {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        if (num.length==0||num==null)
            return res;

        Arrays.sort(num);//先排个序

        ArrayList<Integer> list=new ArrayList<>();
        boolean[] visit=new boolean[num.length];
        solve(list,num,visit);
        return res;
    }

    private void solve(ArrayList<Integer> list,int[] nums,boolean[] visit){

        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        Set<Integer> set=new HashSet<>();

        for (int i=0;i<nums.length;i++){
            if (!set.contains(nums[i])&&!visit[i]){
                set.add(nums[i]);
                visit[i]=true;
                list.add(nums[i]);
                solve(list,nums,visit);
                list.remove(list.size()-1);
                visit[i]=false;
            }
        }
    }

    public static void main(String[] args){
        T103 t=new T103();
        int[] num=new int[]{1,1};
        ArrayList<ArrayList<Integer>> res=t.permuteUnique(num);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
