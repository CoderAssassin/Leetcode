package tongcheng58;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:54 18-9-15
 **/
public class T1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int t=sc.nextInt();
            while (t-->0){
                int A=sc.nextInt();
                int B=sc.nextInt();
                int C=sc.nextInt();

                if (C==0){
                    System.out.println("YES");
                    continue;
                }

                int index=1;
                boolean flag=false;
                while (index<=100){
                    if ((A*index)%B==C){
                        flag=true;
                        break;
                    }
                    index++;
                }
                if (flag){
                    System.out.println("YES");
                    continue;
                }else {
                    System.out.println("NO");
                }


//                int m=A%B;
//                if (m==0)
//                    System.out.println("NO");
//                else if (m==C||m==1){
//                    System.out.println("YES");
//                }else{
//                    if (m%2==0&&C%2!=0||m%2!=0&&C%2==0)
//                        System.out.println("YES");
//                    else System.out.println("NO");
//                }
            }
        }
    }
}
