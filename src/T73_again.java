/**
 * @Author:Aliyang
 * @Data: Created in 下午4:35 18-7-18
 * minimum-window-substring：二刷
 **/
public class T73_again {

    public String minWindow(String S, String T) {

        if (S.length()<T.length())
            return "";

        int window=Integer.MAX_VALUE;
        int[] character=new int[128];//所有的字符

        for (int i=0;i<T.length();i++){//记录T中的字符
            character[T.charAt(i)]++;
        }

        int begin=0,end=0,minIndex=0;//窗口的首尾和窗口最小的时候的初始位置
        int remain=T.length();//剩余还没有包括的T中字符数

        while (end<S.length()){

            if (character[S.charAt(end++)]-- >0){//若end所在的位置是T中的字符
                remain--;
            }

            while (remain==0){//当T中的字符都已经包含了以后，开始移动begin指针
                if (end-begin<window){//更新窗口大小
                    minIndex=begin;
                    window=end-minIndex;
                }
                if (character[S.charAt(begin++)]++==0){//若begin所在的位置的字符是T中的字符
                    remain++;
                }
            }
        }
        return window==Integer.MAX_VALUE?"":S.substring(minIndex,minIndex+window);
    }
}
