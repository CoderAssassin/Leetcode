
/**
 * @Author:Aliyang
 * @Data: Created in 下午7:29 18-6-17
 * integer-to-roman：我的解法
 * 思路：设置一个映射组
 **/
public class T137 {

    public String intToRoman(int num) {

        int[] base = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                "V", "IV", "I" };
        String roman = "";
        int i = 0;
        while (num != 0) {
            if (num >= base[i]) {
                num -= base[i];
                roman += str[i];
            } else
                i++;
        }
        return roman;

    }
}
