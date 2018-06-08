/**
 * @Author:Aliyang
 * @Data: Created in 下午10:53 18-6-8
 * everse-linked-list-ii:我的解法
 * 思路:使用链表遍历翻转
 **/
public class T57 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m>n||head==null)
            return null;
        if (head.next==null||m==n)
            return head;

        ListNode pre=null;
        ListNode realHeal=head;
        ListNode first=null;//记录开始交换的第一个节点
        int nowId=1;

        while (head!=null){
            if (nowId>=m&&nowId<=n){//正常交换
                if (nowId==m)
                    first=pre;
                ListNode tmp=head.next;
                head.next=pre;
                pre=head;
                head=tmp;
                if (nowId==n&&first!=null){//当到达n的时候且m>1
                    first.next.next=head;
                    first.next=pre;
                }
                if (nowId==n&&m==1){//当到达n的时候且m==1,那么需要把头连到当前的节点
                    realHeal.next=head;
                    realHeal=pre;

                }
            }else {
                pre=head;
                head=head.next;
            }
            nowId++;
        }

        return  realHeal;
    }

    public static void main(String[] args){
        T57 t=new T57();
        ListNode head=new ListNode(1);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
//        head=head.next;
//        head.next=new ListNode(4);
//        head=head.next;
//        head.next=new ListNode(5);
        ListNode res=t.reverseBetween(realHead,1,2);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }
    }
}
