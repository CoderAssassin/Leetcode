//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author aliyang
// * @date 18-5-28 下午8:33
// * max-points-on-a-line：别人解法
// * 思路：双重循环，map记录相同斜率的点的个数
// */
//public class T3 {
//
//      class Point {
//          int x;
//          int y;
//          Point() { x = 0; y = 0; }
//          Point(int a, int b) { x = a; y = b; }
//      }
//
//    public int maxPoints(Point[] points) {
//          if (points.length<3)
//              return points.length;
//
//          int max=0;
//          Map<Double,Integer> map=new HashMap<>();//保存相同斜率的点的个数
//          for (int i=0;i<points.length;i++){
//            map.clear();
//            int duplication=1;//记录跟固定点重合的点数
//              for (int j=0;j<points.length;j++){//求其他点与固定点之间的斜率
//                  if (i==j) continue;//自身跳过
//                  double slope=0;//斜率
//
//                  if (points[i].x==points[j].x&&points[i].y==points[j].y){//跟固定点重合
//                      duplication++;
//                      continue;
//                  }else if (points[i].x==points[j].x){//垂直
//                      slope=Integer.MAX_VALUE;
//                  }else {
//                      slope=1.0*(points[i].y-points[j].y)/(points[i].x-points[j].x);
//                  }
//                  map.put(slope,map.containsKey(slope)?map.get(slope)+1:1);
//              }
//
////              更新最优解
//              if (map.keySet().size()==0){
//                  max=duplication>max?duplication:max;
//              }else {
//                  for (double key:map.keySet()){
//                      max=Math.max((duplication+map.get(key)),max);
//                  }
//              }
//          }
//          return max;
//    }
//
//}
