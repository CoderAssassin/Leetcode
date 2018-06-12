/**
 * @Author:Aliyang
 * @Data: Created in 下午4:55 18-6-12
 * unique-paths：我的解法
 * 思路：动态规划，dp[i][j]表示到(i,j)有多少种解法,dp[i][j]=dp[i-1][j]+dp[i][j-1]
 **/
public class T88 {

    public int uniquePaths(int m, int n) {

        if (m==0&&n==0)
            return 0;

        int[][] dp=new int[m+1][n+1];

        for (int i=1;i<=m;i++)
            dp[i][1]=1;
        for (int i=1;i<=n;i++)
            dp[1][i]=1;

        for (int i=2;i<=m;i++){
            for (int j=2;j<=n;j++)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }

        return dp[m][n];
    }

    public static void main(String[] args){
        T88 t=new T88();
        System.out.println(t.uniquePaths(1,2));
    }
}
