package bilibili;

import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:51 18-9-7
 **/
public class T1 {

    private int hasSyntaxError(String input){
        Stack<String> stack=new Stack<>();

        char[] inputs=input.toCharArray();
        int len=inputs.length;
        boolean isEndTag=false;//是否是配套的结束标签
        boolean isSelfEnd=false;//是否是自闭合

        for (int i=0;i<len;i++){
            int start=i;
            if (inputs[i]=='<'){//碰到左尖括号
                isSelfEnd=false;
                i++;
                if (i<len&&inputs[i]=='/'){
                    isEndTag=true;
                    i++;
                }
                while (i<len&&inputs[i]!='>')
                    i++;
                if (isEndTag&&inputs[i]=='>') {//是结束标签，那么和前面的配对
                    if (stack.isEmpty())//若栈为空，说明有问题
                        return 0;
                    else {
                        String pre = stack.pop();
                        int index = 0;
                        while (pre.charAt(index) != ' ' && pre.charAt(index) != '>')
                            index++;
                        if (!pre.substring(1, index).equals(input.substring(start + 2, i)))//标签不匹配
                            return 0;
                    }
                    isEndTag=false;
                    continue;
                }

//                if (inputs[i-1]=='/'&&inputs[i]=='>'){//自闭合标签，直接跳过
//                    continue;
//                }

//                剩下的情况说明是开始标签或者自闭合标签，需要检查属性
                String beginTag=input.substring(start,i+1);
                int j=0;
                while (j<beginTag.length()&&beginTag.charAt(j)!=' ')//找第一个空格或者没有
                    j++;
                String beginTag1="";
                if (j<beginTag.length())//有空格
                     beginTag1=beginTag.substring(j+1,beginTag.length()-1);//属性字符串
                else{
                    if (beginTag.charAt(beginTag.length()-2)=='/')//自闭合没有属性直接退出
                        continue;
                    stack.push(beginTag);
                    continue;
                }
                if (beginTag1.equals("")){
                    stack.push(beginTag);
                    continue;
                }
                if (beginTag1.charAt(beginTag1.length()-1)=='/'){//是自闭合
                    isSelfEnd=true;
                    beginTag1=beginTag1.substring(0,beginTag1.length()-1);
                }
//                if (beginTag1.charAt(beginTag1.length()-1)!='"'||beginTag1.charAt(beginTag1.length()-1)!=' ')
//                    return 0;
                String[] properties=beginTag1.split(" ");
                for (int k=0;k<properties.length;k++){
                    String prop=properties[k];
                    if (prop.indexOf('=')==-1)
                        return 0;
                    String[] name_Value=prop.split("=");
                    if (name_Value.length<2||name_Value[0].equals(""))
                        return 0;
                    String right=name_Value[1];
                    if (!(right.charAt(0)=='"'&&right.charAt(0)=='"'))
                        return 0;
                    for (int m=1;m<right.length()-1;m++){
                        if (right.charAt(m)=='"')
                            return 0;
                    }
                }
                if (!isSelfEnd)
                    stack.push(beginTag);
            }else return 0;
        }
        if (!stack.isEmpty())
            return 0;
        return 1;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            T1 t=new T1();
            String input=sc.nextLine();
            System.out.println(t.hasSyntaxError(input));
        }
    }
}
