import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:22 18-6-12
 * text-justification：我的解法
 * 思路：我TMD～～～～～～～～～调了1小时还是格式有问题，尼玛
 **/
public class T81 {

    public ArrayList<String> fullJustify(String[] words, int L) {

        ArrayList<String> res=new ArrayList<>();

        if (words.length==0||words==null)
            return res;

        StringBuilder sb=null;
        int count=0;
        int curLen=0;
        boolean isLast=false;//是否到最后一个单词
        for (int i=0;i<=words.length;i++){

            if (count==0)
                sb=new StringBuilder();

            if (i==words.length||curLen+words[i].length()+count>L){//如果加起来会超过一行,开始生成一行

                if (i==words.length-1&&count==0){
                    count++;
                    curLen+=words[i].length();
                    isLast=true;
                }

//                -----当count等于1的时候
                if (count==1){
                    sb.append(words[i-1]);
                    for (int j=0;j<L-curLen;j++)
                        sb.append(" ");
                    if (!(i==words.length))
                        i--;
                }else {

                    if (i==words.length){
                        sb.append(words[i-count]);
                        count--;
                        for (int j=count;j>=1;j--){
                            sb.append(" ");
                            sb.append(words[i-j]);
                        }
                        for (int j=0;j<L-curLen-count;j++)
                            sb.append(" ");
                    }else {

        //                ------当count大于1的时候
                        int space=L-curLen;//空格数
                        int more=space%(count-1);//左边的空格应该多出来的个数
                        int per=space/(count-1);//每两个单词之间的平均单词数

                        String perspace="";
                        for (int j=0;j<per;j++)
                            perspace+=" ";

        //                先处理第一个单词及之后的空格
                        sb.append(words[i-count]);
                        sb.append(perspace);
                        for (int j=0;j<more;j++)
                            sb.append(" ");
        //                处理剩下的除最后一个单词
                        for (int j=count-1;j>=2;j--){
                            sb.append(words[i-j]);
                            sb.append(perspace);
                        }
        //                处理最后一个单词
                        sb.append(words[i-1]);
                        if (i!=words.length)
                            i--;
                    }
                }
                res.add(sb.toString());
                count=0;
                curLen=0;
            }else {
                curLen+=words[i].length();
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        T81 t=new T81();
        String[] words=new String[]{"What","must","be","shall","be."};
        ArrayList<String> res=t.fullJustify(words,12);
        for (String s:res)
            System.out.println(s);
    }
}
