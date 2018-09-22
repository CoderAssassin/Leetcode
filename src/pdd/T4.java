package pdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:30 18-8-30
 **/
public class T4 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        char[][] vocabularies = new char[N][L];

        int i=0;
        char[] arr;
        for (i = 0; i < N; i++)
        {
            String tmp=sc.next();
            arr = tmp.toCharArray();
            for (int j = 0; j < arr.length; j++)
            {
                vocabularies[i][j] = arr[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < L; i++)
        {
            arr = new char[N];
            for (int j = 0; j < N; j++)
            {
                arr[j] = vocabularies[j][i];
            }
            Arrays.sort(arr);
            sb.append(arr[0]);
        }
        System.out.println(sb.toString());
    }
}
