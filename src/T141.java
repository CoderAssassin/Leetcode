/**
 * @Author:Aliyang
 * @Data: Created in 上午10:00 18-6-19
 * string-to-integer-atoi：我的解法
 * 思路：简单字符串转整数
 **/
public class T141 {

    public int atoi(String str) {
        if (str.equals(""))//str是空的话
            return 0;
        int i=0;
        while (str.charAt(i)==' ')
            i++;

        if (i==str.length())//如果全都是空格的话
            return 0;

        boolean negtive=false;//是否是负数
        if (str.charAt(i)=='-'){
            negtive=true;
            i++;
        }else if (str.charAt(i)=='+')i++;

        if (i<str.length()&&(str.charAt(i)=='+'||str.charAt(i)=='-'))//如果后边还有+-号，那么出错了
            return 0;

        while (i<str.length()&&str.charAt(i)=='0')//去掉前边的0
            i++;

        long res=0;
        while (i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            res=res*10+Integer.valueOf(str.charAt(i)-'0');
            i++;
        }

        if (negtive==false&&res>2147483647)
            return Integer.MAX_VALUE;
        if (negtive==true&&res>2147483648L)
            return Integer.MIN_VALUE;

        if (negtive==true)
            res=-1*res;
        return (int)res;
    }

    public static void main(String[] args){
        T141 t=new T141();
        String str="1";
        System.out.println(t.atoi(str));
    }
}
