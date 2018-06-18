/**
 * @Author:Aliyang
 * @Data: Created in 下午7:39 18-6-17
 * container-with-most-water：别人解法
 * 思路：利用夹逼，每次去掉短的一边
 **/
public class T138 {

    public int maxArea(int[] height) {

        if (height.length<=1)
            return 0;

        int left=0,right=height.length-1;
        int max=0;

        while (left<right){
            int container=Math.min(height[left],height[right])*(right-left);
            max=Math.max(max,container);
            if (height[left]<=height[right])
                left++;
            else right--;
        }

        return max;
    }
}
