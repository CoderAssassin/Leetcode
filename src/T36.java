/**
 * @author aliyang
 * @date 18-6-3 下午5:06
 * distinct-subsequences：别人解法
 * 思路：题目没看懂，别人的动态规划做法，res[i][j]=(S[i]==T[j]?res[i-1][j-1]:0)+res[i-1][j]，r[i][j]表示S的前i的序列和T的前j的
 * 序列的可行序列
 */
public class T36 {

    public int numDistinct(String S, String T) {

        if (T.length()==0)
            return 1;

        if (S.length()==0)
            return 0;

        int[] res=new int[T.length()+1];
        res[0]=1;
        for (int i=0;i<S.length();i++){
            for (int j=T.length()-1;j>=0;j--){
                res[j+1]=(S.charAt(i)==T.charAt(j)?res[j]:0)+res[j+1];
            }
        }
        return res[T.length()];
    }
}