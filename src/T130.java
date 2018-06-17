/**
 * @Author:Aliyang
 * @Data: Created in 下午2:41 18-6-17
 * remove-nth-node-from-end-of-list：我的解法
 * 思路：快指针先走n步，然后快慢指针一起走
 **/
public class T130 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast=head;
        ListNode slow=head;
        while (n>0&&fast!=null){
            fast=fast.next;
            n--;
        }
        if (fast==null&&n==0)
            return head.next;

        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public static void main(String[] args){
        T130 t=new T130();
        ListNode head=new ListNode(1);
        ListNode realHeal=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(5);
        head=head.next;

        ListNode res=t.removeNthFromEnd(realHeal,5);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }

    }
}
