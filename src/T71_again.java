import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author:Aliyang
 * @Data: Created in 下午4:10 18-7-18
 * subsets：二刷
 **/
public class T71_again {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {

        if (S==null||S.length==0)
            return res;
        Arrays.sort(S);
        dfs(S,0,new ArrayList<>());
        if (res.size()>2){
            Collections.sort(res, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    if (o1.size()<o2.size())
                        return -1;
                    if (o2.size()<o1.size())
                        return 1;
                    return String.valueOf(o1).compareTo(String.valueOf(o2));
                }
            });
        }
        return res;
    }

    private void dfs(int[] S,int start,ArrayList<Integer> cur){
        ArrayList<Integer> tmp=new ArrayList<>(cur);
        res.add(tmp);

        if (start>=S.length)
            return;

        for (int i=start;i<S.length;i++){
            cur.add(S[i]);
            dfs(S,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args){
        T71_again t=new T71_again();
        int[] S={1,2};
        ArrayList<ArrayList<Integer>> res=t.subsets(S);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
