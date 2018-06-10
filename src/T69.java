

/**
 * Created by AliYang on 2018/6/10.
 * remove-duplicates-from-sorted-array-ii：我的解法
 */
public class T69 {

    public int removeDuplicates(int[] A) {
        if (A.length==0)
            return 0;

        int count=1;//重复次数
        int move=0;//需要往前移动的步数
        int res=1;//结果长度
        for (int i=1;i<A.length;i++){
            if (A[i]==A[i-1]){//相等时
                if (count<2){//如果重复没到达2次
                    count++;
                    res++;
                }else {
                    move++;
                }
            }else {
                count=1;
                res++;
            }
            if (move>0)
                A[i-move]=A[i];
        }
        return res;
    }

    public static void main(String[] args){
        T69 t=new T69();
        int[] A=new int[]{1,1,1,2,2,3};
        int length=t.removeDuplicates(A);
        System.out.println(length);
        for (int i=0;i<length;i++)
            System.out.print(A[i]+",");
    }
}
