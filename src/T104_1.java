import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:51 18-6-14
 * permutations：别人解法
 * 思路：总的思路和我差不多，就是遍历每一位上的数时，并不是像我一样都要从头到尾判断一遍所有的数
 **/
public class T104_1 {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        if (num.length==0||num==null)
            return res;

        Arrays.sort(num);//先排个序

        ArrayList<Integer> list=new ArrayList<>();
        solve(list,num);
        return res;
    }

    private void solve(ArrayList<Integer> list,int[] nums){

        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
                solve(list,nums);
                list.remove(list.size()-1);
            }
        }
    }
}
