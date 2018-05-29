/**
 * @author aliyang
 * @date 18-5-29 下午6:26
 * linked-list-cycle：我的解法
 * 思路：同上题，两个指针由碰撞说明有环
 */
public class T10 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {

        if (head==null||head.next==null)
            return false;

        ListNode fast=head;
        ListNode slow=head;

        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if (fast==slow)
                return true;
        }
        return false;
    }
}
