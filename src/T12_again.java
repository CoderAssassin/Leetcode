import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:21 18-7-6
 * word-break：二刷
 **/
public class T12_again {

    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] dp=new boolean[s.length()+1];//表示从0到i的字符串是否是合格的字符串
        dp[0]=true;

        for (int i=1;i<=s.length();i++){
//            从后往前，找到前边是true的位置，判断该位置到当前的子串是否是字典中的单词，直到到达最前端
            for (int j=i-1;j>=0;j--){
                if (dp[j]){//这里用到了前边的状态，体现了动态规划的去重复使用
                    if (dict.contains(s.substring(j,i))){//如果包含，说明到目前位置为止是合理的
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        T12_again t=new T12_again();
//        String s="leetcode";
        String s="a";
        Set<String> dict=new HashSet<>();
//        dict.add("leet");
//        dict.add("code");
        dict.add("a");
        System.out.println(t.wordBreak(s,dict));
    }
}
