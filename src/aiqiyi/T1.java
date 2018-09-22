package aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:49 18-9-15
 **/
public class T1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            int[] low=new int[3];
            int[] high=new int[3];
            int l=0,h=0;
            int acc_l=0,acc_h=0;
            for (int i=0;i<str.length();i++){
                if (i<3){
                    low[l++]=str.charAt(i)-'0';
                    acc_l+=low[l-1];
                }
                else {
                    high[h++]=str.charAt(i)-'0';
                    acc_h+=high[h-1];
                }
            }

            Arrays.sort(low);
            Arrays.sort(high);

            int res=0;
            if (acc_l==acc_h){
                System.out.println(res);
                continue;
            }else if (acc_l<acc_h){
                res=cal(low,high,acc_h-acc_l);
            }else {
                res=cal(high,low,acc_l-acc_h);
            }
            System.out.println(res);
        }
    }

    private static int cal(int[] low,int[] high,int diff){
        int res=0;
        int l=0,h=2;
        while (diff>0){
            if (9-low[l]<high[h]){
                res++;
                diff-=high[h--];
            }else {
                res++;
                diff=diff-(9-low[l++]);
            }
        }
        return res;
    }
}
