/**
 * @Author:Aliyang
 * @Data: Created in 下午3:07 18-7-5
 * reorder-list：二刷
 **/
public class T8_again {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public void reorderList(ListNode head) {
        if (head==null||head.next==null)
            return;

        ListNode fast=head.next,slow=head;
        while (fast!=null&&fast.next!=null){//找中点
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode rightHead=new ListNode(-1);
        ListNode pre=slow;
        slow=slow.next;
        pre.next=null;
        while (slow!=null){//右半部分翻转
            ListNode tmp=rightHead.next;
            rightHead.next=slow;
            slow=slow.next;
            rightHead.next.next=tmp;
        }

        rightHead=rightHead.next;
        while (rightHead!=null){
            ListNode tmp=head.next;
            head.next=rightHead;
            rightHead=rightHead.next;
            head.next.next=tmp;
            head=head.next.next;
        }
    }

    public static void main(String[] args){
        T8_again t=new T8_again();
        ListNode head=new ListNode(1);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);

        t.reorderList(realHead);
        while (realHead!=null){
            System.out.print(realHead.val+",");
            realHead=realHead.next;
        }
    }
}
