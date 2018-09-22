package zhaoshangyinhang;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:51 18-9-16
 **/
public class T3 {

    public static String res="";
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            int count=0;
            for (int i=1;i<=N;i++){
                if (judge(i)){
                    int now=Integer.valueOf(res);
                    if (now!=i){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean judge(int n){
        String a=String.valueOf(n);
        res="";
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)=='0'||a.charAt(i)=='1'||a.charAt(i)=='8'){
                res+=a.charAt(i);
            }else if (a.charAt(i)=='2'){
                res+="5";
            }else if (a.charAt(i)=='5'){
                res+="2";
            }else if (a.charAt(i)=='6'){
                res+="9";
            }else if (a.charAt(i)=='9'){
                res+="6";
            }else return false;
        }
        return true;
    }
}
