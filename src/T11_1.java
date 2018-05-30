import java.util.ArrayList;
import java.util.Set;

/**
 * @author aliyang
 * @date 18-5-30 下午2:24
 * word-break-ii：别人解法
 * 思路：dfs，从后往前递归，不知为何从前往后递归会失败
 */
public class T11_1 {

    public ArrayList<String> res=new ArrayList<String>();
    public void dfs(String s,int index,String cur_string,Set<String> dict){
//        如果已经搜索到字符串的头，那么将结果加入结果列表
        if(index<=0){
            if(cur_string.length()>0)
                res.add(cur_string.substring(0,cur_string.length()-1));
        }
        for(int i=index;i>=0;i--){
//            如果字典包含当前搜到的子串，那么构成新的子串，继续往前dfs
            if(dict.contains(s.substring(i,index))){
                dfs(s,i,s.substring(i,index)+" "+cur_string,dict);
            }
        }
    }
    public  ArrayList<String> wordBreak(String s, Set<String> dict) {
        dfs(s,s.length(),"",dict);
        return res;
    }

}
