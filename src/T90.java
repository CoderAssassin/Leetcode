/**
 * @Author:Aliyang
 * @Data: Created in 下午6:42 18-6-12
 * permutation-sequence：我的解法
 * 思路：首先用一个数组保存n为不同数的时候的总的组合数。假设当前位置是从左到右第i位，那么第i位的数字和右边的位数有关，先用当前k对右边剩余位数的总组合数做除法得到now，
 * 若余数不为0，那么找到1-n中第now+1个数为当前位的数，然后用后边位数的总排序数对当前的k取余表示k再后边一位的偏移，循环
 **/
public class T90 {

    public String getPermutation(int n, int k) {

        if (k==0)
            return "";

        int[] dp=new int[n+1];//记录为n时总的记录数
        dp[0]=1;

        int[] number=new int[n+1];//用来记录1-n哪些数已经枚举了
//        计算当前n的总记录数
        for (int i=1;i<=n;i++)
            dp[i]=i*dp[i-1];

        StringBuilder sb=new StringBuilder();
        int now;//表示当前位的数字
//        计算每一位的数
        for (int i=1;i<=n;i++){

            if(k==0){//k==0说明是剩余的数的最右边的没有被枚举的数
                int j=n;
                while (number[j]==1)
                    j--;
                now=j;
                number[j]=1;
            }else {
                now=k/dp[n-i];//当前位的数字应该再1-9中第几个
                if (k%dp[n-i]!=0)
                    now++;
                int j=1;
                for (int count=0;j<=n;j++){
                    if (number[j]==0){
                        count++;
                    }
                    if (count==now)
                        break;
                }
                number[j]=1;
                now=j;
            }
            sb.append(now);
            k=k%dp[n-i];
        }

        return sb.toString();
    }

    public static void main(String[] args){

        T90 t=new T90();
        System.out.println(t.getPermutation(3,2));
    }
}
