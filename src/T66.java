/**
 * @Author:Aliyang
 * @Data: Created in 下午4:30 18-6-9
 * remove-duplicates-from-sorted-list-ii:我的解法
 * 思路:链表遍历
 **/
public class T66 {
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

        ListNode newHead=new ListNode(-1);
        ListNode realNewHead=newHead;//结果的链表
        ListNode pre=null;
        ListNode now=head;
        int dup=1;//用来记录出现重复的次数
        while (now!=null){
            if (pre!=null&&pre.val==now.val){//若出现了重复
                dup++;
            }else if (pre!=null&&pre.val!=now.val){//如果前一个节点和当前节点不同
                if (dup==1){//若前一个节点出现的次数为1,那么加入结果列表
                    newHead.next=pre;
                    newHead=newHead.next;
                    newHead.next=null;
                }else {//若前一个节点出现的次数不为1,那么重置
                    dup=1;
                }
            }
            pre=now;
            now=now.next;
        }
        if (dup==1){//到最后如果最后一个节点出现的次数为1,那么加入结果列表
            newHead.next=pre;
        }
        return realNewHead.next;
    }

    public static void main(String[] args){
        T66 t=new T66();
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
