package meituan;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:56 18-9-6
 **/
public class T3 {

    private static int res=Integer.MAX_VALUE;
    private static void dfs(boolean[] flag,int[][] arr,int pre,int now_count,int N,int nowDist){

        if (now_count>N){
            if (nowDist<res)
                res=nowDist;
            return;
        }

        boolean flag1=false;
        boolean first=false;
        int tmp=N;
        for (int i=pre+1;i<tmp;i++){
            if (arr[pre][i]==0)
                continue;
            if (!flag[i]){
                flag[i]=true;
                flag1=true;
                now_count++;
            }
            nowDist+=1;
            if (nowDist<=res){
                dfs(flag,arr,i,now_count,N,nowDist);
            }

            if (flag1){
                flag[i]=false;
                flag1=false;
                now_count--;
            }
            nowDist-=1;
            if (i==N-1&&!first){
                first=true;
                i=-1;
                tmp=pre;
            }
        }

    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            int[][] arr=new int[N][N];

            for (int i=0;i<N-1;i++){
                int X=sc.nextInt();
                int Y=sc.nextInt();
                arr[X-1][Y-1]=1;
                arr[Y-1][X-1]=1;
            }

            boolean[] flag=new boolean[N];
            dfs(flag,arr,0,0,N,0);
            System.out.println(res);
        }
    }
}
