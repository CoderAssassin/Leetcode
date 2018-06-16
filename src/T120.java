import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:07 18-6-16
 * substring-with-concatenation-of-all-words：我的解法
 * 思路：先dfs枚举所有可能的L的字符组合，然后使用kmp算法从S中找到第一次出现的起始位置，但是超时了。。。。。。。。
 **/
public class T120 {

    public ArrayList<Integer> findSubstring(String S, String[] L) {

        ArrayList<Integer> res=new ArrayList<>();
        if (L.length==0)
            return res;
        StringBuilder cur=new StringBuilder();
        boolean[] visit=new boolean[L.length];
        dfs(S,L,cur,0,res,visit);
        return res;
    }

    private void dfs(String S,String[] L,StringBuilder cur,int count,ArrayList<Integer> res,boolean[] visit){

        if (count==L.length){
            int index=-1;
            if ((index=kmp(S,cur.toString()))!=-1){
                res.add(index);
                return;
            }
        }

        Set<String> set=new HashSet<>();

        for (int i=0;i<L.length;i++){
            if (!visit[i]&&!set.contains(visit[i])){
                set.add(L[i]);
                cur.append(L[i]);
                count++;
                visit[i]=true;
                dfs(S,L,cur,count,res,visit);
                visit[i]=false;
                count--;
                cur.delete(cur.length()-L[i].length(),cur.length());
            }
        }
    }

//    kmp算法
    private int kmp(String str,String ptr){
        int slen=str.length();
        int plen=ptr.length();
        int[] next=catNext(ptr);//计算next数组
        int k=-1;
        for (int i=0;i<slen;i++){

            while (k>-1&&ptr.charAt(k+1)!=str.charAt(i))//ptr和str的当前位置不匹配，往前回溯直到找到前缀子串最后一个位置和当前str位置i的字符相等的前缀子串
                k=next[k];
            if (ptr.charAt(k+1)==str.charAt(i))//当str的i处和模式串的k+1位置相等，那么前缀子串往后一位
                k=k+1;
            if (k==plen-1){//k到达模式串的末尾，说明k和目前str的子串完全匹配上
                return i-plen+1;
            }
        }
        return -1;
    }

//    计算next数组
    private int[] catNext(String str){

        int len=str.length();
        int[] next=new int[len];
        next[0]=-1;
        int k=-1;
        for (int i=1;i<=len-1;i++){

            while (k>-1&&str.charAt(k+1)!=str.charAt(i)){//找到前缀子串最后一个数和新来的索引位置i处的数相等的前锥子穿
                k=next[k];
            }
            if (str.charAt(k+1)==str.charAt(i)){//如果新的数和当前的k相等，那么前缀子串k+1，说明当前k+1长的前缀子串和后缀子串匹配
                k=k+1;
            }
            next[i]=k;
        }
        return next;
    }

    public static void main(String[] args){
        T120 t=new T120();
        String S="barfoothefoobarman";
        String[] L=new String[]{"foo", "bar"};
        ArrayList<Integer> res=t.findSubstring(S,L);
        for (Integer a:res)
            System.out.print(a+",");
    }
}
