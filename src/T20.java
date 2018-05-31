import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-31 下午10:44
 * palindrome-partitioning：我的解法
 */
public class T20 {

    public ArrayList<ArrayList<String>> partition(String s) {
        if (s.length()==0||s==null)
            return new ArrayList<ArrayList<String>>();

        ArrayList<ArrayList<String>> res=new ArrayList<>();
        ArrayList<String> current=new ArrayList<>();
        part(s,res,current);

        return res;
    }

    //    判断是否是回环字符串
    private boolean isPalindrome(String s){

        int start=0;
        int end=s.length()-1;

        while (start<end){
            if (s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    private void part(String s,ArrayList<ArrayList<String>> res,ArrayList<String> cur){

        if (s.equals("")){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i=1;i<=s.length();i++){
            String tmp=s.substring(0,i);
            if (isPalindrome(tmp)){
                cur.add(tmp);
                part(s.substring(i,s.length()),res,cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args){
        T20 t=new T20();
        String s="aab";
        ArrayList<ArrayList<String>> res=t.partition(s);
        for (int i=0;i<res.size();i++){
            ArrayList<String> tmp=res.get(i);
            for (int j=0;j<tmp.size();j++){
                System.out.println(tmp.get(j));
            }
        }
    }
}
