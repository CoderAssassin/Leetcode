
/**
 * @Author:Aliyang
 * @Data: Created in 下午1:03 18-6-19
 * longest-palindromic-substring：别人解法
 **/
public class T144 {

//    思路一：分为奇数和偶数两种情况，奇数从每个i往左右两边看是否相等，偶数对当前i和i+1比较，然后往左右两边散开.O(n*n)
//    public String longestPalindrome(String s) {
//        String res="";
//        if (s.length()==1)
//            return s;
//
//        int maxLen=0,curLen=0,start=-1;
//        for (int i=0;i<s.length();i++){
////            奇数
//            int left=i-1,right=i+1;
//            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
//                curLen=right-left;
//                if (curLen>maxLen){
//                    maxLen=curLen;
//                    start=left;
//                }
//                left--;
//                right++;
//            }
////            偶数
//            left=i;
//            right=i+1;
//            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
//
//                curLen=right-left;
//                if (curLen>maxLen){
//                    maxLen=curLen;
//                    start=left;
//                }
//                left--;
//                right++;
//            }
//        }
//        res=s.substring(start,start+maxLen+1);
//        return res;
//    }

//    思路二：马拉车算法.O(n)。有问题
    public String longestPalindrome(String s) {

        if (s.length()==1)
            return s;

//        改造字符串
        String res="$#";//为了防止过界，左边添加一个$
        for (int i=0;i<s.length();i++){
            res+=s.charAt(i);
            res+="#";
        }

        int[] P=new int[res.length()];//P[i]数组，记录当前字符的最长回文串的回文半径
        int mi=0;//当前i的前边的最长回文串的中心
        int right=0;//前边最长回文串的最右端的值
        int maxLen=0,maxPoint=0;//最大回文串长度和记录中心店

        for (int i=1;i<res.length();i++){
            P[i]=right>i?Math.min(P[2*mi-i],right-i):1;//关键

            while (i+P[i]<res.length()&&i-P[i]>=0&&res.charAt(i+P[i])==res.charAt(i-P[i])){//更新P[i]长度
                P[i]++;
            }

            if (right<i+P[i]){//超过之前的最右端，那么改变中心点和对应的最右端
                right=i+P[i];
                mi=i;
            }

            if (maxLen<P[i]){//更新最大回文串的长度，并记下此时的点
                maxLen=P[i];
                maxPoint=i;
            }
        }
        return s.substring((maxPoint-maxLen)/2,maxLen-1);
    }


    public static void main(String[] args){
        T144 t=new T144();
        String s="abba";
        System.out.println(t.longestPalindrome(s));
    }
}
