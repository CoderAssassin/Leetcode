/**
 * @Author:Aliyang
 * @Data: Created in 下午2:27 18-7-13
 * palindrome-partitioning-ii：二刷
 **/
public class T19_again {

    public int minCut(String s) {

        if (s.equals("")||s==null||s.length()==1)
            return 0;

        int[] dp=new int[s.length()];//记录0-i的子字符串的最小切割数

        for (int i=1;i<s.length();i++){
            dp[i]=isPalindrome(s.substring(0,i+1))?0:i;
            if (dp[i]==0)
                continue;
            for (int j=1;j<=i;j++){
                if (isPalindrome(s.substring(j,i+1)))
                    dp[i]=Math.min(dp[i],dp[j-1]+1);
                else dp[i]=Math.min(dp[i],dp[j-1]+i-j+1);
            }
        }
        return dp[s.length()-1];
    }

    private boolean isPalindrome(String s){
        int start=0,end=s.length()-1;
        while (start<end){
            if (s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        T19_again t=new T19_again();
        String s="bb";
        System.out.println(t.minCut(s));
    }
}
