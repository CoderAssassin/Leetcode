import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Aliyang
 * @Data: Created in 下午5:25 18-6-19
 * longest-substring-without-repeating-characters：别人解法
 * 思路：又一次理解错，以为出现重复直接从当前i往后继续找，其实需要的是从前边的没重复的位置移动到和当前i的字符相同的字符的位置往后
 **/
public class T146 {

    public int lengthOfLongestSubstring(String s) {

        if (s==null||s.length()==0)
            return 0;

        Map<Character,Integer> map=new HashMap<>();//记录i之前出现某个字符的次数
        int max=0;
        int leftBound=0;
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            leftBound=Math.max(leftBound,(map.containsKey(c))?map.get(c)+1:0);
            max=Math.max(max,i-leftBound+1);
            map.put(c,i);
        }

        return max;
    }

    public static void main(String[] args){
        T146 t=new T146();
        String s="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        System.out.println(t.lengthOfLongestSubstring(s));
    }
}
