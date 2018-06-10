

/**
 * Created by AliYang on 2018/6/10.
 * search-in-rotated-sorted-array-ii：我的解法
 */
public class T68 {

    public boolean search(int[] A, int target) {
        int l=0,r=A.length-1;
        while (r>=l){
            int mid=l+(r-l)/2;
            if (A[mid]==target) return true;
            if (A[mid]>A[l]){//中间比左边大
                if (A[l]<=target&&target<A[mid])//target在中间和开始之间
                    r=mid-1;
                else l=mid+1;
            }else if (A[mid]<A[l]){//中间比左边小
                if (A[mid]<target&&target<=A[r])//target在中间和结束之间
                    l=mid+1;
                else r=mid-1;
            }else l++;//当l,r,mid相等时直接头++
        }
        return false;
    }
}
