/**
 * @author aliyang
 * @date 18-6-6 下午4:51
 * interleaving-string：别人解法
 */
public class T52 {


//    思路一：递归，用三个指针，递归果断超时～～～～～～～
//    public boolean isInterleave(String s1, String s2, String s3) {
//
//        if (s1.length()+s2.length()!=s3.length())
//            return false;
//        return judge(s1,s2,s3,0,0,0);
//    }
//
//    private boolean judge(String s1,String s2,String s3,int s1_index,int s2_index,int s3_index){
//
//        if (s3_index==s3.length()-1)
//            return true;
//
//        if (s1_index<s1.length()&&s1.charAt(s1_index)==s3.charAt(s3_index)){
//            if (judge(s1,s2,s3,s1_index+1,s2_index,s3_index+1))
//                return true;
//        }
//
//        if (s2_index<s2.length()&&s2.charAt(s2_index)==s3.charAt(s3_index)){
//            if (judge(s1,s2,s3,s1_index,s2_index+1,s3_index+1))
//                return true;
//        }
//
//        return false;
//    }

//    思路二：动态规划，别人解法,用dp[i][j]表示从i中取i个，从j中取j个能否组成s3的子串
    public boolean isInterleave(String s1, String s2, String s3) {

        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();

        if (len1+len2!=len3)
            return false;

        char[] c_s1=s1.toCharArray();
        char[] c_s2=s2.toCharArray();
        char[] c_s3=s3.toCharArray();

        boolean[][] dp=new boolean[len1+1][len2+1];//dp[i][j]表示从i中取i个，从j中取j个能否组成s3的子串
        dp[0][0]=true;//从s1中取0个从s2中取0个可以构成空串

//        从s1中取i个，从s2中取0个能否构成s3
        for (int i=1;i<len1+1;i++)
            dp[i][0]=dp[i-1][0]&&(c_s1[i-1]==c_s3[i-1]);

//        从s1中取0个，从s2中取个能否构成s3
        for (int i=1;i<len2+1;i++)
            dp[0][i]=dp[0][i-1]&&(c_s2[i-1]==c_s3[i-1]);

        for (int i=1;i<len1+1;i++)
            for (int j=1;j<len2+1;j++)
                dp[i][j]=(dp[i-1][j]&&(c_s1[i-1]==c_s3[i+j-1]))//当前匹配s1中的字符
                        ||(dp[i][j-1]&&(c_s2[j-1]==c_s3[i+j-1]));//当前匹配s2中的字符

        return dp[len1][len2];
    }

    public static void main(String[] args){
        T52 t=new T52();
        String s1="aabcc";
        String s2="dbbca";
        String s3="aadbbcbcac";
        System.out.println(t.isInterleave(s1,s2,s3));
    }
}
