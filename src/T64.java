import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:57 18-6-9
 * maximal-rectangle:我的解法
 * 思路:根据T65,每一行计算上边到这行一共的连续的1的个数,然后利用T65的方法计算直方图的连续最大面积
 **/
public class T64 {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length==0)
            return 0;

        int res=0;
        int[] heigh=new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1')
                    heigh[j]++;
                else heigh[j]=0;
            }
            res=Math.max(res,largestRectangleArea(heigh));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                max = Math.max(max, (i - stack.peek() - 1) * heights[top]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[top]);
        }
        return max;
    }

    public static void main(String[] args){
        T64 t=new T64();
        char[][] matrix=new char[4][];
        matrix[0]=new char[]{'1','0','0','1'};
        matrix[1]=new char[]{'1','1','1','0'};
        matrix[2]=new char[]{'1','1','1','0'};
        matrix[3]=new char[]{'0','0','1','0'};
//
//        char[][] matrix=new char[2][];
//        matrix[0]=new char[]{'0','1'};
//        matrix[1]=new char[]{'1','0'};
        System.out.println(t.maximalRectangle(matrix));
    }
}
