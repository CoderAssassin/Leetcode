/**
 * @Author:Aliyang
 * @Data: Created in 下午6:17 18-6-12
 * rotate-list：我的解法
 * 思路：用一个快指针走k步找到head节点接下来应该在的位置，然后快慢指针一起往后走直到快指针到达最后一个节点，此时慢指针所在位置为结果的尾节点，慢指针的
 * 下一个节点为结果的头结点
 **/
public class T89 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head==null)
            return null;
        if (n==0||head.next==null)
            return head;

        ListNode fast=head;
        ListNode slow=head;

//        找到第一个节点应该移动到的位置
        for (int i=0;i<n;i++){
            if (fast.next==null)
                fast=head;
            else fast=fast.next;
        }

        if (fast==head)//没有发生移动
            return head;

        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode res=slow.next;
        slow.next=null;
        fast.next=head;
        return res;
    }

    public static void main(String[] args){
        T89 t=new T89();
        ListNode head=new ListNode(1);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
//        head.next=new ListNode(3);
//        head=head.next;
//        head.next=new ListNode(4);
//        head=head.next;
//        head.next=new ListNode(5);
//        head=head.next;

        ListNode res=t.rotateRight(realHead,2);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }

    }

}
