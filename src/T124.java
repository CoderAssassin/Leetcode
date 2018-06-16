/**
 * @Author:Aliyang
 * @Data: Created in 下午9:45 18-6-16
 * remove-duplicates-from-sorted-array：我的解法
 * 思路：用一个变量记录重复的个数，然后后边的不相等的往前移动
 **/
public class T124 {

    public int removeDuplicates(int[] A) {

        if (A.length==1)
            return 1;

        int count=0;
        for (int i=1;i<A.length;i++){

            if (count==0&&A[i]==A[i-1])
                count++;
            else if (count>0){
                if (A[i]==A[i-count-1])
                    count++;
                else {
                    A[i-count]=A[i];
                }
            }
        }
        return A.length-count;
    }

    public static void main(String[] args){
        T124 t=new T124();
        int[] A=new int[]{-1,0,0,0,0,3,3};
        System.out.println(t.removeDuplicates(A));
    }
}
