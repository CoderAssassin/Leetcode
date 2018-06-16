/**
 * @Author:Aliyang
 * @Data: Created in 下午10:38 18-6-16
 * swap-nodes-in-pairs：我的解法
 * 思路：同T125，更简单
 **/
public class T126 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode swapPairs(ListNode head) {

        int len=0;
        ListNode tmpHead=head;
        while (tmpHead!=null){
            len++;
            tmpHead=tmpHead.next;
        }

        return reverse(head,len,2);
    }

    private ListNode reverse(ListNode head,int n,int k){

        if (n<k)
            return head;

        ListNode tmpHead=head;
        int count=0;
        ListNode first=null;
        ListNode pre=null;
        while (count<=k){
            if (count==0){
                first=tmpHead;//记录每一次的第一个位置
                pre=tmpHead;
                tmpHead=tmpHead.next;
            }else if (count<k){//反转
                ListNode next=tmpHead.next;
                tmpHead.next=pre;
                pre=tmpHead;
                tmpHead=next;
            }else if (count==k){
                first.next=reverse(tmpHead,n-k,k);//当前k个节点的第一个指向下层返回的头结点
                first=tmpHead;
            }
            count++;
        }
        return pre;
    }

    public static void main(String[] args){
        T126 t=new T126();
        ListNode head=new ListNode(1);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        ListNode res=t.swapPairs(realHead);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }
    }
}
