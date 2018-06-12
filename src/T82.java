/**
 * @Author:Aliyang
 * @Data: Created in 下午3:11 18-6-12
 * plus-one：我的解法
 * 思路：分两种情况，一种是非全都是9的，还有是全都是9的，设置一个进位，若全都是9最后要复制到另一个数组
 **/
public class T82 {

    public int[] plusOne(int[] digits) {
        if (digits==null)
            return null;

        int jinwei=1;

        for (int i=digits.length-1;i>=0;i--){

            int tmp=jinwei;
            jinwei=(digits[i]+jinwei)/10;
            digits[i]=(digits[i]+tmp)%10;
            if (jinwei==0)
                break;
        }
        int[] res;
        if (jinwei==1){
//            for (int i=0;i<digits.length;i++)
//                res[i+1]=digits[i];
//            根据别人思想优化，不用复制数组。。。。。。。。。
            res=new int[digits.length+1];
            res[0]=1;
            return res;
        }else
            return digits;
    }

    public static void main(String[] args){
        T82 t=new T82();
        int[] digits=new int[]{0};
        int[] res=t.plusOne(digits);
        for (Integer a:res){
            System.out.print(a+",");
        }
    }
}
