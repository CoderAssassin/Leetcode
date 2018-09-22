package pdd;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:23 18-8-30
 **/
public class T2 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            int M=sc.nextInt();
            String[] lines=new String[N];
            for (int i=0;i<N;i++)
                lines[i]=sc.next();

            for (int i=N-1;i>=0;i--){
                char[] tmp=lines[i].toCharArray();
                for (int j=0;j<M;j++){
                    if (tmp[j]=='o'){
                        int k=i+1;
                        while (k<N){
                            if (lines[k].charAt(j)=='x'||lines[k].charAt(j)=='o'){
                                if (k==i+1)
                                    break;
                                tmp[j]='.';
                                char[] tmp1=lines[k-1].toCharArray();
                                tmp1[j]='o';
                                lines[k-1]=String.valueOf(tmp1);
                                break;
                            }
                            k++;
                        }
                        if (k>=N){
                            tmp[j]='.';
                        }
                    }
                }
                lines[i]=String.valueOf(tmp);
            }

            for (int i=0;i<N;i++)
                System.out.println(lines[i]);
        }
    }
}
