/**
 * @Author:Aliyang
 * @Data: Created in 上午11:26 18-6-13
 * maximum-subarray：我的解法
 **/
public class T97 {

//    思路一：O(n)解法
//    public int maxSubArray(int[] A) {
//
//        int max=Integer.MIN_VALUE;
//
//        int sum=0;
//        boolean flag=false;//标记是否出现大于等于0的数
//        int maxNeg=Integer.MIN_VALUE;//最大的负数
//        for (int i=0;i<A.length;i++){
//
//            if (A[i]>=0)
//                flag=true;
//            if (A[i]<0&&A[i]>maxNeg)
//                maxNeg=A[i];
//            if (sum+A[i]>=0){
//                sum+=A[i];
//                if (sum>max)
//                    max=sum;
//            }
//            else {
//                sum=0;
//            }
//        }
//        if (sum>0&&sum>max)
//            max=sum;
//        if (flag==false)
//            max=maxNeg;
//        return max;
//    }

//    优化改进：别人的简便写法
    public int maxSubArray(int[] A) {

        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<A.length;i++){
            sum+=A[i];
            max=Math.max(A[i],sum);
        }
        return max;

    }

    public static void main(String[] args){
        T97 t=new T97();
        int[] A=new int[]{-1};
        System.out.println(t.maxSubArray(A));
    }
}
