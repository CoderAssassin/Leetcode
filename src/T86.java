/**
 * @Author:Aliyang
 * @Data: Created in 下午4:23 18-6-12
 * minimum-path-sum：我的解法
 * 思路：dp[i][j]表示到(i,j)为止的最短路径，状态选择有两个，一个是dp[i-1][j]，一个是dp[i][j-1]，取最小
 **/
public class T86 {

    public int minPathSum(int[][] grid) {

        if (grid.length==0||grid==null)
            return -1;

        int[][] dp=new int[grid.length+1][grid[0].length+1];//表示左上到网格(i,j)的最短路径
        dp[1][1]=grid[0][0];

//        分别先计算第1行和第1列的dp值
        for (int i=2;i<=grid.length;i++)
            dp[i][1]=dp[i-1][1]+grid[i-1][0];
        for (int i=2;i<=grid[0].length;i++)
            dp[1][i]=dp[1][i-1]+grid[0][i-1];

        for (int i=2;i<=grid.length;i++){
            for (int j=2;j<=grid[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }

    public static void main(String[] args){
        T86 t=new T86();
        int[][] grid=new int[2][];
//        grid[0]=new int[]{1,2,3,4};
//        grid[1]=new int[]{2,3,4,5};
//        grid[2]=new int[]{3,4,5,6};
//        grid[3]=new int[]{4,5,6,7};
        grid[0]=new int[]{1,2};
        grid[1]=new int[]{1,1};
        System.out.println(t.minPathSum(grid));
    }
}
