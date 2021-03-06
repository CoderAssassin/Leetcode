/**
 * @Author:Aliyang
 * @Data: Created in 下午3:08 18-7-20
 * edit-distance：二刷
 **/
public class T77_again {

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];//word1前i个字符和word2前j个字符的最小操作次数

//        初始化
        for (int i = 1; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int i = 1; i <= word2.length(); i++)
            dp[0][i] = i;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;//添加，删除，替换
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
