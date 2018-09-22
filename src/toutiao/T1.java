package toutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:03 18-8-12
 **/
public class T1 {

    private static int count=0;
    private static void dfs(boolean[][] visit,String[][] str,int row,int col){

        if (row-1>=0&&!visit[row-1][col]&&str[row-1][col].equals("1")){
            visit[row-1][col]=true;
            count++;
            dfs(visit,str,row-1,col);
        }
        if (row+1<str.length&&!visit[row+1][col]&&str[row+1][col].equals("1")){
            visit[row+1][col]=true;
            count++;
            dfs(visit,str,row+1,col);
        }
        if (col-1>=0&&!visit[row][col-1]&&str[row][col-1].equals("1")){
            visit[row][col-1]=true;
            count++;
            dfs(visit,str,row,col-1);
        }
        if (col+1<str[0].length&&!visit[row][col+1]&&str[row][col+1].equals("1")){
            visit[row][col+1]=true;
            count++;
            dfs(visit,str,row,col+1);
        }
        if (row-1>=0&&col-1>=0&&!visit[row-1][col-1]&&str[row-1][col-1].equals("1")){
            visit[row-1][col-1]=true;
            count++;
            dfs(visit,str,row-1,col-1);
        }
        if (row+1<str.length&&col+1<str.length&&!visit[row+1][col+1]&&str[row+1][col+1].equals("1")){
            visit[row+1][col+1]=true;
            count++;
            dfs(visit,str,row+1,col+1);
        }
        if (row+1<str.length&&col-1>=0&&!visit[row+1][col-1]&&str[row+1][col-1].equals("1")){
            visit[row+1][col-1]=true;
            count++;
            dfs(visit,str,row+1,col-1);
        }
        if (row-1>=0&&col+1<str[0].length&&!visit[row-1][col+1]&&str[row-1][col+1].equals("1")){
            visit[row-1][col+1]=true;
            count++;
            dfs(visit,str,row-1,col+1);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int M,N;
        String input=sc.nextLine();
        String[] input1=input.split(",");
        M=Integer.parseInt(input1[0]);
        N=Integer.parseInt(input1[1]);
        String[][] str=new String[M][N];
        Map<Integer,Integer> res=new HashMap<>();

        boolean[][] visit=new boolean[M][N];

        for (int i=0;i<M;i++)
            str[i]=sc.nextLine().split(",");

        int num=0,max=0;

        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if (!visit[i][j]&&str[i][j].equals("1")){
                    visit[i][j]=true;
                    count=1;
                    dfs(visit,str,i,j);
                    num++;
                    if (count>max)
                        max=count;
                }
            }
        }
        System.out.println(num+","+max);
    }
}
