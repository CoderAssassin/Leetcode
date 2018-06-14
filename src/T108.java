

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:06 18-6-14
 * trapping-rain-water：别人解法
 **/
public class T108 {

//    思路一：O(2n)，从左往右扫描记录每个柱子的左边的最大高度，然后从右到左扫描记录每个柱子的右边的最大高度，取左右最大高度的小的然后减去当前柱子高度，累加
//    public int trap(int[] A) {
//
//        if (A==null||A.length==0)
//            return 0;
//        int max=0;
//        int res=0;
//        int[] container=new int[A.length];
//
//        for (int i=0;i<A.length;i++){
//            container[i]=max;
//            max=Math.max(max,A[i]);
//        }
//        max=0;
//        for (int i=A.length-1;i>=0;i--){
//            container[i]=Math.min(max,container[i]);
//            max=Math.max(max,A[i]);
//            res+=container[i]-A[i]>0?container[i]-A[i]:0;
//        }
//        return res;
//    }

//    思路二：O(n),同时从两边往中间搜，当相遇的时候停止。每次选择左右两边高度小的，假设此时高度为h，从高度小的开始继续搜，当搜到高度小于h的，那么计算结果，直到
//    碰到高度大于h的停止，然后继续循环
    public int trap(int[] A){
        if (A==null||A.length==0)
            return 0;
        int l=0;//左指针
        int r=A.length-1;//右指针
        int res=0;
        while (l<r){
            int min=Math.min(A[l],A[r]);//取左右指针小的那个
            if (A[l]==min){//若是左边为小
                l++;
                while (l<r&&A[l]<min){//开始计算小的柱子
                    res+=min-A[l];
                    l++;
                }
            }else {
                r--;
                while (l<r&&A[r]<min){
                    res+=min-A[r];
                    r--;
                }
            }
        }
        return res;
    }
}
