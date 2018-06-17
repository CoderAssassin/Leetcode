import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午12:07 18-6-17
 * generate-parentheses：别人解法
 * 思路：左括号的个数一定大于等于右括号的个数，因为若左括号的个数小于右括号的个数，那么起码有一个右括号匹配不到左括号；当左括号个数大于右括号的时候，打印
 * 左括号，当右括号个数大于左括号的时候打印右括号
 **/
public class T128 {
    public ArrayList<String> generateParenthesis(int n) {

        ArrayList<String> res=new ArrayList<>();
        if (n==0)
            return res;
        String s="";
        generate(n,n,s,res);
        return res;
    }

    void generate(int leftNum,int rightNum,String s,ArrayList<String> result)
    {
        if(leftNum==0&&rightNum==0)//左和右的括号个数都为0的时候说明打印完
        {
            result.add(s);
        }
        if(leftNum>0)//如果左边还有括号，打印左括号
        {
            generate(leftNum-1,rightNum,s+'(',result);
        }
        if(rightNum>0&&leftNum<rightNum)//如果左括号数小于右括号数，那么打印右括号
        {
            generate(leftNum,rightNum-1,s+')',result);
        }
    }

    public static void main(String[] args){
        T128 t=new T128();
        ArrayList<String> res=t.generateParenthesis(3);
        for (String s:res)
            System.out.print(s+",");
    }
}
