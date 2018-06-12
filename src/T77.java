/**
 * @Author:Aliyang
 * @Data: Created in 上午9:41 18-6-12
 * edit-distance：别人解法
 * 思路：动态规划，dp[i][j]表示word1的前i个和word2的前j个元素的最低字符串变换
 **/
public class T77 {

    public int minDistance(String word1, String word2) {
        if (word1==null&&word2==null)
            return 0;
        if (word1==null||word1.equals(""))
            return word2.length();
        if (word2==null||word2.equals(""))
            return word1.length();

        int[][] dp=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;//都是空串

        for (int i=1;i<=word1.length();i++)//当word2为空串时
            dp[i][0]=i;
        for (int i=1;i<=word2.length();i++)//当word1为空串时
            dp[0][i]=i;

        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1)==word2.charAt(j-1))//当当前的字符相等的时候，那么该字符匹配上，结果为前面字符串的最小匹配
                    dp[i][j]=dp[i-1][j-1];
                else
//                    dp[i-1][j]和dp[i][j-1]和dp[i-1][j-1]表示最后一个字符不匹配的时候，或者删除或者添加或者替换，这样最后要加个1
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
