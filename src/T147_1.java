/**
 * @Author:Aliyang
 * @Data: Created in 下午7:53 18-6-19
 * median-of-two-sorted-arrays：别人解法
 * 思路：分治思想
 **/
public class T147_1 {

    public double findMedianSortedArrays(int A[], int B[]) {

        int m=A.length;
        int n=B.length;

        if (m<n)//保证A是长的
            return findMedianSortedArrays(B,A);
        if (n==0)
            return (double)(A[(m-1)/2]+A[(m/2)])/2.0;

        int lo = 0, hi = 2 * n, c2 = n;
        while(c2 >= 0 && c2 <= 2*n) {
            int c1 = m + n - c2;
            double L1 = (c1 == 0) ? Integer.MIN_VALUE : A[(c1 - 1)/2];
            double L2 = (c2 == 0) ? Integer.MIN_VALUE : B[(c2 - 1)/2];
            double R1 = (c1 == 2 * m) ? Integer.MAX_VALUE : A[c1/2];
            double R2 = (c2 == 2 * n) ? Integer.MAX_VALUE : B[c2/2];
            if(L1 > R2) c2++;
            else if(L2 > R1) c2--;
            else return (double)(Math.max(L1,L2) + Math.min(R1,R2)) / 2.0;
        }
        return -1;
    }

    private double singleArrayFindMedian(int[] A){

        int n=A.length;
        if (n%2==1)
            return 1.0*A[n/2];
        else return (A[n/2-1]+A[n/2])/2.0;
    }

    public static void main(String[] args){
        T147_1 t=new T147_1();
        int[] A=new int[]{3};
        int[] B=new int[]{1,2};
        System.out.println(t.findMedianSortedArrays(A,B));

    }
}
