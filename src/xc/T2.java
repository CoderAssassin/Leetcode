package xc;

import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午7:29 18-9-4
 **/
public class T2 {

    static class Order{
        String orderId;
        String sTime;
        String eTime;
        public Order(String orderId,String sTime,String eTime){
            this.orderId=orderId;
            this.sTime=sTime;
            this.eTime=eTime;
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int nums=sc.nextInt();
            String time=sc.next();
            Order[] orders=new Order[nums];
            for (int i=0;i<nums;i++){
                Order tmp=new Order(sc.next(),sc.next(),sc.next());
                orders[i]=tmp;
            }

            int count=0;
            List<String> res=new ArrayList<>();
            for (int i=0;i<nums;i++){
                if (orders[i].sTime.compareTo(time)<=0&&orders[i].eTime.compareTo(time)>=0){
                    res.add(orders[i].orderId);
                    count++;
                }
            }
            Collections.sort(res);
            if (res.size()==0){
                System.out.println("null");
                continue;
            }
            for (int i=0;i<count;i++)
                System.out.println(res.get(i));



//            Arrays.sort(orders, new Comparator<Order>() {
//                @Override
//                public int compare(Order o1, Order o2) {
//                    if (o1.sTime.compareTo(o2.sTime)<0)
//                        return -1;
//                    else if (o1.sTime.compareTo(o2.sTime)==0)
//                        return 0;
//                    else return 1;
//                }
//            });
//
//            int startFirst=-1,endLast=-1;
//            int start=0,end=nums-1;
//            while (start<=end){
//                int mid=(start+end)/2;
//                if (orders[mid].sTime.compareTo(time)<=0&&orders[mid].eTime.compareTo(time)>=0){
//                    int tmp=mid;
//                    while (start<=tmp){
//                        if (orders[tmp].sTime.compareTo(time)<=0&&orders[tmp].eTime.compareTo(time)>=0)
//                            startFirst=tmp;
//                        else break;
//                        tmp--;
//                    }
//                    tmp=mid;
//                    while (tmp<=end){
//                        if (orders[tmp].sTime.compareTo(time)<=0&&orders[tmp].eTime.compareTo(time)>=0)
//                            endLast=tmp;
//                        else break;
//                        tmp++;
//                    }
//                    break;
//                }else if (orders[mid].eTime.compareTo(time)<0){
//                    start=mid+1;
//                }else if (orders[mid].sTime.compareTo(time)>0){
//                    end=mid-1;
//                }
//            }
//            String[] res=new String[endLast-startFirst+1];
//            if (startFirst==-1||endLast==-1){
//                System.out.println("null");
//                continue;
//            }else {
//                for (int i=startFirst;i<=endLast;i++)
//                    res[i-startFirst]=orders[i].orderId;
//            }
//
//            Arrays.sort(res);
//            for (int i=0;i<endLast-startFirst+1;i++)
//                System.out.println(res[i]);
//
        }
    }
}
