/**
 * @Author:Aliyang
 * @Data: Created in 下午3:44 18-6-13
 * powx-n：别人解法
 * 思路：二分二次幂，特别注意-2^32转为正数的溢出问题
 **/
public class T100 {

    public double pow(double x, int n) {
        if (n==0)
            return 1;
        if (n<0){
            n=-n;
            x=1/x;
        }
        
        double ans=x;
        for (int i=n-1;i>0;i/=2){//n-1防止n为MIN_INT时最终溢出，减一使得转为正数后不会溢出，i/2采用二分的办法
            if (i%2!=0)//每当遇到奇数时，更新结果
                ans*=x;
            x*=x;
        }
        return ans;
    }

    public static void main(String[] args){
        T100 t=new T100();
        System.out.println(t.pow(1,-2147483648));

    }
}
