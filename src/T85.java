/**
 * @Author:Aliyang
 * @Data: Created in 下午4:12 18-6-12
 * merge-two-sorted-lists：我的解法
 * 思路：一波循环
 **/
public class T85 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1==null&&l2==null)
            return null;
        if (l1==null&&l2!=null)
            return l2;
        if (l1!=null&&l2==null)
            return l1;

        ListNode res=new ListNode(-1);
        ListNode realRes=res;

        while (l1!=null||l2!=null){

            if (l1!=null&&l2!=null){
                if (l1.val<l2.val){
                    res.next=l1;
                    l1=l1.next;
                }else {
                    res.next=l2;
                    l2=l2.next;
                }
                res=res.next;
            }else if (l1!=null){
                res.next=l1;
                break;
            }else if (l2!=null){
                res.next=l2;
                break;
            }
        }
        return realRes.next;
    }

    public static void main(String[] args){
        T85 t=new T85();
        ListNode head1=new ListNode(1);
        ListNode realHead1=head1;
        ListNode head2=new ListNode(2);
        ListNode realHead2=head2;

        head1.next=new ListNode(3);
        head1=head1.next;
        head1.next=new ListNode(5);
        head2.next=new ListNode(4);

        ListNode res=t.mergeTwoLists(realHead1,realHead2);
        while (res!=null){
            System.out.print(res.val);
            res=res.next;
        }

    }
}
