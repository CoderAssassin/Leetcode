import java.util.HashSet;
import java.util.Iterator;

/**
 * @author aliyang
 * @date 18-6-1 下午7:20
 * longest-consecutive-sequence：别人解法
 * 思路：使用hashset来保存所有的数字，当查询某个数字的时候，往该数字的两边搜，得到包含该数字的最长串，然后把用过的数字
 * 从集合中移除，比较当前串是否比最大串要长，并更新
 */
public class T23 {
    public int longestConsecutive(int[] num) {

        if(num==null||num.length==0)
            return 0;

        HashSet<Integer> set=new HashSet<>();
        int res=1;
        for (int i=0;i<num.length;i++)
            set.add(num[i]);
        while (!set.isEmpty()){
            Iterator iter=set.iterator();
            int item=(Integer)iter.next();
            set.remove(item);

            int len=1;
            int i=item-1;
//            搜索比item小的连续的数
            while (set.contains(i)){
                set.remove(i--);
                len++;
            }

//            搜索比item大的连续的数
            i=item+1;
            while (set.contains(i)){
                set.remove(i++);
                len++;
            }
            if (len>res)
                res=len;
        }
        return res;
    }
}
