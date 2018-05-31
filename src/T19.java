/**
 * @author aliyang
 * @date 18-5-31 下午3:50
 * palindrome-partitioning-ii：别人解法
 * 思路：
 * dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。
 *  分几种情况：
 *   1.初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，dp[i] = 0(表示不需要分割)；否则，dp[i] = i（表示至多分割i次）;
 *   2.对于任意大于1的i，如果s.substring(j,i+1)(j<=i,即遍历i之前的每个子串)是回文时，dp[i] = min(dp[i], dp[j-1]+1);
 *   3.如果s.substring(j,i+1)(j<=i)不是回文时，dp[i] = min(dp[i],dp[j-1]+i+1-j);
 **/
public class T19 {

    public int minCut(String s) {
        if (s.equals("")||s==null||s.length()==1)
            return 0;

        int[] dp=new int[s.length()];//记录0-i(包含i)的字符串的最小切割数
        dp[0]=0;//开始的一个字符是不需要切割的

//        设置从0到i(包含i)的最大切割数
        for (int i=1;i<s.length();i++){

            dp[i]=isPalindrome(s.substring(0,i+1))?0:i;//如果从0开始到i(包含i)是回文，那么i及之前的设为0，否则设为i,表示至多分割i次
            if (dp[i]==0)
                continue;
//            遍历i之前的每个回文串
            for (int j=1;j<=i;j++){
                if (isPalindrome(s.substring(j,i+1)))
                    dp[i]=Math.min(dp[i],dp[j-1]+1);//回文串之前的分割次数加上回文串的1
                else dp[i]=Math.min(dp[i],dp[j-1]+i+1-j);
            }

        }
        return dp[s.length()-1];
    }

//    判断是否是回环字符串
    private boolean isPalindrome(String s){

        int start=0;
        int end=s.length()-1;

        while (start<end){
            if (s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        T19 t=new T19();
        String s="ab";

        System.out.println(t.minCut(s));

    }
}
