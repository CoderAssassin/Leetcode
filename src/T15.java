/**
 * @author aliyang
 * @date 18-5-30 下午4:49
 * single-number：我的解法
 * 思路：两两重复，只有一个单个，那么从头到尾异或就成
 */
public class T15 {

    public int singleNumber(int[] A) {

        int res=0;
        for (int i=0;i<A.length;i++)
            res^=A[i];
        return res;
    }
}
