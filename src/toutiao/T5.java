package toutiao;

import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:52 18-8-12
 **/
public class T5 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N,M;
        N=sc.nextInt();
        M=sc.nextInt();

        List<Integer[]> list=new ArrayList<>();

        for (int i=0;i<N;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            if (start>end)
                end+=M;
            Integer[] tmp={start,end};
            list.add(tmp);
        }

        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1]-o2[1];
            }
        });

        int ans=0;
        int r=0;//前一个直播的结束时间
        for (int i=0;i<N;i++){
            Integer[] tmp=list.get(i);
            if (tmp[0]>M)//不能超出总的时间
                continue;
            if (tmp[0]>=r){//开始时间在前一个直播的结束时间后
                ans++;
                r=tmp[1];
            }else {
                if (tmp[1]<r)//关键的贪心一步没想到，若当前的直播的结束时间比前一次直播的结束时间早，那么当前活动代替前一个活动
                    r=tmp[1];
            }
        }
        System.out.println(ans);
    }

}
