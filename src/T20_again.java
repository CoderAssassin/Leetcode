import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:00 18-7-13
 * palindrome-partitioning：二刷
 **/
public class T20_again {

    ArrayList<ArrayList<String>> res=new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String s) {

        if (s.equals("")||s==null)
            return res;
        dfs(s,new ArrayList<>());
        return res;
    }

    public void dfs(String s,ArrayList<String> cur){

        if (s.equals("")){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i=0;i<s.length();i++){
            String str=s.substring(0,i+1);
            if (isPalindrome(str)){
                cur.add(str);
                dfs(s.substring(i+1,s.length()),cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start=0,end=s.length()-1;
        while (start<end){
            if (s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        T20_again t=new T20_again();
        String s="aab";
        ArrayList<ArrayList<String>> res=t.partition(s);
        for (ArrayList<String> cur:res){
            for (String str:cur){
                System.out.print(str+",");
            }
            System.out.println();
        }
    }
}
