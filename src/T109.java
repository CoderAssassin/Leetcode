/**
 * @Author:Aliyang
 * @Data: Created in 下午4:06 18-6-14
 * first-missing-positive：我的解法
 * 思路：将1-n之间的正数放到正确的位置，然后遍历看哪个位置下标加1和值不相等
 **/
public class T109 {

    public int firstMissingPositive(int[] A) {

        if (A.length==0)
            return 1;

        for (int i=0;i<A.length;i++){
            while (A[i]>=1&&A[i]<=A.length&&A[A[i]-1]!=A[i]){//将正数n放到位置n-1上
                int tmp=A[i];
                A[i]=A[A[i]-1];
                A[tmp-1]=tmp;
            }
        }

        for (int i=0;i<A.length;i++){
            if (i+1!=A[i])
                return i+1;
        }
        return A.length+1;
    }

    public static void main(String[] args){
        T109 t=new T109();
        int[] A=new int[]{3,4,-1,1};
        System.out.println(t.firstMissingPositive(A));
    }
}
