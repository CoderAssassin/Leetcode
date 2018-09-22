package toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午11:34 18-8-12
 **/
public class T2 {

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> res=new ArrayList<>();
        if (intervals.size()==0)
            return res;

        Collections.sort(intervals, new Comparator<Interval>() {//按开始时间先排个序
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        Interval pre=intervals.get(0);
        for (int i=1;i<=intervals.size();i++){
            if (i==intervals.size()){
                res.add(pre);
                break;
            }
            Interval now=intervals.get(i);
            if (now.start<=pre.end){
                pre.start=Math.min(pre.start,now.start);
                pre.end=Math.max(pre.end,now.end);
            }else {
                res.add(pre);
                pre=now;
            }
        }
        return res;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int m;
        m=sc.nextInt();
        sc.nextLine();
        ArrayList<Interval> intervals=new ArrayList<>();
        for (int i=0;i<m;i++){
            String tmp=sc.nextLine();
            String[] tmp1=tmp.split(";");
            for (int j=0;j<tmp1.length;j++){
                String[] tmp2=tmp1[j].split(",");
                Interval in=new Interval(Integer.parseInt(tmp2[0]),Integer.parseInt(tmp2[1]));
                intervals.add(in);
            }
        }
        ArrayList<Interval> res=merge(intervals);
        for (int i=0;i<res.size();i++){
            if (i==0)
                System.out.print(res.get(i).start+","+res.get(i).end);
            else System.out.print(";"+res.get(i).start+","+res.get(i).end);
        }
        System.out.println();
    }
}
