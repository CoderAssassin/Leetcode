/**
 * @Author:Aliyang
 * @Data: Created in 下午4:03 18-6-11
 * sort-colors：我的解法
 * 思路：归并排序，快速排序
 **/
public class T74 {

    public void sortColors(int[] A) {
        if (A.length==0)
            return;
//        merge(A,0,A.length-1);//归并排序
        quickSort(A,0,A.length-1);//快速排序
    }

    private void quickSort(int[] A,int start,int end){

        int i=start,j=end;
        int key=A[start];

        while (i<j){
            while (i<j&&A[j]>=key)
                j--;
            if (i<j){
                int tmp=A[i];
                A[i]=A[j];
                A[j]=tmp;
                i++;
            }

            while (i<j&&A[i]<=key)
                i++;
            if (i<j){
                int tmp=A[i];
                A[i]=A[j];
                A[j]=tmp;
                j--;
            }
        }
        if (i>start)
            quickSort(A,start,i-1);
        if (j<end)
            quickSort(A,i+1,end);
    }

//    归并排序
    private void merge(int[] A,int start,int end){

        if (start>=end)
            return;
        int mid=(start+end)/2;

        merge(A,start,mid);
        merge(A,mid+1,end);
        int[] tmp=new int[end-start+1];
        int index=0,i=start,j=mid+1;
        while (i<=mid&&j<=end){
            if (A[i]>A[j]){
                tmp[index++]=A[j++];
            }else tmp[index++]=A[i++];
        }
        while (i<=mid)
            tmp[index++]=A[i++];
        while (j<=end)
            tmp[index++]=A[j++];
        for (i=0,j=start;i<index&&j<=end;)
            A[j++]=tmp[i++];
    }

    public static void main(String[] args){
        T74 t=new T74();
        int[] A=new int[]{0,3,1,2,1,3,2,1,3,3,2};
        t.sortColors(A);
        for (int i=0;i<A.length;i++)
            System.out.print(A[i]+",");
    }
}
