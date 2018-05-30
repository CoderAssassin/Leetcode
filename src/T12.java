import java.util.HashSet;
import java.util.Set;

/**
 * @author aliyang
 * @date 18-5-30 下午2:57
 * word-break：我的解法
 * 思路：动态规划
 */
public class T12 {

    public boolean wordBreak(String s, Set<String> dict) {

        if (s.equals("")||s==null)
            return false;

        boolean[] dp=new boolean[s.length()+1];//dp[i]表示字符串0-i是否可分
        dp[0]=true;//0处为第一个可切割点

        for (int i=1;i<=s.length();i++){//从前往后遍历新字符
            for (int j=i-1;j>=0;j--){//从后往前判断是否和前边的现有的切割能形成新的切割
                if (dp[j]&&dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }else {
                    dp[i]=false;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        T12 t=new T12();
        String s="leetcode";
        Set<String> dict=new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(t.wordBreak(s,dict));
    }
}
