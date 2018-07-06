/**
 * @Author:Aliyang
 * @Data: Created in 下午4:15 18-7-6
 * single-number-ii：二刷
 **/
public class T14_again {

    public int singleNumber(int[] A) {

        int one=0,two=0,three=0;//分别表示一进制、二进制和三进制
        for (int i=0;i<A.length;i++){
            int jinwei=one&A[i];//哪些位达到2
            two=two|jinwei;//原来two位置为1或者新的进位都使二进制为1
            one=one^A[i];//和原来one位置不同时为1的位置设为新的1的位置
            three=one&two;
//            接下来更新one和two
            one=one&(~three);
            two=two&(~three);
        }
        return one;
    }

    public static void main(String[] args){
        T14_again t=new T14_again();
        int[] A={0,1,0,1,0,1,99};
        System.out.println(t.singleNumber(A));
    }
}
