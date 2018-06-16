/**
 * @Author:Aliyang
 * @Data: Created in 上午11:24 18-6-16
 * search-for-a-range：我的解法
 * 思路：二分
 **/
public class T116 {

    public int[] searchRange(int[] A, int target) {

        int start=0,end=A.length-1;
        while (start<=end){

            int mid=(start+end)/2;
            if (A[mid]<target)
                start=mid+1;
            else if (A[mid]>target)
                end=mid-1;
            else {
                int left=mid;
                while (left>=0&&A[left]==A[mid])
                    left--;
                int right=mid;
                while (right<=A.length-1&&A[right]==A[mid])
                    right++;
                return new int[]{left+1,right-1};
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        T116 t=new T116();
        int[] A=new int[]{1};
        int[] res=t.searchRange(A,1);
        for (Integer a:res)
            System.out.print(a+",");
    }
}
