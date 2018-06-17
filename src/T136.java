import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:58 18-6-17
 * roman-to-integer：我的解法
 * 思路：找个表对照下
 **/
public class T136 {

    public int romanToInt(String s) {

        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('X',10);
        map.put('C',100);
        map.put('M',1000);
        map.put('V',5);
        map.put('L',50);
        map.put('D',500);

        Map<Character,Integer> indic=new HashMap<>();
        indic.put('I',0);
        indic.put('X',2);
        indic.put('C',4);
        indic.put('M',6);
        indic.put('V',1);
        indic.put('L',3);
        indic.put('D',5);

        int sum=0;
        char pre='I';
        for (int i=s.length()-1;i>=0;i--){
            int count=1;
            while (i>0&&s.charAt(i-1)==s.charAt(i)){
                i--;
                count++;
            }
            if (indic.get(s.charAt(i))<indic.get(pre)){
                sum-=count*map.get(s.charAt(i));
            }else {
                sum+=count*map.get(s.charAt(i));
            }
            pre=s.charAt(i);
        }
        return sum;
    }

    public static void main(String[] args){
        T136 t=new T136();
        String s="DCXXI";
        System.out.println(t.romanToInt(s));
    }
}
