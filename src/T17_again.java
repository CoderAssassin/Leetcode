/**
 * @Author:Aliyang
 * @Data: Created in 下午1:15 18-7-13
 * gas-station：二刷
 **/
public class T17_again {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int start=gas.length-1,end=0;
        int remained=gas[start]-cost[start];
        while (start>end){
            if (remained>0){
                remained = remained+gas[end]-cost[end];
                end++;
            } else{
                start--;
                remained=remained+gas[start]-cost[start];
            }
        }
        return remained>=0?start:-1;
    }
}
