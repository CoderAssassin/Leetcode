/**
 * @Author:Aliyang
 * @Data: Created in 上午10:40 18-6-12
 * climbing-stairs：我的解法
 * 思路：动态规划，当前台阶有两种走法，要不跳一步，要不跳两步，所以dp[i]=dp[i-2]+dp[i-1]，斐波那契数列
 **/
public class T79 {

    public int climbStairs(int n) {

        int[] dp=new int[n+1];

        dp[0]=1;
        dp[1]=1;

        for (int i=2;i<=n;i++)
            dp[i]=dp[i-2]+dp[i-1];

        return dp[n];
    }

    public static void main(String[] args){
        T79 t=new T79();
        System.out.println(t.climbStairs(4));

    }
}
