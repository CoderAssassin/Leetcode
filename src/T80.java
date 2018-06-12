/**
 * @Author:Aliyang
 * @Data: Created in 上午10:45 18-6-12
 * sqrtx：别人解法
 * 我的解法：二分，没注意long，溢出
 **/
public class T80 {

//    思路一：比较有技巧的解法，牛顿法
//    public int sqrt(int x) {
//        long i=1;
//        while (i*i<x)
//            i*=2;
//        while (i*i>x)
//            i-=1;
//        return (int)i;
//    }

//    思路二：也是牛顿逼近法，更简洁
//    public int sqrt(int x) {
//        long r=x;
//        while (r*r>x)
//            r=(r+x/r)/2;
//        return (int) r;
//    }

//    思路三：二分查找
    public int sqrt(int x) {
        if (x==0)
            return 0;
        int left=1,right=x;
        while (true){
            int mid=(left+right)/2;

            if (mid>x/mid)
                right=mid-1;
            else {
                if (mid+1>x/(mid+1))
                    return mid;
                left=mid+1;
            }
        }
    }


    public static void main(String[] args){
        T80 t=new T80();
        System.out.println(t.sqrt(2));

    }
}
