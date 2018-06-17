import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午4:16 18-6-17
 * 3sum-closest：我的解法
 * 思路：使用夹逼，先确定一个数，然后从左和右向中间逼近，计算差值
 **/
public class T133 {

    public int threeSumClosest(int[] num, int target) {

        int closest=num[0]+num[1]+num[2];
        int diff=Math.abs(closest-target);

        Arrays.sort(num);

        for (int i=0;i<num.length-2;i++){
            int left=i+1,right=num.length-1;
            while (left<right){
                int sum=num[i]+num[left]+num[right];
                if (Math.abs(sum-target)<diff){
                    diff=Math.abs(sum-target);
                    closest=sum;
                }
                if (sum<target) left++;
                else right--;
            }
        }
        return closest;
    }

    public static void main(String[] args){
        T133 t=new T133();
        int[] num=new int[]{-1,2,1,-4};
        System.out.println(t.threeSumClosest(num,1));
    }
}
