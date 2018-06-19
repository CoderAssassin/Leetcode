/**
 * @Author:Aliyang
 * @Data: Created in 下午7:53 18-6-19
 * median-of-two-sorted-arrays：别人解法
 * 思路：分治思想
 **/
public class T147_1 {

    public double findMedianSortedArrays(int A[], int B[]) {

        int n=A.length;
        int m=B.length;
        if (n>m)//保证数组1一定是短的
            return findMedianSortedArrays(B,A);
        int L1=0,L2=0,R1=0,R2=0,c1,c2;//L表示割点左边部分的最大值，R表示割点右边部分的最大值,C为割点
        int lo=0;
        int hi=2*n;//假设虚拟加了'#'，数组1是2*n的长度

        while (lo<hi){//开始二分
            c1=(lo+hi)/2;//c1二分，
            c2=m+n-c1;//因为找第m+n小的，所以减去C1的割点
            L1=(c1==0)?Integer.MIN_VALUE:A[(c1-1)/2];//如果A数组到了最左边，说明A数组的数都比B的大，说明中位数再B数组中
            R1=(c1==2*n)?Integer.MAX_VALUE:A[c1/2];
            L2 = (c2 == 0)?Integer.MIN_VALUE:B[(c2-1)/2];
            R2 = (c2 == 2*m)?Integer.MAX_VALUE:B[c2/2];

            if (L1>R2)//左边缩
                hi=c1-1;
            else if (L2>R1)
                lo=c1+1;
            else break;
        }
        return (Math.max(L1,L2)+Math.min(R1,R2))/2.0;
    }
}
