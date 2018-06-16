/**
 * @Author:Aliyang
 * @Data: Created in 上午11:35 18-6-16
 * search-in-rotated-sorted-array：我的解法
 * 思路：二分
 **/
public class T117 {

    public int search(int[] A, int target) {

        int start=0,end=A.length-1;

        while (start<=end){

            int mid=(start+end)/2;
            if (A[mid]==target)
                return mid;
            if (A[start]<=A[mid]){//mid在左边旋转部分
                if (target>=A[start]&&target<A[mid])
                    end=mid-1;
                else start=mid+1;
            }else {//mid在右边旋转部分
                if (A[mid]<target&&target<=A[end])
                    start=mid+1;
                else end=mid-1;
            }
        }
        return -1;
    }
}
