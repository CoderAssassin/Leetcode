/**
 * @Author:Aliyang
 * @Data: Created in 下午4:56 18-6-9
 * remove-duplicates-from-sorted-list:我的解法
 * 思路:同66,稍微改进
 **/
public class T67 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null)
            return head;

        ListNode pre=null;
        ListNode now=head;
        while (now!=null){
            if (pre!=null&&pre.val==now.val){
                pre.next=now.next;
                now=now.next;
                continue;
            }
            pre=now;
            now=now.next;
        }

        return head;
    }

    public static void main(String[] args){
        T67 t=new T67();
        ListNode head=new ListNode(1);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(5);
        head=head.next;
        ListNode res=t.deleteDuplicates(realHead);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }
    }
}
