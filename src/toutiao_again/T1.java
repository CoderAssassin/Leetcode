package toutiao_again;
import java.util.*;

public class T1 {

    public static int[] friend = new int[1000];

    public static int find(int x) {
        int i, j, r;
        r = x;
        while (friend[r] != r) {
            r = friend[r];
        }
        i = x;
        while (i != r) {
            j = friend[i];
            friend[i] = r;
            i = j;
        }
        return r;
    }

    public static void join(int x, int y) {
        int t = find(x);
        int h = find(y);
        if (t < h)
            friend[h] = t;
        else
            friend[t] = h;
    }

    public static int friends(int n, int m, int[][] r) {
        int i, count;
        for (i = 1; i <= n; ++i)
            friend[i] = i;
        for (i = 0; i < m; ++i)
            join(r[i][0], r[i][1]);
        count = 0;
        for (i = 1; i <= n; ++i) {
            if (friend[i] == i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = new int[100000][2];
        Scanner in = new Scanner(System.in);
        String nn = in.nextLine();
        int n = Integer.valueOf(nn);
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++)
        {
            String string = in.nextLine();
            String[] a = string.split(" ");
            for (int j = 0; j < a.length; j++)
            {
                int a1 = Integer.valueOf(a[j]);
                if(a1!=0)
                {
                    arr[count][0] = i;
                    arr[count][1] = a1;
                    sum++;
                }
                if(a1==0)
                {
                    arr[count][0] = i;
                    arr[count][1] = i;
                    sum++;
                }
                count++;
            }
        }
        System.out.println(friends(n, count, arr));
    }
}