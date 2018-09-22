//package meituan;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @Author:Aliyang
// * @Data: Created in 下午8:34 18-9-6
// **/
//public class T1 {
//
//    private static int shortest(int N,int v0,int[][] p,int[] D,int[][] arr){
//        int v,w,i,j,min;
//        boolean flag[]=new boolean[N];
//        for (v=0;v<N;v++){
//            flag[v]=true;
//            D[v]=arr[v0][v];
//            for (w=0;w<N;w++)
//                p[v][w]=-1;
//            if (D[v]<Integer.MAX_VALUE){
//                p[v][0]=v0;
//                p[v][1]=v;
//            }
//        }
//
//        D[v0]=0;
//        flag[v0]=true;
//
//        for (i=1;i<N;i++){
//            min=Integer.MAX_VALUE;
//            for (w=0;w<N;w++){
//                if (!flag[w]&&D[w]<min){
//                    v=w;
//                    min=D[w];
//                }
//            }
//            flag[v]=true;
//            for (w=0;w<N;w++){
//                if (!flag[w]&&min<Integer.MAX_VALUE&&arr[v][w]<Integer.MAX_VALUE
//                        &&min+arr[v][w]<D[w]){
//                    D[w]=min+arr[v][w];
//                    for (j=0;j<N;j++){
//                        p[w][j]=p[v][j];
//                        if (p[w][j]==-1){
//                            p[w][j]=w;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//
//    }
//
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNext()){
//            int N=sc.nextInt();
//            int[][] arr=new int[N][N];
//
//            for (int i=0;i<N;i++){
//                Arrays.fill(arr[i],Integer.MAX_VALUE);
//                arr[i][i]=0;
//            }
//
//            for (int i=0;i<N-1;i++){
//                int X=sc.nextInt();
//                int Y=sc.nextInt();
//                arr[X-1][Y-1]=1;
//                arr[Y-1][X-1]=1;
//            }
//            int[][] p=new int[N][N];
//            int[] D=new int[N];
//            System.out.println(shortest(N,1,p,D,arr));
//        }
//    }
//}
