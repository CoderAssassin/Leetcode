/**
 * @author aliyang
 * @date 18-6-2 上午10:01
 * best-time-to-buy-and-sell-stock-ii：别人解法
 * 思路：连续递增看成一次买入卖出操作，只要计算从头到尾增的量就好
 */
public class T29 {

    public int maxProfit(int[] prices) {
        if (prices.length<2)
            return 0;

        int buyprice=prices[0];//买入时候的价格
        int res=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]>prices[i-1])
                res+=prices[i]-prices[i-1];
        }
        return res;
    }

    public static void main(String[] args){
        T29 t=new T29();
        int[] prices=new int[]{1,3,2,4,5,6,8,7};
        System.out.println(t.maxProfit(prices));
    }
}
