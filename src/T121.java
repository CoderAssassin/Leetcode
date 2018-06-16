/**
 * @Author:Aliyang
 * @Data: Created in 下午6:14 18-6-16
 * divide-two-integers：别人解法
 * 思路：
 **/
public class T121 {

//    思路一：暴力，超时
//    public int divide(int dividend, int divisor) {
//
//        if (divisor==0)
//            return -1;
//        if (divisor==1)
//            return dividend;
//        if (divisor==-1)
//            return -dividend;
//        if (Math.abs(dividend)<Math.abs(divisor))
//            return 0;
//
//        int flag=1;//1表示正数，-1表示负数
//        if (dividend<0){
//            dividend=-dividend;
//            if (flag==1)
//                flag=-1;
//            else flag=1;
//        }
//        if (divisor<0){
//            divisor=-divisor;
//            if (flag==1)
//                flag=-1;
//            else flag=1;
//        }
//        int res=dividend;
//        int count=0;
//        while (res>=divisor){
//            res-=divisor;
//            count++;
//        }
//        return count*flag;
//    }

//    思路二：用加的方法
    public int divide(int dividend, int divisor) {
        long result = div(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    private long div(long dividend, long divisor){
        if (divisor==0)
            return -1;
        if (divisor==1)
            return dividend;
        if (divisor==-1)
            return -dividend;
        if (Math.abs(dividend)<Math.abs(divisor))
            return 0;

        boolean negative = dividend < 0 != divisor < 0;
        if (dividend<0)
            dividend=-dividend;
        if (divisor<0)
            divisor=-divisor;

        long sum=divisor;
        long divide=1;
        while ((sum+sum)<=dividend){
            sum+=sum;//关键，这里直接加上自身，相当于乘了2
            divide+=divide;
        }
        return negative ? -(divide + div((dividend-sum), divisor)) :
                (divide + div((dividend-sum), divisor));//因为剩下来的是比当前的sum小，但是可能还比divisor大很多，所以要继续计算
    }

    public static void main(String[] args){
        T121 t=new T121();
        System.out.println(t.divide(10,2));
    }
}
