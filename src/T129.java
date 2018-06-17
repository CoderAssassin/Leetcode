import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:34 18-6-17
 * valid-parentheses：我的解法
 * 思路：简单回文判断
 **/
public class T129 {

    public boolean isValid(String s) {

        if (s.length()<2||s.length()%2!=0)
            return false;
        Stack<Character> stack=new Stack<>();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty()==true)
                    return false;
                if (s.charAt(i)==')'){
                    if (stack.peek()!='(')
                        return false;
                    else {
                        stack.pop();
                    }
                }else if (s.charAt(i)=='}'){
                    if (stack.peek()!='{')
                        return false;
                    else {
                        stack.pop();
                    }
                }else {
                    if (stack.peek()!='[')
                        return false;
                    else {
                        stack.pop();
                    }
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args){
        T129 t=new T129();
        String s="(]";
        System.out.println(t.isValid(s));
    }
}
