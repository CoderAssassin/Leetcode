import java.util.LinkedList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午12:11 18-6-16
 * longest-valid-parentheses：别人解法
 * 思路：关键在于start索引位置没有想到，start记录连续的起始位置，遇到右括号栈不为空的话连续长度为到栈顶元素的索引差，否则直接为到start的
 **/
public class T118 {

    public int longestValidParentheses(String s) {

        if(s==null || s.length()==0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = 0;//连续合格的串的起始地址
        int max = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stack.push(i);
            }
            else
            {
                if(stack.isEmpty())//若当前碰到右括号但是栈为空，说明到当前位置出问题了，断续了，所以接下来开始位置在后边一个位置
                {
                    start = i+1;
                }
                else
                {
                    stack.pop();
                    max = stack.isEmpty()?Math.max(max,i-start+1):Math.max(max,i-stack.peek());//若此时为空，那么更新max为到连续的开始位置
//                    的串的长度，若不为空，那么更新到栈顶的连续串，因为可能栈中剩下的左括号没有匹配
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        T118 t=new T118();
        String s=")()())";
        System.out.println(t.longestValidParentheses(s));
    }
}
