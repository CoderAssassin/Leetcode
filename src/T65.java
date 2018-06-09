import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:36 18-6-9
 * largest-rectangle-in-histogram:别人解法
 * 思路:利用栈存储递增的序列,遇到小的然后开始往前计算
 **/
public class T65 {

    public int largestRectangleArea(int[] heights) {
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
        T65 t=new T65();
        int[] heights=new int[]{2,1,5,6,2,3};
        System.out.println(t.largestRectangleArea(heights));
    }
}
