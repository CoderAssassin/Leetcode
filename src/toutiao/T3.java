package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:09 18-8-12
 **/
public class T3 {

    private static final int v=10000000;
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] x=new int[n];
        int[] y=new int[n];

        int sumx=0;
        for (int i=0;i<n;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
            sumx+=x[i];
        }

        int[][] dp=new int[sumx+1][sumx+1];
        for (int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],v);
        for (int i=0;i<n;i++){
           for (int j=sumx;j>=0;j--){
               for (int k=sumx;k>=0;k--){
                   int t=-1;
                   if (j-x[i]>0&&dp[j-x[i]][k]!=v)
                       t=Math.max(t,dp[j-x[i]][k]);
                   if (k-x[i]>=0&&dp[j][k-x[i]]!=v)
                       t=Math.max(t,dp[j][k-x[i]]);
                   if (t!=-1)
                       t+=y[i];
                   if (t!=-1){
                       if (dp[j][k]==v)
                           dp[j][k]=t;
                       else dp[j][k]=Math.max(dp[j][k],t);
                   }
               }
           }
       }
       int max=0;
       for (int i=0;i<=sumx;i++){
           if (dp[i][i]!=Integer.MAX_VALUE)
               max=Math.max(max,dp[i][i]);
       }
        System.out.println(max);
    }
}
