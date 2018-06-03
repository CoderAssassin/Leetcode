import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-6-2 下午2:25
 * triangle：别人解法
 * 思路：从下往上搜，用下边的值更新上边的值
 */
public class T31_1 {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i --) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j ++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }
}
