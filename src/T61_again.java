/**
 * @Author:Aliyang
 * @Data: Created in 下午3:08 18-7-17
 * merge-sorted-array：二刷
 **/
public class T61_again {

    public void merge(int A[], int m, int B[], int n) {

        if (B==null||B.length==0||n==0)
            return;
        int index=m+n-1;//总的索引位置
        int index_a=m-1,index_b=n-1;

        while (index_a>=0&&index_b>=0){
            while (index_a>=0&&A[index_a]>B[index_b])
                A[index--]=A[index_a--];
            while (index_a>=0&&index_b>=0&&A[index_a]<=B[index_b])
                A[index--]=B[index_b--];
        }

        while (index_a>=0)
            A[index--]=A[index_a--];
        while (index_b>=0)
            A[index--]=B[index_b--];
    }

    public static void main(String[] args){
        T61_again t=new T61_again();
        int[] A=new int[]{1,3,5,7,0,0,0,0};
        int[] B=new int[]{2,4,6,8};
        t.merge(A,4,B,4);
    }
}
