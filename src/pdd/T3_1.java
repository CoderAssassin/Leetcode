package pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:44 18-8-30
 **/
public class T3_1 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            a=a%b;
            cal(a,b);
        }
    }

    public static void cal(int a, int b)
    {
        List shang = new ArrayList();  //商
        List yushu = new ArrayList();  //余数

        int start = - 1;//循环节的起始位置
        while(true)
        {
            a=a*10;
            shang.add(a/b);
            int tmp = a % b;
            if(tmp == 0) break;

            start = yushu.indexOf(tmp);

            if(start >= 0) break;
            else
                yushu.add(tmp);
            a=tmp;

//            a = tmp*10;
        }
        System.out.println(start+" "+(shang.size()-1));
    }
}
