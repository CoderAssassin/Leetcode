import java.util.*;

/**
 * @author aliyang
 * @date 18-6-1 下午9:09
 * word-ladder：别人解法
 * 思路：利用BFS
 */
public class T25 {

    public int ladderLength(String start, String end, HashSet<String> dict) {

        Set<String> wordSet=new HashSet<>(dict);//所有可能的单词
        Set<String> visited=new HashSet<>();//访问过的单词
        visited.add(start);
        int dist=1;//距离

        while (!visited.contains(end)){
            Set<String> temp=new HashSet<>();//保存新的一层的关联单词集
            for (String word:visited){
                for (int i=0;i<word.length();i++){//遍历单词的每一位
                    char[] chars=word.toCharArray();
                    for (int j=(int)'a';j<(int)'z'+1;j++){//遍历每个字母
                        chars[i]=(char)j;//替换掉i位置上的字母，生成新的字符串
                        String newWord=new String(chars);
                        if (wordSet.contains(newWord)){//如果新的单词在字典中存在
                            temp.add(newWord);//新的一层的单词加入
                            wordSet.remove(newWord);//从字典中将已经访问的单词删除
                        }
                    }
                }
            }
            dist+=1;//访问完一层，长度+1
            if (temp.size()==0)//说明没有新生成的节点,按理说应该是到达end单词的
                return 0;
            visited=temp;//更新最新一层邻接单词
        }
        return dist;
    }
}
