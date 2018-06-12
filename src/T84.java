/**
 * @Author:Aliyang
 * @Data: Created in 下午3:38 18-6-12
 * add-binary：我的解法
 * 思路：设个进位标志，从右到左逐渐相加
 **/
public class T84 {

    public String addBinary(String a, String b) {

        String res="";
        int jinwei=0;

        int i=a.length()-1,j=b.length()-1;

        while (i>=0&&j>=0){

            int numa=a.charAt(i)-'0';
            int numb=b.charAt(j)-'0';

            int tmp=jinwei;
            jinwei=(numa+numb+tmp)/2;
            numa=(numa+numb+tmp)%2;
            res=numa+res;

            i--;
            j--;
        }

        while (i>=0){
            int numa=a.charAt(i)-'0';
            if (jinwei!=0){
                int tmp=jinwei;
                jinwei=(numa+tmp)/2;
                numa=(numa+tmp)%2;
                res=numa+res;
            }
            else res=numa+res;
            i--;
        }
        while (j>=0){
            int numb=b.charAt(j)-'0';
            if (jinwei!=0){
                int tmp=jinwei;
                jinwei=(numb+tmp)/2;
                numb=(numb+tmp)%2;
                res=numb+res;
            }
            else res=numb+res;
            j--;
        }
        if (jinwei==1)
            res=1+res;
        return res;
    }

    public static void main(String[] args){
        T84 t=new T84();
        String a="110010";
        String b="10111";
        System.out.println(t.addBinary(a,b));
    }
}
