package xc;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:22 18-9-4
 **/
public class T1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            long num=sc.nextLong();
            int count=0;
            char[] cs=Long.toBinaryString(num).toCharArray();
            for (int i=0;i<cs.length;i++){
                if (cs[i]=='1')
                    count++;
            }
            System.out.println(count);
        }
    }
}
