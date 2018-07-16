/**
 * @Author:Aliyang
 * @Data: Created in 下午4:32 18-7-15
 * distinct-subsequences：二刷
 **/
public class T36_again {

    public int numDistinct(String S, String T) {

        if (S==null||S.length()==0||T==null||T.length()==0)
            return 0;

        int[][] dp=new int[T.length()+1][S.length()+1];//T的前i个和S的前j的组合数
        for (int i=0;i<S.length();i++)//T为空串时，所以的S位置都可以匹配
            dp[0][i]=1;
        for (int i=1;i<=T.length();i++){
            for (int j=1;j<=S.length();j++){
                if (T.charAt(i-1)!=S.charAt(j-1))//如果当前字符不匹配，那么为当前字符和S的前面子串的匹配数
                    dp[i][j]=dp[i][j-1];
                else dp[i][j]=dp[i][j-1]+dp[i-1][j-1];//当前字符和S的子串匹配+当前字符和S的当前串匹配
            }
        }
        return dp[T.length()][S.length()];
    }

//    先写个递归
//    private int dfs(String S,String T){
//
//        if (S.length()==0)
//            return 1;
//        if (S.length()>T.length())
//            return 0;
//        int count=0;
//        char c=S.charAt(0);
//        for (int i=0;i<T.length();i++){
//            if (T.charAt(i)==c){
//                count+=dfs(S.substring(1,S.length()),T.substring(i+1,T.length()));
//            }
//        }
//        return count;
//    }

    public static void main(String[] args){
        T36_again t=new T36_again();
        String S="ccc";
        String T="c";
        System.out.println(t.numDistinct(S,T));

    }
}
