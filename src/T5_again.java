/**
 * @Author:Aliyang
 * @Data: Created in 下午2:22 18-7-5
 * insertion-sort-list：二刷
 **/
public class T5_again {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode insertionSortList(ListNode head) {

        if (head==null||head.next==null)
            return head;

        ListNode tmpHead=head;
        ListNode newHead=new ListNode(-1);
        newHead.next=tmpHead;
        tmpHead=tmpHead.next;
        newHead.next.next=null;
        while (tmpHead!=null){
            ListNode pre=newHead,nowHead=newHead.next;
            while (nowHead!=null&&nowHead.val<tmpHead.val){
                pre=pre.next;
                nowHead=nowHead.next;
            }
            ListNode next=tmpHead.next;
            tmpHead.next=pre.next;
            pre.next=tmpHead;
            tmpHead=next;
        }
        return newHead.next;
    }

    public static void main(String[] args){
        T5_again t=new T5_again();
        ListNode head=new ListNode(3);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(4);
//        head=head.next;
//        head.next=new ListNode(2);
//        head=head.next;
//        head.next=new ListNode(1);
        ListNode res=t.insertionSortList(realHead);
        while (res!=null){
            System.out.print(res.val);
            res=res.next;
        }
    }
}
