/**
 * @Author:Aliyang
 * @Data: Created in 上午9:57 18-6-19
 * palindrome-number：别人解法
 * 思路：低位从右往左逐渐计算数，和左边的比较
 **/
public class T140_1 {

    public boolean isPalindrome(int x) {

        if (x<0||x!=0&&x%10==0)//负数或者10的整数倍
            return false;

        int reverse=0;
        while (x>reverse){
            reverse=reverse*10+x%10;
            x=x/10;
        }
        return (reverse==x||reverse/10==x);
    }
}
