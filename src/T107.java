/**
 * @Author:Aliyang
 * @Data: Created in 下午1:42 18-6-14
 * multiply-strings：我的解法
 * 思路：字符串模拟乘法
 **/
public class T107 {

    public String multiply(String num1, String num2) {
        if (num1==null||num2==null)
            return "";
        int[] middle=new int[num1.length()+num2.length()];//中间数组,循环结束即为结果数组
        int i=0,j=0;
        for (i=num1.length()-1;i>=0;i--){
            int jinwei=0;//进位数
            for (j=num2.length()-1;j>=0;j--){
                int tmp=Integer.valueOf(num1.charAt(i)-'0')*Integer.valueOf(num2.charAt(j)-'0');
                int tmp_jinwei=jinwei;
                jinwei=(middle[i+j+1]+tmp+jinwei)/10;//更新进位数
                middle[i+j+1]=(middle[i+j+1]+tmp+tmp_jinwei)%10;//更新中间数组
            }
            if (jinwei!=0)
                middle[i+j+1]=jinwei;
        }

        i=0;
        while (i<middle.length&&middle[i]==0)//找到非0的i的位置，目的是去掉前面没用的0
            i++;
        if (i>=middle.length)
            return "0";

        StringBuilder sb=new StringBuilder();
        for (j=middle.length-1;j>=i;j--)
            sb.append(middle[j]);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args){
        T107 t=new T107();
        String num1="0";
        String num2="0";
        System.out.println(t.multiply(num1,num2));
    }
}
