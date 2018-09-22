package zhaoshangyinhang;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:51 18-9-16
 **/
public class T2 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] dp=new int[n+1];
            dp[1]=1;
            dp[2]=2;
            for (int i=3;i<=n;i++)
                dp[i]=dp[i-1]+dp[i-2];
            System.out.println(dp[n]);
        }
    }
}
