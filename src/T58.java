import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:Aliyang
 * @Data: Created in 下午11:43 18-6-8
 * subsets-ii:别人解法
 * 思路:递归,回溯,每次循环确定当前位置的数,从上一次确定的数的位置往后一个数开始循环,然后递归当前确定的数下一个数开始
 * 确定接下来一个位置的数,当当前位置的循环出现两个数一样的时候,忽略该数
 **/
public class T58 {

        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num == null || num.length <= 0)
            return listAll;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);

        Findsubset(num, 0, list);

        return listAll;
    }

        public void Findsubset(int[] set, int start, ArrayList<Integer> list) {
        listAll.add(new ArrayList<>(list));

        for (int i = start; i < set.length; i++) {
            if (i > start && set[i] == set[i - 1])
                continue;
            list.add(set[i]);
            Findsubset(set, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        T58 t=new T58();
        int[] num=new int[]{1,2,2};
        ArrayList<ArrayList<Integer>> res=t.subsetsWithDup(num);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
