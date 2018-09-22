package neteasy;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午12:57 18-8-11
 * BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 **/
public class T1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] interest=new int[n];
        int[] qingxing=new int[n];
        for (int i=0;i<n;i++)
            interest[i]=sc.nextInt();
        for (int i=0;i<n;i++)
            qingxing[i]=sc.nextInt();

        int max=0,max_xing=0;
        int res=Integer.MIN_VALUE;
        int count=0;//叫醒后的剩余时间
        for (int i=0;i<n;i++){
            if (qingxing[i]==1)
                max+=interest[i];
        }

        for (int i=0;i<n;i++){
            if (qingxing[i]==1)
                continue;
            int j=0;
            while (j<k&&i+j<n){
                if (qingxing[i+j]==1){
                    j++;
                    continue;
                }
                max_xing+=interest[i+j];
                j++;
            }
            if (max_xing>res){
                res=max_xing;
            }
            max_xing=0;
        }
        System.out.println(max+res);
    }
}
