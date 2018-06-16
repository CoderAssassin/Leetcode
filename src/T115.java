/**
 * @Author:Aliyang
 * @Data: Created in 上午10:47 18-6-16
 * search-insert-position：我的解法
 * 思路：二分
 **/
public class T115 {

    public int searchInsert(int[] A, int target) {

        if (A.length==0)
            return 0;
        if (target<A[0])
            return 0;

        int start=0,end=A.length-1;
        while (start<end){
            int mid=(start+end)/2;
            if (A[mid]==target)
                return mid;
            if (A[mid]>target){
                end=mid-1;
                continue;
            }
            if (A[mid]<target){
                start=mid+1;
                continue;
            }
        }
        if (start==end){
            if (A[start]==target)
                return start;
            else if (A[start]>target)
                 return start==0?0:start;
            else return start+1;
        }
        if (A[start]<target)
            return start+1;
        if (A[end]>target)
            return end;
        else return end+1;
    }

    public static void main(String[] args){
        T115 t=new T115();
        int[] A=new int[]{1,3};
        System.out.println(t.searchInsert(A,2));

    }
}
