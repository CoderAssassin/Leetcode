import java.util.Arrays;

/**
 * @Author:Aliyang
 * @Data: Created in 下午12:30 18-6-9
 * scramble-string:别人解法
 **/
public class T62 {

//    思路一:就是s1和s2是scramble的话，那么必然存在一个在s1上的长度l1，将s1分成s11和s12两段，同样有s21和s22.
// 那么要么s11和s21是scramble的并且s12和s22是scramble的；要么s11和s22是scramble的并且s12和s21是scramble的
//    public boolean isScramble(String s1, String s2) {
//        int len1=s1.length();
//        int len2=s2.length();
//        if (len1!=len2)
//            return false;
//        if (len1==1)//如果长度为1则为判断是否相等
//            return s1.equals(s2);
//
////        判断两个字符串的字符是否一一对应
//        char[] chars1=new char[len1];
//        s1.getChars(0,len1,chars1,0);
//        Arrays.sort(chars1);
//        char[] chars2=new char[len1];
//        s2.getChars(0,len2,chars2,0);
//        Arrays.sort(chars2);
//        if (!(new String(chars1).equals(new String(chars2))))
//            return false;
//
//        for (int i=1;i<len1;i++){//表示切点位置
//            String s1left=s1.substring(0,i);
//            String s1right=s1.substring(i,len1);
//            String s2left=s2.substring(0,i);
//            String s2right=s2.substring(i,len1);
//
////            s1的左边和s2的左边比较,s1的右边和s2的右边比较
//            if (isScramble(s1left,s2left)&&isScramble(s1right,s2right))
//                return true;
////            将s2的左右换一下再比较
//            s2right=s2.substring(len1-i,len1);
//            s2left=s2.substring(0,len1-i);
//
//            if (isScramble(s1left,s2right)&&isScramble(s1right,s2left))
//                return true;
//        }
//        return false;
//    }

//    思路二:动态规划,三维状态变量.dp[i][j][n]表示s1从i开始,s2从j开始长度为n的字符串是否互为scramble
    public boolean isScramble(String s1, String s2) {
        if (s1.length()!=s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int n=s1.length();

        boolean[][][] dp=new boolean[n+1][n+1][n+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j][1]=(s1.charAt(i)==s2.charAt(j))?true:false;
            }
        }

        for (int len=2;len<=n;len++){//长度从0到n
            for (int i=0;i<=n-len;i++){//s1的开始位置
                for (int j=0;j<=n-len;j++){//s2的开始位置
                    for (int k=1;k<len;k++){//切点
                        if ((dp[i][j][k]&&dp[i+k][j+k][len-k])||(dp[i+k][j][len-k]&&dp[i][j+len-k][k])){
                            dp[i][j][len]=true;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

}
