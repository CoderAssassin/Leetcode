import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:39 18-6-13
 * merge-intervals：我的解法
 * 思路：先按开始时间排个序，然后类似T93的做法，更简单
 **/
public class T94 {

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

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
        T94 t=new T94();
        ArrayList<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        ArrayList<Interval> res=t.merge(intervals);
        for (Interval i:res)
            System.out.print("["+i.start+","+i.end+"],");
    }
}
