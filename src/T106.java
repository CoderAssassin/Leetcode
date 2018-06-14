/**
 * @Author:Aliyang
 * @Data: Created in 上午10:38 18-6-14
 * wildcard-matching：别人解法
 **/
public class T106 {

//    思路一：主要是对*号的处理，设置回溯位置
//    public boolean isMatch(String s, String p) {
//
//        int i=0,j=0;//索引
//        int i_recall=0,j_recall=-1;//回溯点
//        while (i<s.length()){
//            if (j<p.length()&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j))){//出现相等或者?直接往后
//                i++;
//                j++;
//            }else if (j<p.length()&&p.charAt(j)=='*'){//p出现*的时候，先设置回溯点，用p后边的子串与s中元素继续匹配
//                i_recall=i;
//                j_recall=j++;
//            }else if (j_recall!=-1){//回溯，说明p前面有*，但是当前位置和s的不匹配，那么用*匹配s的当前位置，s后移，j回到回溯点
//                j=j_recall+1;
//                i_recall++;
//                i=i_recall;
//            }else return false;
//        }
//        while (j<p.length()&&p.charAt(j)=='*')//结尾还有*那么去掉
//            j++;
//        return j==p.length();
//    }

//    思路二：使用递归，效率低
    boolean isMatch(String s,String p,int l,int r){
        if (r==p.length())//终止条件，p串到达尾
            return l==s.length();
        if (p.charAt(r)=='*'){//当p的r位置为*
            while (r<p.length()&&p.charAt(r)=='*')//应付连续几个*的情况，直到当前位置不为*
                r++;
            while (l<s.length()){
                if (isMatch(s,p,l,r))//递归匹配
                    return true;
                l++;//若没匹配那么继续s中的下一个位置开始进行匹配
            }
            return isMatch(s,p,l,r);
        }else if (l<s.length()&&(p.charAt(r)=='?'||s.charAt(l)==p.charAt(r)))//非*情况
            return isMatch(s,p,l+1,r+1);
        return true;
    }

//    思路三：改进思路二，动态规划
    public boolean isMatch(String s,String p){

        int m=s.length();
        int n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];//表示s到i,p到j是否匹配
        dp[0][0]=true;
        for (int j=1;j<=n;j++)
            dp[0][j]=dp[0][j-1]&&p.charAt(j-1)=='*';//判断是否从开始就有*，有的话设为true
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='?')//正常匹配
                    dp[i][j]=dp[i-1][j-1];
                else if (p.charAt(j-1)=='*')//p中当前位置为*
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];//前一个表示s的子串和p的到j的匹配的话，那么肯定匹配，因为s的当前的数和*匹配；后边表示s的当前串和p的子串
//                若已经匹配上，那么就肯定能匹配，若没有那么肯定不行，即使当前p为*
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args){
        T106 t=new T106();
        String s="aab";
        String p="c*a*b";
        System.out.println(t.isMatch(s,p));
    }
}
