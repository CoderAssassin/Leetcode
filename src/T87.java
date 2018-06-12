/**
 * @Author:Aliyang
 * @Data: Created in 下午4:54 18-6-12
 * unique-paths-ii：我的解法
 * 思路：dp[i][j]表示到(i,j)的路径数，当上和左都是1的时候，设为0
 **/
public class T87 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length==0)
            return 0;

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if (obstacleGrid[m-1][n-1]==1)
            return 0;

        int[][] dp=new int[m+1][n+1];

        boolean row=false;//判断第一行是否前面已经出现过1，出现过那么后边的都为0
        boolean col=false;//判断第一列是否前面已经出现过1

        for (int i=1;i<=m;i++){//初始化第一列的值
            if (obstacleGrid[i-1][0]==1)
                col=true;
            if (col==true)
                dp[i][1]=0;
            else dp[i][1]=1;
        }
        for (int i=1;i<=n;i++){//初始化第一行的值
            if (obstacleGrid[0][i-1]==1)
                row=true;
            if (row==true)
                dp[1][i]=0;
            else dp[1][i]=1;
        }

        for (int i=2;i<=m;i++){
            for (int j=2;j<=n;j++){
                if (obstacleGrid[i-2][j-1]!=1&&obstacleGrid[i-1][j-2]!=1)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                else if (obstacleGrid[i-2][j-1]==1&&obstacleGrid[i-1][j-2]==1)
                    dp[i][j]=0;
                else if (obstacleGrid[i-2][j-1]==1)
                    dp[i][j]=dp[i][j-1];
                else if (obstacleGrid[i-1][j-2]==1)
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args){
        T87 t=new T87();

        int[][] obstacleGrid=new int[2][];
//        obstacleGrid[0]=new int[]{0,0,0};
//        obstacleGrid[1]=new int[]{0,1,0};
//        obstacleGrid[2]=new int[]{0,0,0};
        obstacleGrid[0]=new int[]{0,0};
        obstacleGrid[1]=new int[]{0,1};
        System.out.println(t.uniquePathsWithObstacles(obstacleGrid));

    }
}
