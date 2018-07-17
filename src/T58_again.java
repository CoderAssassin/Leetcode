import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:01 18-7-17
 * subsets-ii：二刷
 **/
public class T58_again {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

        if (num==null||num.length==0)
            return res;
        Arrays.sort(num);
        dfs(new ArrayList<Integer>(),num,0);
        return res;
    }

    private void dfs(ArrayList<Integer> cur,int[] num,int start){

        ArrayList<Integer> arr=new ArrayList<>(cur);
        res.add(arr);
        if (start>=num.length){
            return;
        }
        Set<Integer> set=new HashSet<>();//去重

        for (int i=start;i<num.length;i++){
            if (!set.contains(num[i])){
                set.add(num[i]);
                cur.add(num[i]);
                dfs(cur,num,i+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args){
        T58_again t=new T58_again();
        int[] num={4,1,0};
        ArrayList<ArrayList<Integer>> res=t.subsetsWithDup(num);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
