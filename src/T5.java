/**
 * @author aliyang
 * @date 18-5-28 下午9:53
 * insertion-sort-list：我的解法
 * 思路：用两个指针从头到尾遍历，将链表反转，preNode指向反过来的头指针，这是按从大到小有序的，插入排序遍历的时候也是从该节点开始，
 * nowNode正向遍历原来的链表，每个节点和反向的链表的节点对比，找到插入点，然后插进去，最后返回的是节点的反向的头节点，然后再返回来
 */
public class T5 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public ListNode insertionSortList(ListNode head) {

          if (head==null||head.next==null)
              return head;

          ListNode preNode=head;
          ListNode nowNode=head.next;
          ListNode reverseHead=preNode;//反过来后的头
          preNode.next=null;

          while (nowNode!=null){
              ListNode tmpNode=nowNode.next;
              if (nowNode.val>preNode.val){
                  nowNode.next=preNode;
                  preNode=nowNode;
                  reverseHead=preNode;
                  nowNode=tmpNode;
                  continue;
              }

              ListNode tmpPreNode=preNode;
              preNode=preNode.next;
//              获得插入位置，即tmpPreNode
              while (preNode!=null&&preNode.val>nowNode.val){
                  tmpPreNode=tmpPreNode.next;
                  preNode=preNode.next;
              }
              tmpPreNode.next=nowNode;
              nowNode.next=preNode;
              nowNode=tmpNode;
              preNode=reverseHead;
          }

//          再倒回来
          preNode=reverseHead;
          nowNode=preNode.next;
          preNode.next=null;
          while (nowNode!=null){
              ListNode tmpNode=nowNode.next;
              nowNode.next=preNode;
              preNode=nowNode;
              nowNode=tmpNode;
          }
          return preNode;
    }

    public static void main(String[] args){
          T5 t=new T5();
          ListNode head=new ListNode(5);
          ListNode real_head=head;
          head.next=new ListNode(4);
          head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(1);
        head=head.next;
        ListNode res=t.insertionSortList(real_head);
        System.out.println(1);
    }

}
