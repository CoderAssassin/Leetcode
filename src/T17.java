/**
 * @author aliyang
 * @date 18-5-31 下午1:16
 * gas-station：别人解法
 * 思路：从start出发， 如果油量足够， 可以一直向后走 end++；  油量不够的时候，
 * start向后退  最终 start == end的时候，如果有解一定是当前 start所在位置
 */
public class T17 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int start=gas.length-1;
        int end=0;
        int sum=gas[start]-cost[start];

        while (start>end){
            if (sum>0){
                sum+=gas[end]-cost[end];
                end++;
            }else {
                --start;
                sum+=gas[start]-cost[start];
            }
        }
        return sum>=0?start:-1;
    }
}
