package neteasy;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午12:57 18-8-11
 **/
public class T2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int[] a=new int[n];
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=sc.nextInt();
            a[i]=sum;
        }
        int m;
        m=sc.nextInt();
        int[] q=new int[m];
        for (int i=0;i<m;i++)
            q[i]=sc.nextInt();

        for (int i=0;i<m;i++){
            int query=q[i];
            int l=0;
            int r=n-1;
            while (l<=r){
                int mid=(l+r)/2;
                if (query==a[mid]){
                    System.out.println(mid+1);
                    break;
                }else if (query>a[mid]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
            if (l>r){
                System.out.println(l+1);
            }
        }
    }
}
