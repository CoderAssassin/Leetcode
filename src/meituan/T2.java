package meituan;

import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:11 18-9-6
 **/
public class T2 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int t=sc.nextInt();
            int[] nums=new int[n];

            for (int i=0;i<n;i++)
                nums[i]=sc.nextInt();

            int res=0;
            Map<Integer,Integer> map=new HashMap<>();

            for (int i=0;i<n;i++){
                int j=k+i-1;
                int max=0;
                for (int m=i;m<n&&m<=j;m++){
                    if (map.containsKey(nums[m])){
                        int now=map.get(nums[m])+1;
                        map.put(nums[m],now);
                        if (now>max)
                            max=now;
                    }else {
                        map.put(nums[m],1);
                    }
                }
                if (max>=t)
                    res++;
                map.clear();
            }
            System.out.println(res);
        }
    }
}
