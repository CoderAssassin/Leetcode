package pdd;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:02 18-8-30
 **/
public class T1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int HP=sc.nextInt();
            int normalAttack=sc.nextInt();
            int buffedAttack=sc.nextInt();

            if (normalAttack*2>=buffedAttack){
                if (normalAttack>=HP)
                    System.out.println(1);
                else
                    System.out.println(HP%normalAttack==0?HP/normalAttack:HP/normalAttack+1);
            }
            else {
                if (normalAttack>=HP){
                    System.out.println(1);
                    continue;
                }
                if (buffedAttack>=HP){
                    System.out.println(2);
                    continue;
                }
                int tmp=HP/buffedAttack;
                HP-=tmp*buffedAttack;
                tmp*=2;
                if (HP>0){
                    if (normalAttack>=HP)
                        tmp=tmp+HP%normalAttack==0?HP/normalAttack:HP/normalAttack+1;
                    else tmp+=2;
                }
                System.out.println(tmp);
            }
        }
    }
}
