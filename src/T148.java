import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Aliyang
 * @Data: Created in 下午5:35 18-6-17
 * two-sum：我的解法
 * 思路：使用一个map，这里不能使用夹逼
 **/
public class T148 {

    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length<2||numbers==null)
            return null;

        Map<Integer,int[]> map=new HashMap<>();

        for (int i=0;i<numbers.length-1;i++){
            for (int j=i+1;j<numbers.length;j++){
                int sum=numbers[i]+numbers[j];
                if (!map.containsKey(sum)){
                    int[] a={i+1,j+1};
                    map.put(sum,a);
                }
            }
        }

        return map.get(target);
    }

    public static void main(String[] args){
        T148 t=new T148();
        int[] numbers=new int[]{0,4,3,0};
        int[] res=t.twoSum(numbers,0);
        System.out.println(res[0]+","+res[1]);
    }
}
