/**
 * @Author:Aliyang
 * @Data: Created in 下午3:07 18-6-11
 * minimum-window-substring：别人解法
 * 思路：
 *
1) begin开始指向0， end一直后移，直到begin - end区间包含T中所有字符。
记录窗口长度d
2) 然后begin开始后移移除元素，直到移除的字符是T中的字符则停止，此时T中有一个字符没被
包含在窗口，
3) 继续后移end，直到T中的所有字符被包含在窗口，重新记录最小的窗口d。
4) 如此循环知道end到S中的最后一个字符。
时间复杂度为O(n)
 **/
public class T73 {

    public String minWindow(String S, String T) {

        int lens=S.length();
        int lent=T.length();
        if (lent>lens)
            return "";

//        统计T中各个字符出现的次数
        int[] map=new int[128];
        for (int i=0;i<T.length();i++)
            map[T.charAt(i)]++;

        int begin=0;//窗口首位
        int end=0;
        int d=Integer.MAX_VALUE;//窗口大小
        int counter=T.length();//记录T中未被窗口包含的字符数量
        int head=0;//记录最终结果的头

        while (end<S.length()){
//            map[] > 0 说明该字符在T中出现，counter-- 表示对应的字符被包含在了窗口，counter--, 如果s中的字符没有在T中出现，则map[]中对应的字符-1后变为负值
            if (map[S.charAt(end++)]-- >0)
                counter--;

            while (counter==0){
                if (end-begin<d){
                    d=end-(head=begin);
                }
//                begin开始后移，继续向后寻找。如果begin后移后指向的字符在map中==0，表示是在T中出现的，如果没有出现，map[]中的值会是负值。
                if (map[S.charAt(begin++)]++ ==0)
                    counter++;
            }
        }
        return d==Integer.MAX_VALUE?"":S.substring(head,head+d);
    }
}
