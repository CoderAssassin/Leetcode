/**
 * @author aliyang
 * @date 18-6-2 上午10:28
 * best-time-to-buy-and-sell-stock：别人解法
 * 思路：也是用一个min和一个max，但是只需要一趟遍历
 */
public class T30_1 {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int max=0;
        int min=prices[0];
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);//到i位置的最小的数
            max=Math.max(max,prices[i]-min);//到i位置的最小的数和最大的数的差
        }
        return max;
    }
}
