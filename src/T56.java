import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-6-6 下午10:08
 * restore-ip-addresses：我的解法
 */
public class T56 {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++)
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    if (len - k >= 4)
                        continue;
                    int a, b, c, d;
                    a = Integer.parseInt(s.substring(0, i));
                    b = Integer.parseInt(s.substring(i, j));
                    c = Integer.parseInt(s.substring(j, k));
                    d = Integer.parseInt(s.substring(k));
                    if (a > 255 || b > 255 || c > 255 || d > 255)
                        continue;
                    String ip = a + "." + b + "." + c + "." + d;
                    if (ip.length() < len + 3)
                        continue;
                    ans.add(ip);
                }
            }
        return ans;
    }
}

