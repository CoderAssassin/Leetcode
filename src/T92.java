/**
 * @Author:Aliyang
 * @Data: Created in 下午9:10 18-6-12
 * length-of-last-word：我的解法
 * 思路：从后往前
 **/
public class T92 {

    public int lengthOfLastWord(String s) {

        if (s==null||s.equals(""))
            return 0;

        int count=0;
        for (int i=s.length()-1;i>=0;i--){

            if ((s.charAt(i)>='a'&&s.charAt(i)<='z')||
                    (s.charAt(i)>='A'&&s.charAt(i)<='Z'))
                count++;

            if ((s.charAt(i)==' '&&count>0)||(i==0&&count>0))
                return count;
        }
        return 0;
    }

    public static void main(String[] args){
        T92 t=new T92();
        String s="a";
        System.out.println(t.lengthOfLastWord(s));
    }
}
