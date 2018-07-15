import java.util.HashSet;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:16 18-7-15
 * longest-consecutive-sequence：二刷
 **/
public class T23_again {

    public int longestConsecutive(int[] num) {
        if (num==null||num.length==0)
            return 0;

        int maxLen=0;
        HashSet<Integer> set=new HashSet();//保存所有的数字
        for (Integer a:num)
            set.add(a);

        int count=1;
        for (Integer a:num){
            if (set.contains(a)){
                int left=a-1,right=a+1;
                while (set.contains(left)){
                    set.remove(left);
                    left--;
                    count++;
                }
                while (set.contains(right)){
                    set.remove(right);
                    right++;
                    count++;
                }
                maxLen=count>maxLen?count:maxLen;
                if (set.size()!=0)
                    count=1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        T23_again t=new T23_again();
        int[] num={100,4,200,1,3,2};
        System.out.println(t.longestConsecutive(num));
    }
}
