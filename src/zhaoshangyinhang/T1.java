package zhaoshangyinhang;

import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:50 18-9-16
 **/
public class T1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            List<Integer> weikou=new ArrayList<>();
            List<Integer> size=new ArrayList<>();
            String tmp1=sc.nextLine();
            String[] tmp11=tmp1.split(" ");
            for (int i=0;i<tmp11.length;i++)
                weikou.add(Integer.parseInt(tmp11[i]));

            String tmp2=sc.nextLine();
            String[] tmp22=tmp2.split(" ");
            for (int i=0;i<tmp22.length;i++)
                size.add(Integer.parseInt(tmp22[i]));

            Collections.sort(weikou);
            Collections.sort(size);

            int res=0;
            boolean flag=false;
            for (int i=0;i<weikou.size();i++){
                int tmp=weikou.get(i);
                flag=false;
                for (int j=size.size()-1;j>=0;j--){
                    if (size.get(j)>=tmp){
                        flag=true;
                        size.remove(j);
                        break;
                    }
                    if (size.get(j)<tmp)
                        break;
                }
                if (flag)
                    res++;
            }
            System.out.println(res);
        }
    }
}
