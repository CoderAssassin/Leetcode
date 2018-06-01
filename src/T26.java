/**
 * @author aliyang
 * @date 18-6-1 下午9:39
 * valid-palindrome：我的解法
 */
public class T26 {

    public boolean isPalindrome(String s) {

        if (s.equals(""))
            return true;
        if (s==null)
            return false;
        int start=0;
        int end=s.length()-1;

        while (start<=end){
            char startC=s.charAt(start);
            char endC=s.charAt(end);
            while (!(startC>='a'&&startC<='z'||startC>='0'&&startC<='9'||startC>='A'&&startC<='Z')&&start<s.length()){
                start++;
                if (start<s.length()){
                    startC=s.charAt(start);
                }
            }
            while (!(endC>='a'&&endC<='z'||endC>='0'&&endC<='9'||endC>='A'&&endC<='Z')&&end>=0){
                end--;
                if (end>=0){
                    endC=s.charAt(end);
                }
            }
            if (startC==endC||startC+32==endC||startC-32==endC||start>end){
                start++;
                end--;
            }else return false;
        }
        return true;
    }

    public static void main(String[] args){
        T26 t=new T26();
        String s=".,";
        System.out.println(t.isPalindrome(s));
    }
}
