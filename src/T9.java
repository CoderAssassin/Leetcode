/**
 * @author aliyang
 * @date 18-5-29 下午5:03
 * linked-list-cycle-ii：我的解法
 * 思路：快慢指针，快指针一次走两步，慢指针一次走一步，第一次相遇的时候，将快指针或者慢指针设为头节点，再次相遇的时候即为循环开始节点
 */
public class T9 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null)
            return null;

//        设置快慢指针
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&&fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast)
                break;
        }
        if (fast==null||fast.next==null)
            return null;
        fast=head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args){
        T9 t=new T9();
        ListNode head=new ListNode(0);
        ListNode real_head=head;
        head.next=new ListNode(1);
        head=head.next;
        head.next=new ListNode(2);
        head=head.next;
        ListNode begin=head;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=begin;
        ListNode res=t.detectCycle(real_head);
        System.out.println(res.val);
    }
}
