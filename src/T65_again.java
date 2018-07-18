import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:33 18-7-18
 * largest-rectangle-in-histogram：二刷
 **/
public class T65_again {

    public int largestRectangleArea(int[] height) {

        if (height==null||height.length==0)
            return 0;

        int res=0,min=0;
        Stack<Integer> stack=new Stack<>();//递增栈
        stack.push(-1);//加一个标记为，作为最右边的判断
        for (int i=0;i<height.length;i++){
            while (stack.peek()!=-1&&height[stack.peek()]>height[i]){
                min=stack.pop();
                res=Math.max(res,height[min]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek()!=-1){
            min=stack.pop();
            res=Math.max(res,height[min]*(height.length-stack.peek()-1));
        }
        return res;
    }

    public static void main(String[] args){
        T65_again t=new T65_again();
        int[] height={2,1,5,6,2,3};
        System.out.println(t.largestRectangleArea(height));
    }
}
