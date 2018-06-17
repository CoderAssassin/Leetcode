import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午5:01 18-6-17
 * 3sum：我的解法
 **/
public class T134 {

//    思路一：使用夹逼超时，切记要用两个while，不然超时；另外，剪枝一是因为若当前数为正数，那么后边的数都是正数加起来就不可能是0，但是加了剪枝一竟然超时，
//    醉了
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (num.length<3||num==null)
            return res;

        Arrays.sort(num);

        for (int i=0;i<num.length-2;i++){
//            if (num[i]>0)//剪枝一
//                break;

            int left=i+1,right=num.length-1;
            while (left<right){
                int sum=num[i]+num[left]+num[right];
                if (sum==0){
                    ArrayList<Integer> cur=new ArrayList<>();
                    cur.add(num[i]);
                    cur.add(num[left]);
                    cur.add(num[right]);
                    if (!res.contains(cur))
                        res.add(cur);
//                    去掉相同的数
                    while (left<right&&num[left]==num[left+1]) left++;
                    while (left<right&&num[right]==num[right-1]) right--;
                    left++;
                    right--;
                }
                else if (sum<0)
                    left++;
                else right--;
            }
        }
        return res;
    }

//    思路二：使用map先存储两个数的组合，也超时，醉了～～～
//    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
//
//        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
//        if (num.length<3||num==null)
//            return res;
//
//        Arrays.sort(num);
//        Map<Integer,ArrayList<Integer[]>> map=new HashMap<>();
//        for (int i=0;i<num.length-1;i++){
//            for (int j=i+1;j<num.length;j++){
//                int sum=num[i]+num[j];
//                Integer[] in={i,j};
//                if (!map.containsKey(sum))
//                    map.put(sum,new ArrayList<>());
//                map.get(sum).add(in);
//            }
//        }
//
//        Set<Integer> keys=map.keySet();
//        for (Integer key:keys){
//
//            ArrayList<Integer[]> arr=map.get(key);
//            for (Integer[] in:arr){
//
//                for (int i=in[1]+1;i<num.length;i++){
//                    int sum=num[in[0]]+num[in[1]]+num[i];
//                    if (sum==0){
//                        ArrayList<Integer> now=new ArrayList<>();
//                        now.add(num[in[0]]);
//                        now.add(num[in[1]]);
//                        now.add(num[i]);
//                        if (!res.contains(now))
//                            res.add(now);
//                    }
//                    if (sum>0)
//                        break;
//                }
//            }
//        }
//        return res;
//    }

    public static void main(String[] args){
        T134 t=new T134();
        int[] num=new int[]{-1,0,1,2,-1,-4};
        ArrayList<ArrayList<Integer>> res=t.threeSum(num);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
