import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-6-3 上午11:27
 * pascals-triangle-ii：别人解法
 * 思路：使用动态规划，要从后往前更新数字
 */
public class T32_1 {

    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> dp=new ArrayList<>();
        if (rowIndex<0) return dp;
        for (int i=0;i<rowIndex+1;i++){
            for (int j=i-1;j>0;j--)
                dp.set(j,dp.get(j)+dp.get(j-1));
            dp.add(1);
        }
        return dp;
    }

    public static void main(String[] args){
        T32_1 t=new T32_1();
        t.getRow(3);

    }
}
