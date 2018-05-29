/**
 * @author aliyang
 * @date 18-5-29 下午4:24
 * reorder-list：我的解法
 * 思路：先用快慢指针找到中间节点，后边一半先设一个虚拟头结点，倒转过来，然后依次插入左边的链表中
 */
public class T8 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null)
            return;

//        快慢指针
        ListNode slow=head;
        ListNode fast=head.next;

        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }


        ListNode rightHalf=slow.next;//右半部分开头
        slow.next=null;
        ListNode rightHead=new ListNode(-1);//辅助的头结点
//        将右边链表倒过来
        while (rightHalf!=null){
            ListNode tmp=rightHead.next;
            rightHead.next=rightHalf;
            rightHalf=rightHalf.next;
            rightHead.next.next=tmp;
        }

        rightHead=rightHead.next;
//        遍历右边列表，依次插入左边列表中
        while (rightHead!=null){
            ListNode tmp=head.next;
            head.next=rightHead;
            rightHead=rightHead.next;
            head.next.next=tmp;
            head=head.next.next;
        }
    }

    public static void main(String[] args){
        T8 t=new T8();
        ListNode root=new ListNode(0);
        ListNode real_root=root;
        root.next=new ListNode(2);
        root=root.next;
        root.next=new ListNode(4);
        root=root.next;
        root.next=new ListNode(5);
        root=root.next;
        root.next=new ListNode(3);
        root=root.next;
        root.next=new ListNode(1);
        root=root.next;
        t.reorderList(real_root);
        while (real_root!=null){
            System.out.print(real_root.val+",");
            real_root=real_root.next;
        }
    }
}
