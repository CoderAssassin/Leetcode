import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:57 18-6-16
 * substring-with-concatenation-of-all-words：别人解法
 * 思路：用一个map计算L中各个单词的次数，然后遍历S中每个合理的i位置(即i开始后边的子串长度必须大于等于L的所有单词和)，然后每次从S中
 * 取L中每个单词长的子串，判断是否是单词并且该单词出现次数合理(出现次数不能超了counts中的计数)，是的话加入该单词
 **/
public class T120_1 {

    public ArrayList<Integer> findSubstring(String S, String[] L) {

        Map<String,Integer> counts=new HashMap<>();//存储L中每个单词出现的次数
        for (String word:L){
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }

        int n=S.length(),num=L.length,len=L[0].length();
        ArrayList<Integer> indexes=new ArrayList<>();
        for (int i=0;i<n-num*len+1;i++){
            Map<String,Integer> seen=new HashMap<>();//存储i为起点的字符串里指定单词的次数
            int j=0;//表示单词数目，只有当j==num时，才找到了所有单词
            for (;j<num;j++){
                String word=S.substring(i+j*len,i+j*len+len);//S中当前要判断的单词
                if (counts.containsKey(word)){
                    if (seen.containsKey(word)) {
                        seen.put(word, seen.get(word) + 1);
                    } else {
                        seen.put(word, 1);
                    }
                    if (seen.get(word)>counts.get(word))//如果此单词出现次数超出，则i位置不合法
                        break;
                }
                else break;//如果此单词不存在于counts里，i位置不合法
            }
            if (j==num)
                indexes.add(i);
        }
        return indexes;
    }

    public static void main(String[] args){
        T120_1 t=new T120_1();
        String S="barfoothefoobarman";
        String[] L=new String[]{"foo", "bar"};
        ArrayList<Integer> res=t.findSubstring(S,L);
        for (Integer a:res)
            System.out.print(a+",");

    }
}
