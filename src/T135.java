import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:Aliyang
 * @Data: Created in 下午5:47 18-6-17
 * longest-common-prefix：我的解法
 * 思路：使用kmp算法
 **/
public class T135 {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length==0)
            return "";
        if (strs.length==1)
            return strs[0];

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        String ptr=strs[0];
        for (int i=1;i<strs.length;i++){
            String str=strs[i];
            for (int j=0;j<ptr.length();j++){
                int index=-1;
                if ((index=kmp(str,ptr.substring(0,j+1)))!=0){
                    ptr=ptr.substring(0,j);
                    break;
                }
            }
        }
        return ptr;
    }

    private int kmp(String str,String ptr){
        int slen=str.length();
        int plen=ptr.length();
        int[] next=find_next(ptr);//计算next数组
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

    private int[] find_next(String str){

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
        T135 t=new T135();
        String[] strs=new String[]{"c","acc","ccc"};
        System.out.println(t.longestCommonPrefix(strs));
    }
}
