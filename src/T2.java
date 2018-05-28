import java.util.Stack;

/**
 * @author aliyang
 * @date 18-5-28 下午8:18
 * evaluate-reverse-polish-notation：我的解法
 * 思路：借用栈
 */
public class T2 {

    public int evalRPN(String[] tokens) {

        if (tokens.length==0||tokens==null)
            return 0;

        Stack<Integer> stack=new Stack<>();
        for (String s:tokens){
            if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int num1=stack.pop();
                int num2=stack.pop();
                switch (s){
                    case "+":
                        stack.push(num2+num1);
                        break;
                    case "-":
                        stack.push(num2-num1);
                        break;
                    case "*":
                        stack.push(num2*num1);
                        break;
                    case "/":
                        stack.push(num2/num1);
                        break;
                }
                continue;
            }
            stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }

    public static void main(String[] args){
        T2 t=new T2();
        String[] tokens=new String[]{"2", "1", "+", "3", "*"};
        System.out.println(t.evalRPN(tokens));
    }
}
