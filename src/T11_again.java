import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:42 18-7-5
 * word-break-ii：二刷
 **/
public class T11_again {

    ArrayList<String> res=new ArrayList<>();
    ArrayList<String> mid=new ArrayList<>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {

        if (s.length()<=0)
            return res;

        boolean[][] dp=new  boolean[s.length()][s.length()];//一维表示从位置i开始，二维表示单词的长度-1

//        从后往前找出，从每个一维位置开始，往后能形成一个合理单词的位置
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                if (dict.contains(s.substring(i,j+1)))
                    dp[i][j-i]=true;
            }
        }

        find(s,s.length()-1,dp);
        Collections.reverse(res);//因为本题顺序原因，倒序
        return res;
    }

    /**
     *
     * @param s 字符串
     * @param len 字符串最后一个字符的位置
     */
    private void find(String s,int len,boolean[][] dp){
        if (len>=0){
            for (int i=0;i<=len;i++){//取的长度
                if (dp[i][len-i]){//如果从当前位置i到len的子串是个单词，因为是从后往前判断，这里的len-i表示单词长度-1
                    mid.add(s.substring(i,len+1));//添加从i到len的单词
                    find(s,i-1,dp);
                    mid.remove(mid.size()-1);
                }
            }
            return;
        }else {
            StringBuilder str=new StringBuilder();
            for (int i=mid.size()-1;i>=0;i--){//因为是从后往前加的，所以这里要从后边开始遍历
                str.append(mid.get(i));
                if (i>0)
                    str.append(" ");
            }
            res.add(str.toString());
        }
    }

    public static void main(String[] args){
        T11_again t=new T11_again();
//        String s="catsanddog";
        String s="a";
        Set<String> dict=new HashSet<>();
//        dict.add("cat");
//        dict.add("cats");
//        dict.add("and");
//        dict.add("sand");
//        dict.add("dog");
        dict.add("a");
        ArrayList<String> res=t.wordBreak(s,dict);
        for (String str:res)
            System.out.println(str);
    }
}
