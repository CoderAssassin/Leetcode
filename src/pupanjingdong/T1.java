package pupanjingdong;

import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:09 18-9-9
 **/
public class T1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int k=1;k<=T;k++){
            int N=sc.nextInt();
            int M=sc.nextInt();
            Map<Integer,Set<Integer>> map=new HashMap<>();

            for (int i=0;i<M;i++){
                int X=sc.nextInt();
                int Y=sc.nextInt();
                if (!map.containsKey(X)){
                    Set<Integer> tmpSet=new HashSet<>();
                    tmpSet.add(Y);
                    map.put(X,tmpSet);
                }else {
                    Set<Integer> tmpSet=map.get(X);
                    tmpSet.add(Y);
                    map.put(X,tmpSet);
                }
            }

            List<Map.Entry<Integer,Set<Integer>>> lists=new ArrayList<>(map.entrySet());
            Collections.sort(lists, new Comparator<Map.Entry<Integer, Set<Integer>>>() {
                @Override
                public int compare(Map.Entry<Integer, Set<Integer>> o1, Map.Entry<Integer, Set<Integer>> o2) {
                    return o1.getValue().size()-o2.getValue().size();
                }
            });

            int len_Now=-1;
            int start=-1;
            boolean isComplete=true;
            outer:
            for (int i=0;i<lists.size();i++){
                Map.Entry<Integer,Set<Integer>> entry=lists.get(i);
                int size=entry.getValue().size();
                if (size!=len_Now){

                    for (int j=i-1;j>=start&&j>=0;j--){
                        if (len_Now+lists.get(j).getValue().size()!=N){
                            isComplete=false;
                            break outer;
                        }
                    }
                    len_Now=size;
                    start=i;
                }else {
                    len_Now++;
                    for (int j=i-1;j>=start;j--){
                        if (lists.get(j).getValue().contains(entry.getKey())||
                                entry.getValue().contains(lists.get(j).getKey())){
                            isComplete=false;
                            break outer;
                        }
                    }
                }
            }
            Map.Entry<Integer,Set<Integer>> entry=lists.get(lists.size()-1);
            for (int j=lists.size()-1;j>=start;j--){
                if (len_Now+lists.get(j).getValue().size()!=N){
                    isComplete=false;
                    break;
                }
            }
            for (int j=lists.size()-2;j>=start;j--){
                if (lists.get(j).getValue().contains(entry.getKey())||
                        entry.getValue().contains(lists.get(j).getKey())){
                    isComplete=false;
                    break;
                }
            }

            if (isComplete){
                System.out.println("Yes");
            }else
                System.out.println("No");
        }
    }
}
