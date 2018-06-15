/**
 * @Author:Aliyang
 * @Data: Created in 上午10:18 18-6-15
 * count-and-say：我的解法
 * 思路：计数
 **/
public class T112 {

    public String countAndSay(int n) {

        StringBuilder res=new StringBuilder();
        if (n==0)
            return res.toString();
        if (n==1)
            return "1";

        String pre="1";

        for (int i=2;i<=n;i++){

            char c=pre.charAt(0);
            int count=1;
            for (int j=1;j<=pre.length();j++){
                if (j<pre.length()&&pre.charAt(j)==c)
                    count++;
                else {
                    res.append(""+count+c);
                    if (j<pre.length()){
                        c=pre.charAt(j);
                        count=1;
                    }
                    else break;
                }
            }
            pre=res.toString();
            res.delete(0,res.length()+1);
        }
        return pre.toString();
    }

    public static void main(String[] args){
        T112 t=new T112();
        System.out.println(t.countAndSay(100));
    }
}
