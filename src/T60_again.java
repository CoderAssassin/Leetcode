import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:25 18-7-17
 * gray-code：二刷
 **/
public class T60_again {

    public ArrayList<Integer> grayCode(int n) {

        ArrayList<Integer> res=new ArrayList<>();
        if (n<0)
            return res;
        res.add(0);

        for (int i=0;i<n;i++){
            int trans=1<<i;//下一个高位处设为1
            for (int j=res.size()-1;j>=0;j--){//反着遍历现有的结果集，因为这样可以保证新的结果和前面的结果都只有1位不一样
                res.add(trans|res.get(j));//使得新的高位变为1，其他位不变
            }
        }
        return res;
    }

    public static void main(String[] args){
        T60_again t=new T60_again();
        ArrayList<Integer> res=t.grayCode(3);
        for (Integer a:res){
            System.out.println(a+",");
        }
    }
}
