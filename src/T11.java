import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author aliyang
 * @date 18-5-30 下午1:44
 * word-break-ii：别人解法
 * 思路一：暴力求解，用到递归，一次遍历每个字符，记录遍历时的词，若包含在字典中，那么加入新的项中
 * 该方法会超时！！！！！
 */
public class T11 {

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s.equals("")||s==null)
            return new ArrayList<String>();

        ArrayList<String> res=new ArrayList<>();
        helper(s,dict,0,"",res);
        return res;
    }

    private void helper(String s,Set<String> dict,int start,String item,ArrayList<String> res){

//        一趟搜到底了，将形成的item加入结果
        if (start>=s.length()){
            res.add(item);
            return;
        }

        StringBuilder sb=new StringBuilder();
        for (int i=start;i<s.length();i++){
            sb.append(s.charAt(i));
//            如果该单词被字典包含
            if (dict.contains(sb.toString())){
                item=item.length()>0?item+" "+sb.toString():sb.toString();
                helper(s,dict,i+1,item,res);
            }
        }
    }

    public static void main(String[] args){
        T11 t=new T11();
        String s="catsanddog";
        Set<String> dict=new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<String> res=t.wordBreak(s,dict);
        for (String r:res)
            System.out.println(r);
    }
}
