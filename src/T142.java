/**
 * @Author:Aliyang
 * @Data: Created in 上午10:32 18-6-19
 * reverse-integer：我的解法
 * 思路：简单转换
 * 别人优化：用新的数减去原来的数判断高位是否和原来的相等，若不等说明溢出了
 **/
public class T142 {

    public int reverse(int x) {

        if (Math.abs(x)<10)//只有一位的直接返回
            return x;

        while (x%10==0)//去掉右边的0
            x=x/10;

        long res=0;
        boolean negtive=false;
        if (x<0){
            negtive=true;
            x=-x;
        }

        while (x!=0){
            int num=x%10;//当前位
            res=res*10+num;
            x=x/10;
        }

        if (!negtive&&res>2147483647)
            return Integer.MAX_VALUE;
        if (negtive&&res>2147483648L)
            return Integer.MIN_VALUE;

        if (negtive)
            return (int)(-1*res);
        else return (int)res;
    }

    public static void main(String[] args){
        T142 t=new T142();
        System.out.println(t.reverse(1000000003));

    }
}
