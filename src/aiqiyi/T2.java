package aiqiyi;

import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:50 18-9-15
 **/
public class T2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            int M=sc.nextInt();
            int P=sc.nextInt();
            int target=-1;
            Map<Integer,Integer> map=new HashMap<>();
            for (int i=1;i<=N;i++){
                int key=sc.nextInt();
                if (i==P)
                    target=i;
                map.put(i,key);
            }
            for (int i=0;i<M;i++){
                String op=sc.next();
                int tmp=sc.nextInt();
                if (op.equals("A"))
                    map.put(tmp,map.get(tmp)+1);
                else map.put(tmp,map.get(tmp)-1);
            }
            List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });

            int res=0;
            int value=Integer.MIN_VALUE;
            for (int i=0;i<list.size();i++){
                int value_now=list.get(i).getValue();
                if (value_now!=value){
                    value=value_now;
                    res=i+1;
                }
                if (list.get(i).getKey().equals(target))
                    break;
            }
            System.out.println(res);
        }
    }
}
