import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:50 18-6-17
 * letter-combinations-of-a-phone-number：我的解法
 * 思路：dfs
 **/
public class T131 {

    public ArrayList<String> letterCombinations(String digits) {

        Map<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        char[] c=digits.toCharArray();
//        Arrays.sort(c);

        ArrayList<String> res=new ArrayList<>();
        dfs(c,0,"",res,map,digits.length());
        return res;
    }

    private void dfs(char[] c,int index,String cur,ArrayList<String> res,Map<Integer,String> map,int n){

        if (index==n){
            res.add(cur);
            return;
        }
        int num=c[index]-'0';
        if (!(num>=2&&num<=9))
            return;
        String letters=map.get(num);

        for (int i=0;i<letters.length();i++){
            cur+=letters.charAt(i);
            dfs(c,index+1,cur,res,map,n);
            cur=cur.substring(0,cur.length()-1);
        }
    }

    public static void main(String[] args){
        T131 t=new T131();
        String digit="23";
        ArrayList<String> res=t.letterCombinations(digit);
        for (String s:res)
            System.out.print(s+",");
    }
}
