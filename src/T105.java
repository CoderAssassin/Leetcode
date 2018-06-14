/**
 * @Author:Aliyang
 * @Data: Created in 上午10:19 18-6-14
 * jump-game-ii：我的解法
 * 思路：类似T95，就是返回是个计数
 **/
public class T105 {

    public int jump(int[] A) {

        if (A.length==0)
            return 0;
        if (A.length==1&&A[0]!=0)
            return 0;
        if (A[0]==0)
            return 0;

        int count=0;

        int remined=A.length-1;//总剩余步数
        int position=0;//当前位置

        while (remined>0){
            int minIndex=-1;//记录接下来的位置
            int minStep=remined;//当前位置到终点剩余步数
            if (remined-position-A[position]<=0)
                return count+1;
            for (int i=position+1;i<=position+A[position];i++){//判断接下来往哪里跳
                if (remined-i-A[i]<minStep){
                    if (A[i]==0)//如果要跳的地方是0，那么忽略，不能跳
                        continue;
                    minIndex=i;
                    minStep=remined-i-A[i];
                }
            }
            if (minStep==0)
                return count+2;
            if (minIndex==-1)//接下来没有地方可跳，即要跳的位置都是0
                return 0;
            position=minIndex;
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        T105 t=new T105();
        int[] A=new int[]{0};
        System.out.println(t.jump(A));
    }
}
