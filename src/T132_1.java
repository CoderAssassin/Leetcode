import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:51 18-6-17
 * 4sum：别人解法
 * 思路：先计算每两个数的和，然后用一个map存储相同值的链表，然后遍历map的数，获取剩余值的可行组，为了保存不重复，只保存a1<b0的数，时间复杂度大概
 * O(n^2logn)
 **/
public class T132_1 {

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        if (num==null||num.length<4)
            return res;

        Arrays.sort(num);

        Map<Integer,ArrayList<Integer[]>> map=new HashMap<>();//保存前两个数的和
//        先计算前两个数的和，添加到hashmap
        for (int i=0;i<num.length-1;i++){
            for (int j=i+1;j<num.length;j++){
                int sum=num[i]+num[j];
                Integer[] pair={i,j};

                if (!map.containsKey(sum))
                    map.put(sum,new ArrayList<Integer[]>());
                map.get(sum).add(pair);
            }
        }

        Set<Integer> keys=map.keySet();
        for (int key:keys){
            List<Integer[]> listA=map.get(key);
            List<Integer[]> listB=map.get(target-key);//剩余的两个数的值的所有两个数的组合

            if (listA!=null&&listB!=null){
                for (Integer[] pairA:listA){
                    int a0=pairA[0],a1=pairA[1];
                    for (Integer[] pairB:listB){
                        int b0=pairB[0],b1=pairB[1];
                        if (a1<b0){//只添加a1<b0的组，防止重复
                            ArrayList<Integer> list=new ArrayList<>();
                            list.add(num[a0]);
                            list.add(num[a1]);
                            list.add(num[b0]);
                            list.add(num[b1]);
                            if (!res.contains(list))
                                res.add(list);
                        }
                    }
                }
            }
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i=0;i<o1.size();i++){
                    int num1=o1.get(i);
                    int num2=o2.get(i);
                    if (num1==num2)
                        continue;
                    else if (num1<num2)
                        return -1;
                    else return 1;
                }
                return 0;
            }
        });
        return res;
    }

    public static void main(String[] args){
        T132_1 t=new T132_1();
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
