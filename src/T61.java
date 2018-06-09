/**
 * @Author:Aliyang
 * @Data: Created in 下午12:06 18-6-9
 * merge-sorted-array:我的解法
 * 思路:数组B从后往前遍历,使用插入排序,从A中选择插入的位置,比当前B中数大的往后移动,然后插入
 **/
public class T61 {

    public void merge(int A[], int m, int B[], int n) {

        if (m==0){
            for (int i=m;i<B.length;i++)
                A[i]=B[i];
            return;
        }
        if (n==0){
            return;
        }

        int index_a=m-1;
        int index_b=B.length-1;
        while (index_b>=0){
            int num_b=B[index_b];
            while (index_a>=0&&A[index_a]>num_b)
                index_a--;

//            先将已经排好序的往后移动
            int i=m-1;
            for (;i>index_a;i--)
                A[i+1]=A[i];
            A[i+1]=B[index_b];
            index_b--;
            m++;
        }
    }

    public static void main(String[] args){
        T61 t=new T61();
        int[] A=new int[2];
        A[0]=2;

        int[] B=new int[]{1};

        t.merge(A,1,B,1);
        for (Integer a:A)
            System.out.print(a+",");
    }
}
