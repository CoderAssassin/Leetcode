import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午9:19 18-6-12
 * insert-interval：我的解法
 * 思路：用一个最多保持1个数的栈来模拟
 **/
public class T93 {

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> res=new ArrayList<>();

        if (intervals==null||intervals.size()==0){
            res.add(newInterval);
            return res;
        }

        Stack<Interval> stack=new Stack<>();
        boolean flag=false;//区间是否已经合并进去

        for (int i=0;i<=intervals.size();i++){

            Interval pre=null;
            if (flag==false&&!stack.isEmpty()){//如果新的区间还没有和原来的进行结合并且栈中已经有数
                pre=stack.peek();
//                区间结合
                if (newInterval.start<=pre.end){
                    if (newInterval.end>=pre.start){
                        pre.start=Math.min(newInterval.start,pre.start);
                        pre.end=Math.max(newInterval.end,pre.end);
                        stack.pop();
                        stack.push(pre);
                        flag=true;
                    }else {//此时新区间完全在左边
                        flag=true;
                        res.add(newInterval);
                    }
                }
            }

            if (i==intervals.size()&&!stack.isEmpty()){//当到达最后一个数的时候，此时新区间要加到最后
                res.add(stack.pop());
                if (flag==false)
                    res.add(newInterval);
                break;
            }

            Interval now=intervals.get(i);
            if (stack.isEmpty()){//如果当前栈为空，即当前是第一个元素
                stack.push(now);
                continue;
            }else {
                pre=stack.peek();
            }
            if (now.start<=pre.end&&newInterval.end>=pre.start){
                pre.start=Math.min(pre.start,now.start);
                pre.end=Math.max(pre.end,now.end);
                stack.pop();
                stack.push(pre);
            }else {
                res.add(pre);
                stack.pop();
                stack.push(now);
            }
        }
        return res;
    }

    public static void main(String[] args){
        T93 t=new T93();
        ArrayList<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,5));
//        intervals.add(new Interval(3,5));
//        intervals.add(new Interval(6,7));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(12,16));
        Interval newInterval=new Interval(0,0);
        ArrayList<Interval> res=t.insert(intervals,newInterval);
        for (Interval i:res){
            System.out.print("["+i.start+","+i.end+"],");
        }
    }
}
