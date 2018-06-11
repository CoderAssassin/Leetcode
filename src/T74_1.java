/**
 * @Author:Aliyang
 * @Data: Created in 下午5:05 18-6-11
 * sort-colors：别人解法
 * 思路：分三路，以1作为标记
 **/
public class T74_1 {

    public void sortColors(int[] A) {
        int begin=0,end=A.length-1,lt=0,gt=A.length-1;
        for (int i=0;i<=gt;i++){
            if (A[i]<1){//0放到左边
                A[i]=A[lt];
                A[lt]=0;
                lt++;
            }else if (A[i]>1){
                A[i]=A[gt];
                A[gt]=2;
                gt--;
                i--;//此时右边换过来的数可能为1或者0，需要再次判断
            }

        }
    }
}
