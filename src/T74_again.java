/**
 * @Author:Aliyang
 * @Data: Created in 下午1:59 18-7-20
 * sort-colors：二刷
 **/
public class T74_again {

    public void sortColors(int[] A) {

        int left=0,right=A.length-1;
        for (int i=left;i<=right;i++){
            if (A[i]<1){//如果当前数为０，那么放到左边
                A[i]=A[left];
                A[left]=0;
                left++;
            }
            if (A[i]>1){//如果当前数为２，放到右边
                A[i]=A[right];
                A[right]=2;
                right--;
                i--;//右边换过来的数可能为０或者１
            }
        }
    }

    public static void main(String[] args){
        T74_again t=new T74_again();
        int[] A={1,0,2,1,1,2,0};
        t.sortColors(A);
        System.out.println(1);
    }

}
