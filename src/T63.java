/**
 * @Author:Aliyang
 * @Data: Created in 下午2:12 18-6-9
 * partition-list:我的解法
 * 思路:用一个虚拟头结点连着小于x的节点
 **/
public class T63 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode partition(ListNode head, int x) {

        if (head==null||head.next==null)
            return head;

        ListNode newHead=new ListNode(-1);//新的头节点
        ListNode realNewHead=newHead;
        ListNode bigHead=null;//大于等于x的第一个节点
        ListNode pre=null;//前一个大于等于x的节点
        ListNode now=head;

        while (now!=null){
            if (now.val<x){
                newHead.next=now;
                newHead=newHead.next;
                if (pre!=null){
                    pre.next=now.next;
                }
                now=now.next;
            }else {
                if (bigHead==null){
                    bigHead=now;
                    pre=now;
                }
                pre=now;
                now=now.next;
            }
        }
        newHead.next=bigHead;
        return realNewHead.next;
    }

    public static void main(String[] args){
        T63 t=new T63();
        ListNode head=new ListNode(1);
        ListNode realHead=head;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(5);
        head=head.next;
        head.next=new ListNode(2);
        head=head.next;
        ListNode res=t.partition(realHead,5);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }
    }
}
