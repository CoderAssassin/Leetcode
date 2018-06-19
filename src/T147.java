/**
 * @Author:Aliyang
 * @Data: Created in 下午5:45 18-6-19
 * median-of-two-sorted-arrays：我的解法
 * 思路：代码稍微有点长。。。。。。。。。。。先算中位数点，然后再逐个匹配对应
 **/
public class T147 {

    public double findMedianSortedArrays(int A[], int B[]) {

        int m=A.length;
        int n=B.length;
        if (m==0&&n==0)
            return 0;
        int OddTarget=-1;//奇数中位数的索引
        int evenTarget1=-1,evenTarget2=-1;//偶数中位数的索引
        boolean isOdd=false;//是否是奇数
        if ((m+n)%2==1){
            isOdd=true;
            OddTarget=(m+n)/2;
        }
        else{
            evenTarget1=(m+n)/2-1;
            evenTarget2=(m+n)/2;
        }

        int index=0;
        int a=0,b=0;
        double evensum=0;
        int i=0;

        while (a<A.length&&b<B.length){
            if (A[a]<B[b]){
                if (isOdd==true&&OddTarget==index)
                    return A[a];
                if (isOdd==false){
                    if (evenTarget1==index){
                        evensum+=A[a];
                    }
                    if (evenTarget2==index){
                        return (evensum+A[a])/2;
                    }
                }
                a++;
            }else {
                if (isOdd==true&&OddTarget==index)
                    return B[b];
                if (isOdd==false){
                    if (evenTarget1==index){
                        evensum+=B[b];
                    }
                    if (evenTarget2==index){
                        return (evensum+B[b])/2;
                    }
                }
                b++;
            }
            index++;
        }

        while (a<A.length){
            if (isOdd==true&&OddTarget==index)
                return A[a];
            if (isOdd==false){
                if (evenTarget1==index){
                    evensum+=A[a];
                }
                if (evenTarget2==index){
                    return (evensum+A[a])/2;
                }
            }
            index++;
            a++;
        }
        while (b<B.length){
            if (isOdd==true&&OddTarget==index)
                return B[b];
            if (isOdd==false){
                if (evenTarget1==index){
                    evensum+=B[b];
                }
                if (evenTarget2==index){
                    return (evensum+B[b])/2;
                }
            }
            index++;
            b++;
        }

        return 0;
    }

    public static void main(String[] args){
        T147 t=new T147();
        int[] A=new int[]{};
        int[] B=new int[]{1};
        System.out.println(t.findMedianSortedArrays(A,B));
    }
}
