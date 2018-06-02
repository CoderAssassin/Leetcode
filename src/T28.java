/**
 * @author aliyang
 * @date 18-6-2 上午9:56
 * best-time-to-buy-and-sell-stock-iii：别人解法
 * 思路：定义局部变量和全局变量
 * globle[i][j]=max(local[i][j],globle[i-1][j]);
 * local[i][j]=max(globle[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
 */
public class T28 {

    public int maxProfit(int[] prices) {

        int buy_1=Integer.MIN_VALUE;//买第一次股票之前的最便宜的价格
        int sell_1=0;//第一次股票交易的最大利润
        int buy_2=Integer.MIN_VALUE;//买第二次股票之前的最便宜价格
        int sell_2=0;//第二次交易的最大利润

        for (int i=0;i<prices.length;i++){
            int nowPrice=prices[i];
            buy_1=Math.max(buy_1,-nowPrice);//这里变成负的，后边加就相当于减去最便宜的时候的价格了，这里表示第一次买之前的最小价格
            sell_1=Math.max(sell_1,nowPrice+buy_1);//第一股票交易的最大利润
            buy_2=Math.max(buy_2,sell_1-nowPrice);//这里考虑刚卖出去再买进来的情况
            sell_2=Math.max(sell_2,nowPrice+buy_2);//进行两次交易后的最大利润
        }
        return sell_2;
    }
}
