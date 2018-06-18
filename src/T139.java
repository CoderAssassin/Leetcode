/**
 * @Author:Aliyang
 * @Data: Created in 上午11:15 18-6-18
 * regular-expression-matching：别人解法
 * 思路：
 * 如果pattern为空，str也为空，返回true，否则返回false
 * 如果pattern的长度为1，str的长度也为1，两个字符相同或者pattern为 '.' 则返回true，否则返回false
 * 如果pattern第二个字符不为'*' ，s长度为空返回false，否则，如果第一个字符相同或者p的第一个为 '.' 则递归比较s.subString(1) p.subString(1)，否则返回false
 * 如果pattern第二个字符为 '*' ，如果s不为空并且s和p第一个字符相同的时候：
 *      匹配零次：递归比较s和p.subString(2)，如果匹配成功返回true
 *      匹配多次：将s向前移动一个字符进行匹配
 * 如果s为空或者s、p第一个字符不匹配，递归匹配s和p.subString(2)
 **/
public class T139 {

    public boolean isMatch(String s, String p) {
        return match(s,p);
    }

//    从后往左匹配
private boolean match (String s, String p) {
    if (p.length() ==0) {
        return s.length() == 0;
    }
    if (p.length() == 1) {
        if (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            return true;
        }
        return false;
    }
    if (p.charAt(1) != '*') {
        if (s.length() == 0) {
            return false;
        }
        return p.charAt(0) == '.' || p.charAt(0) == s.charAt(0) ? isMatch(s.substring(1), p.substring(1)) : false;
    }

    while (s.length() != 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }

    public static void main(String[] args){
        T139 t=new T139();
        String s="ab";
        String p=".*c";
        System.out.println(t.isMatch(s,p));
    }
}
