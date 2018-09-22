import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:56 18-8-4
 * 面试动归题：连续N个物品，A[i]是对应物品价格，每次买一个物品，买的物品不能相邻，首尾也不能相邻，求买的物品最大的价格
 **/
public class test {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }

        int[] dp=new int[n+1];
        int[] dp1=new int[n+1];
        int max=0;
//        第一天不买
        for (int i=2;i<=n;i++){
            if (A[i-1]>max){
                if (dp[i-1]<dp[i-2]+A[i-1]){
                    dp[i]=dp[i-2]+A[i-1];
                    max=A[i-1];
                }else {
                    dp[i]=dp[i-1];
                }
            }
            else dp[i]=dp[i-1];
        }
        dp1[1]=A[0];
        max=A[0];
//        第一天买
        for (int i=2;i<=n-1;i++){
            if (A[i-1]>max){
                if (dp1[i-1]<dp1[i-2]+A[i-1]){
                    dp1[i]=dp1[i-2]+A[i-1];
                    max=A[i-1];
                }else {
                    dp1[i]=dp1[i-1];
                }
            }else {
                dp1[i]=dp1[i-1];
            }
        }
        dp1[n]=dp1[n-1];
        System.out.println(Math.max(dp[n],dp1[n]));
    }
}
