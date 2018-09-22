package neteasy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:16 18-8-11
 * 网易笔试第三题：有n个a和m个z的组合，按字典序排序，输出第k个数
 * 别人思路：用dp[i][j]表示i个z和j个a的方案数，因此dp[i][j]=dp[i-1][j]+dp[i][j-1]。考虑第i个
 * 字符，如果该字符选为a，设剩余的a和z的个数分别是p和q，那么若k<=dp[q][p]，那么如果a还有剩余的话当前位置选a，
 * 否则选z，若此时k-=dp[q][p]，因为此时a的方案要去掉
 **/
//public class T3 {
//
//    Set<String> set=new HashSet<>();
//    int kNow=0;
//    boolean flag=false;
//    public void dfs(int n,int m,int curN,int curM,int k,String cur){
//        if (n==curN&&m==curM)
//            return;
//
//        if (flag)
//            return;
//
////        for (int i=curM+curN;i<=m+n;i++){
////            if (flag)
////                return;
//            String tmp=cur+"a";
//            if (curN<n&&!set.contains(tmp)){
//                curN++;
//                set.add(tmp);
//                if (curN==n&&curM==m)
//                    kNow++;
//
//                if (kNow==k){
//                    System.out.println(tmp);
//                    flag=true;
//                    return;
//                }
//                dfs(n,m,curN,curM,k,tmp);
//                curN--;
//            }
//            if (flag)
//                return;
//            String tmp1=cur+"z";
//            if (curM<m&&!set.contains(tmp1)){
//                curM++;
//                set.add(tmp1);
//                if (curN==n&&curM==m)
//                    kNow++;
//                if (kNow==k){
//                    flag=true;
//                    System.out.println(tmp1);
//                    return;
//                }
//                dfs(n,m,curN,curM,k,tmp1);
//                curM--;
////            }
//        }
//    }
//
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int n,m,k;
//        n=sc.nextInt();
//        m=sc.nextInt();
//        k=sc.nextInt();
//        T3 t=new T3();
//
//        String cur="";
//        for (int i=0;i<n;i++)
//            cur+="a";
//        for (int i=0;i<m;i++)
//            cur+="z";
//
//        for
//
//        t.dfs(n,m,0,0,k,"");
//    }
//}

public class T3{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n,m,k;
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        int[][] dp=new int[m+1][n+1];
        char[] str=new char[m+n];
        dp[0][0]=1;
        for (int i=1;i<=n;i++){
            dp[1][i]=i+1;
            dp[0][i]=1;
        }
        for (int i=1;i<=m;i++){
            dp[i][1]=i+1;
            dp[i][0]=1;
        }
        for (int i=2;i<=m;i++){
            for (int j=2;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                if (dp[i][j]>1000000000)
                    dp[i][j]=1000000000;
            }
        }
        if (k>dp[m][n])
            System.out.println(-1);
        else {
            int a=n,b=m;
            for (int i=0;i<n+m;i++){
                if (a>0&&k<=dp[b][a-1]){
                    str[i]='a';
                    a--;
                }else {
                    if (a>0)
                        k-=dp[b][a-1];
                    str[i]='z';
                    b--;
                }
            }
            System.out.println(str);
        }
    }
}
