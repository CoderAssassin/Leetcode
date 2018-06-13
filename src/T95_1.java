/**
 * @Author:Aliyang
 * @Data: Created in 上午11:06 18-6-13
 * jump-game：别人解法
 * 思路：很牛逼的思路，从头到尾遍历，用前面能跳到的最远的地方加上当前位置能跳的步数，更新最远可达，限制条件是当前位置必须在最远可达的范围内
 **/
public class T95_1 {

    public boolean canJump(int[] A) {

        int max=0;//能跳到的最远处
        for (int i=0;i<A.length&&max>=i;i++)
            if (i+A[i]>max)//更新当前能跳到的最远的点
                max=i+A[i];
        return max>=A.length-1?true:false;

    }
}
