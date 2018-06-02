/**
 * @author aliyang
 * @date 18-6-2 上午10:02
 * best-time-to-buy-and-sell-stock：我的解法
 * 思路：使用一个min数组和一个max数组，min[i]表示从左到i的最小的数，max[j]表示从右到i的最大的数，然后再遍历一次
 * 该数组找到差的最大值
 */
public class T30 {

    public int maxProfit(int[] prices) {
        if (prices.length<2)
            return 0;

        int[] min=new int[prices.length];//min[i]从左到i的最小的数
        int[] max=new int[prices.length];//max[j]从右到i的最大的数
        min[0]=prices[0];
        max[prices.length-1]=prices[prices.length-1];

//        求min和max的值
        for (int i=1,j=prices.length-2;i<prices.length&&j>=0;i++,j--){
            min[i]=Math.min(min[i-1],prices[i]);
            max[j]=Math.max(max[j+1],prices[j]);
        }
        int res=0;
        int tmp=0;
//        计算min和max的差的最大值
        for (int i=0;i<prices.length;i++){
            tmp=max[i]-min[i];
            if (tmp>=0)
                res=res<tmp?tmp:res;
        }
        return res;
    }

    public static void main(String[] args){
        T30 t=new T30();
        int[] prices=new int[]{};
        System.out.println(t.maxProfit(prices));
    }
}
