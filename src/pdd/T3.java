package pdd;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:40 18-8-30
 **/
public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        Map<Integer, Integer> mp = new TreeMap<>();
        a %= b;
        for (int i = 0; ;i++) {
            int x = a % b;
            if (x == 0) {
                System.out.println(i + " 0");
                break;
            }
            Integer t = mp.get(x);
            if (t != null) {
                System.out.printf("%d %d\n", t, i - t);
                break;
            }
            mp.put(x, i);
            a = x * 10;
        }
    }
}
