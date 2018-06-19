/**
 * @Author:Aliyang
 * @Data: Created in 上午10:49 18-6-19
 * zigzag-conversion：别人解法
 * 思路：题目没看懂，看了别人的才知道zigzag是怎么回事。斜着的一共有n-2个元素。想象除了第一行和最后一行，每个周期有两个元素
 **/
public class T143 {

    public String convert(String s, int nRows) {
        if(nRows <= 1) return s;
        String result = "";
        int cycle = 2 * nRows - 2;//每一竖行加上一个颉颃总的元素个数
        for(int i = 0; i < nRows; ++i)//行
        {
            for(int j = i; j < s.length(); j = j + cycle){//列，按周期遍历
                result = result + s.charAt(j);
                int secondJ = (j - i) + cycle - i;//每一个周期斜着的元素
                if(i != 0 && i != nRows-1 && secondJ < s.length())
                    result = result + s.charAt(secondJ);
            }
        }
        return result;
    }

    public static void main(String[] args){
        T143 t=new T143();
        String s="PAYPALISHIRING";
        System.out.println(t.convert(s,3));
    }
}
