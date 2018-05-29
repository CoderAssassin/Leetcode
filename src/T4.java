/**
 * @author aliyang
 * @date 18-5-28 下午8:57
 * sort-list:别人解法
 * 思路：归并排序思想
 */
public class T4 {

      static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public ListNode sortList(ListNode head) {
          if (head==null||head.next==null)
              return head;

          ListNode p=head,q=head.next;//快慢指针
          while (q!=null&&q.next!=null){//快的一次走两步，慢的一次走一步
              p=p.next;
              q=q.next.next;
          }
//          将链表分成两部分
          ListNode left=sortList(p.next);//右边部分继续递归排序
          p.next=null;//链子断掉
          ListNode right=sortList(head);//左边部分继续递归排序
          return merge(left,right);
    }

    ListNode merge(ListNode left,ListNode right){

          ListNode res=new ListNode(0);//新的队列的头结点
          ListNode realRes=res;

          while (left!=null&&right!=null){

              if (left.val<right.val){
                  res.next=left;
                  left=left.next;
              }else {
                  res.next=right;
                  right=right.next;
              }
              res=res.next;
          }
          if (left!=null) res.next=left;
          if (right!=null) res.next=right;
          return realRes.next;
    }

    public static void main(String[] args){
          T4 t=new T4();
          ListNode root=new ListNode(2);
          root.next=new ListNode(1);
          t.sortList(root);
    }
}
