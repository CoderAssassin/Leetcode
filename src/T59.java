/**
 * @Author:Aliyang
 * @Data: Created in 上午9:43 18-6-9
 * decode-ways:我的解法
 **/
public class T59 {

//    思路一:递归,超时
//    int res=0;
//    public int numDecodings(String s) {
//        if (s.length()==0)
//            return 0;
//        traverse(s,0);
//        return res;
//    }
//
//    private void traverse(String s,int start){
//
//        if (start>=s.length()){
//            res++;
//            return;
//        }
//
//        for (int i=start;i<=start+1&&i<s.length();i++) {
//            int number = Integer.valueOf(s.substring(start, i + 1));
//            if (number >= 1 && number <= 26) {
//                traverse(s, i + 1);
//            } else return;
//        }
//    }

//    思路二:动态规划,dp[i]表示到当前位置(包括)一共有多少种,若当前位置和前面位置组成的数合理,那么就是说i和i-1组成一个数,那么
//    这样的组合看dp[i-2]是多少,注意这里要判断前面一个数是否是0,是0的话不能组成两位数;若不是0,那么不拿当前数和前面的数组合,那么
//    一共有dp[i-1]个组合,所以dp[i]=dp[i-2]+dp[i-1],若当前位置是0,前面不为0,那么只能当前位置和前面的位置组合,那么有dp[i]=dp[i-2];
    public int numDecodings(String s) {
        if (s.length()==0)
            return 0;
        char first=s.charAt(0);
        if (first=='0')
            return 0;
        if (s.length()==1){
            return 1;
        }

        int[] dp=new int[s.length()+1];
        dp[0]=1;
        if (first!='0')
            dp[1]=1;
        else dp[1]=0;

        for (int i=2;i<s.length()+1;i++){
            int num=Integer.valueOf(s.substring(i-2,i));
            if (num>=1&&num<=26&&s.charAt(i-2)!='0'){
                if (s.charAt(i-1)!='0')
                    dp[i]=dp[i-2]+dp[i-1];
                else dp[i]=dp[i-2];
            }else {
                if (s.charAt(i-1)=='0')
                    return 0;
                else dp[i]=dp[i-1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        T59 t=new T59();
        String s="27";
        System.out.println(t.numDecodings(s));
    }
}
