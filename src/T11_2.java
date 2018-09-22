import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:22 18-9-12
 **/
public class T11_2 {

    public List<String> dfs(String s, Set<String> dict, HashMap<String,ArrayList<String>> map){
        if (map.containsKey(s))//去重，防止前面已经出现过的序列再次出现
            return map.get(s);

        ArrayList<String> res=new ArrayList<>();

        if (s.length()==0){//判断终止条件，s为空了以后说明当次查询终止
            res.add("");
            return res;
        }
        for (String word:dict){//遍历字典的每个单词
            if (s.startsWith(word)){//如果字符串s以某个单词开头，那么继续递归子串
                List<String> sublist=dfs(s.substring(word.length()),dict,map);
                for (String sub:sublist)
                    res.add(word+(sub.isEmpty()?"":" ")+sub);
            }
        }
        map.put(s,res);//设置当前剩余子串的合格序列
        return res;
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        return (ArrayList<String>) dfs(s,dict,new HashMap<>());
    }
}
