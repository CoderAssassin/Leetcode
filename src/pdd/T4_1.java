package pdd;

import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午9:15 18-8-30
 **/
public class T4_1 {
    static int n;
    static int l;
    static List<Set<Character>> b;
    static Set<String> st;
    static boolean flag = false;
    static void dfs(int k, StringBuilder sb) {
        if (flag) {
            return;
        }
        if (k == l) {
            if (!st.contains(sb.toString())) {
                System.out.println(sb);
                flag = true;
            }
            return;
        }
        b.get(k).forEach(character -> {
            StringBuilder ssb = new StringBuilder(sb);
            ssb.append(character);
            dfs(k + 1, ssb);
        });
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        l = in.nextInt();
        in.nextLine();
        String[] s = new String[n];
        st = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            s[i] = in.nextLine();
            st.add(s[i]);
        }
        b = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            b.add(new TreeSet<>());
        }
        for (int j = 0; j < l; j++) {
            for (int i = 0; i < n; i++) {
                b.get(j).add(s[i].charAt(j));
            }
        }
        dfs(0, new StringBuilder());
        if (!flag) {
            System.out.println("-");
        }
    }
}
