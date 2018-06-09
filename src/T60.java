import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:52 18-6-9
 * gray-code:别人解法
 * 思路:从1到n遍历,存储结果,n增加后,从后往前遍历,将数都往前移动1位
 **/
public class T60 {

    public ArrayList<Integer> grayCode(int n) {

        ArrayList<Integer> res=new ArrayList<>();
        res.add(0);
        if (n<=0)
            return res;

        for (int i=0;i<n;i++){
            int hight_bit=1<<i;//当前应该进几位
            for (int j=res.size()-1;j>=0;j--){//将前面所有的数反着遍历,每个数前边加一个1
                res.add(hight_bit|res.get(j));
            }
        }

        return res;
    }

    public static void main(String[] args){
        T60 t=new T60();
        ArrayList<Integer> res=t.grayCode(0);
        for (Integer a:res)
            System.out.print(a+",");
    }
}
