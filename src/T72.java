import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:44 18-6-11
 * combinations：我的解法
 * 思路：递归dfs，回溯，类似T71
 **/
public class T72 {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

        if (n<k)
            return res;
        ArrayList<Integer> cur=new ArrayList<>();
        find(n,k,cur,1,k);
        return res;
    }

    private void find(int n,int k,ArrayList<Integer> cur,int start,int remind_k){

        ArrayList<Integer> tmp=new ArrayList<>(cur);

        if (remind_k<0)
            return;
        if (remind_k==0){
            res.add(tmp);
            return;
        }

        for (int i=start;i<=n;i++){
            tmp.add(i);
            find(n,k,tmp,i+1,remind_k-1);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args){
        T72 t=new T72();
        ArrayList<ArrayList<Integer>> res=t.combine(4,2);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur)
                System.out.print(a+",");
            System.out.println();
        }
    }
}
