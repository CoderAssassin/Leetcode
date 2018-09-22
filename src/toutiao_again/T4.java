package toutiao_again;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:58 18-8-25
 **/
public class T4 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int[] caiyang=new int[n];
        int maxValue=0;
        for (int i=0;i<n;i++){
            caiyang[i]=sc.nextInt();
            if (caiyang[i]>maxValue)
                maxValue=caiyang[i];
        }
        System.out.println(find(caiyang,t,maxValue));
    }

    private static int find(int[] arr,int t,int maxValue){

        int length;
        if (t!=1)
            length=2*arr.length;
        else length=arr.length;
        int arrLen=arr.length;
        int[] dp=new int[length];

        for (int i=0;i<length;i++)
            dp[i]=1;

        for (int i=1;i<length;i++){
            int reali=i%arrLen;
            for (int j=0;j<i;j++){
                int realj=j%arrLen;
                if (arr[reali]>=arr[realj]&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int maxCount=0;
        if (t!=1){
            for (int i=0;i<arr.length;i++)
                if (arr[i]==maxValue)
                    maxCount++;
        }

        int max=dp[0];
        for (int i=1;i<length;i++)
            if (max<dp[i])
                max=dp[i];
        if (t!=1)
            return max+(t-2)*maxCount;
        else return max;
    }
}
