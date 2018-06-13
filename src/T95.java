/**
 * @Author:Aliyang
 * @Data: Created in 上午9:54 18-6-13
 * jump-game：我的解法
 * 思路：贪心，判断依据，当前位置接下来可走的几个位置，使得走某个位置之后剩余的步数最少的那一个，注意不能走接下来是0的位置
 **/
public class T95 {

    public boolean canJump(int[] A) {

        if (A.length<=1)
            return true;
        if (A[0]==0)
            return false;

        int remined=A.length-1;//总

        int position=0;//当前位置

        while (remined>0){
            int minIndex=-1;//记录接下来的位置
            int minStep=remined;//当前位置到终点剩余步数
            if (remined-position-A[position]<=0)
                return true;
            for (int i=position+1;i<=position+A[position];i++){//判断接下来往哪里跳
                if (remined-i-A[i]<minStep){
                    if (A[i]==0)//如果要跳的地方是0，那么忽略，不能跳
                        continue;
                    minIndex=i;
                    minStep=remined-i-A[i];
                }
            }
            if (minStep==0)
                return true;
            if (minIndex==-1)//接下来没有地方可跳，即要跳的位置都是0
                return false;
            position=minIndex;
        }
        return true;
    }

    public static void main(String[] args){
        T95 t=new T95();
        int[] A=new int[]{1,2};
        System.out.println(t.canJump(A));
    }
}
