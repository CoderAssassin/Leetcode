import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:10 18-6-17
 * 4sum：我的解法
 **/
public class T132 {

//    思路一：我的思路，dfs，超时
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        if (num.length<4)
            return res;

        Arrays.sort(num);
        dfs(num,target,0,new ArrayList<>(),0,0);
        return res;
    }

    private void dfs(int[] num,int target,int index,ArrayList<Integer> cur,int sum,int count){

        if (count==4){
            if (sum==target){
                if (!res.contains(new ArrayList<>(cur)))
                    res.add(new ArrayList<>(cur));
            }
            else return;
        }

        ArrayList<Integer> now=new ArrayList<>(cur);
        Set<Integer> set=new HashSet<>();

        for (int i=index;i<num.length;i++){
            if (!set.contains(num[i])){
                if (sum+num[i]<=target){
                    set.add(num[i]);
                    sum+=num[i];
                    now.add(num[i]);
                    count++;
                    dfs(num,target,i+1,now,sum,count);
                    count--;
                    now.remove(now.size()-1);
                    sum-=num[i];
                }else break;
            }
        }
    }

    public static void main(String[] args){
        T132 t=new T132();
        int[] num=new int[]{1,0,-1,0,-2,2};
        ArrayList<ArrayList<Integer>> res=t.fourSum(num,0);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
