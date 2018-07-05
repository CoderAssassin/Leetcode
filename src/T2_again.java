import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:31 18-7-5
 * evaluate-reverse-polish-notation：二刷
 **/
public class T2_again {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<tokens.length;i++){
            String c=tokens[i];
            if (c.charAt(c.length()-1)>='0'&&c.charAt(c.length()-1)<='9'){//输入的是数字
                stack.push(Integer.valueOf(c));
            }else {//输入的不是数字
                if (stack.size()<2)
                    return 0;
                else {
                    int a=stack.pop();
                    int b=stack.pop();
                    switch (c){
                        case "+":
                            stack.push(a+b);break;
                        case "-":
                            stack.push(b-a);break;
                        case "*":
                            stack.push(a*b);break;
                        case "/":
                            stack.push(b/a);break;
                    }
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        T2_again t=new T2_again();
        String[] tokens={"4", "13", "5", "/", "+"};
        System.out.println(t.evalRPN(tokens));
    }
}
