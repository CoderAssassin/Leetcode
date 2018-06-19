/**
 * @Author:Aliyang
 * @Data: Created in 下午1:00 18-6-18
 * palindrome-number：我的解法
 * 思路：注意这里要用long，不然会溢出。先用hight不断地除x，直到为0，知道了位数，然后从高位往低位，从低位往高位不断取数比较，负数不是回文数
 **/
public class T140 {

    public boolean isPalindrome(int x) {

        if (x<0)
            return false;

        int y=x;
        int count=0;
        long hight=1,low=1;
        while (y!=0){
            y/=10;
            count++;
            hight*=10;
        }
        for (int i=0;i<count/2;i++){
            long a=x%hight/(hight/10);//高位的数
            long b=x/low%10;//低位的数
            if (a!=b)
                return false;
            hight/=10;
            low*=10;
        }
        return true;
    }

    public static void main(String[] args){
        T140 t=new T140();
        System.out.println(t.isPalindrome(1000000001));
    }
}
