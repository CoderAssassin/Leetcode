import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author aliyang
 * @date 18-5-30 下午2:24
 * word-break-ii：别人解法
 * 思路：dfs，从后往前递归，不知为何从前往后递归会失败
 */
public class T11_1 {

    public ArrayList<String> res=new ArrayList<String>();
    public void dfs(String s,int index,String cur_string,Set<String> dict,int dict_maxlen){
//        如果已经搜索到字符串的头，那么将结果加入结果列表
        if(index==0){
            if(cur_string.length()>0)
                res.add(cur_string.substring(0,cur_string.length()-1));
        }
        for(int i=index;i>=0&&index-i<=dict_maxlen;i--){
//            如果字典包含当前搜到的子串，那么构成新的子串，继续往前dfs
            if(dict.contains(s.substring(i,index))){
                dfs(s,i,s.substring(i,index)+" "+cur_string,dict,dict_maxlen);
            }
        }
    }
    public  ArrayList<String> wordBreak(String s, Set<String> dict) {
//        dfs(s,s.length(),"",dict);
        int dict_maxlen=-1;
        for (String d:dict)
            if (d.length()>dict_maxlen)
                dict_maxlen=d.length();
        dfs(s,s.length(),"",dict,dict_maxlen);
        return res;
    }
//
//    public void dfs(String s,int index,String cur_string,Set<String> dict,int dict_maxlen){
//
//        if (index==s.length()){
//            if (cur_string.length()>0){
//                res.add(cur_string.trim());
//                return;
//            }
//        }
////        for (int i=index;i<s.length();i++){
////            if (dict.contains(s.substring(index,i+1)))
////                dfs(s,i+1,cur_string+" "+s.substring(index,i+1),dict);
////        }
//        for (int i=index;i<s.length()&&(i-index)<dict_maxlen;i++){
//            if (dict.contains(s.substring(index,i+1)))
//                dfs(s,i+1,cur_string+" "+s.substring(index,i+1),dict,dict_maxlen);
//        }
//    }

    public static void main(String[] args){
        String s="a";
        Set<String> dict=new HashSet<>();
        dict.add("a");
//        dict.add("b");
//        dict.add("cat");
//        dict.add("cats");
//        dict.add("and");
//        dict.add("sand");
//        dict.add("dog");

        T11_1 t=new T11_1();
        ArrayList<String> res=t.wordBreak(s,dict);

        for (String r:res)
            System.out.println(r.length()+" "+r);
    }
}
