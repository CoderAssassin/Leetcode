import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-6-3 上午11:39
 * pascals-triangle：我的解法
 * 思路：照搬T32的思路，多套一层循环，优化可以记录上一层的结果
 */
public class T33 {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (numRows<0)
            return res;

        ArrayList<Integer> dp=null;
        for (int k=0;k<numRows;k++){
            dp=new ArrayList<>();
            for (int i=0;i<k+1;i++){
                for (int j=i-1;j>0;j--)
                    dp.set(j,dp.get(j)+dp.get(j-1));
                dp.add(1);
            }
            res.add(dp);
        }
        return res;
    }
}
