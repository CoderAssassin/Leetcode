import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午10:43 18-6-16
 * merge-k-sorted-lists：别人解法
 * 思路：使用归并排序，递归分治
 **/
public class T127 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        return partion(lists,0,lists.size()-1);
    }

//    将整个链表数组进行递归分治
    public static ListNode partion(ArrayList<ListNode> lists,int s,int e){
        if(s==e)  return lists.get(s);
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

//    对两个链表进行合并
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;//谁的值小返回哪个链表
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args){
        T127 t=new T127();
        ArrayList<ListNode> lists=new ArrayList<>();
        ListNode head=new ListNode(1);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(6);
        head=head.next;
        lists.add(realHead);

        ListNode head1=new ListNode(3);
        ListNode realHead1=head1;
        head1.next=new ListNode(3);
        head1=head1.next;
        head1.next=new ListNode(5);
        head1=head1.next;
        lists.add(realHead1);

        ListNode res=t.mergeKLists(lists);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }

    }
}
