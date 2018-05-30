import java.util.Arrays;
import java.util.Collections;

/**
 * @author aliyang
 * @date 18-5-30 下午4:08
 * single-number-ii:别人解法
 * 思路：
 * Single Number的本质，就是用一个数记录每个bit出现的次数，如果一个bit出现两次就归0，
 * 这种运算采用二进制底下的位操作^是很自然的。Single Number II中，如果能定义三进制底下的某种位操作，
 * 也可以达到相同的效果，Single Number II中想要记录每个bit出现的次数，一个数搞不定就加两个数，
 * 用ones来记录只出现过一次的bits，用twos来记录只出现过两次的bits，ones&twos实际上就记录了出现过三次的bits，
 * 这时候我们来模拟进行出现3次就抵消为0的操作，抹去ones和twos中都为1的bits。
 */
public class T14 {

    public int singleNumber(int[] A) {
        int ones=0;//记录所有出现过一次的位
        int twos=0;//记录所有出现过两次的位
        int threes;
        for (int i=0;i<A.length;i++){
            int t=A[i];
            twos |= ones&t;//ones&t结果的位上表示出现两次的位，那么用twos非该值即为出现两次的位
            ones^=t;//异或得到的值即为只出现一次的位
            threes=ones&twos;//出现一次与上出现两次的位即为出现三次的位
            ones&=~threes;//ones与上没有出现三次的即为出现一次的位
            twos&=~threes;//同上
        }
        return ones;
    }
}
