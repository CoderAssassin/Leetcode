/**
 * @Author:Aliyang
 * @Data: Created in 下午1:41 18-7-5
 * sort-list：二刷
 **/
public class T4_again {

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
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){

        if (head==null||head.next==null)
            return head;

        ListNode fast=head,slow=head;
        ListNode pre=new ListNode(-1);
        pre.next=head;
        while (fast!=null&&fast.next!=null){//找到分割点，slow为后边一部分的中点
            fast=fast.next.next;
            slow=slow.next;
            pre=pre.next;
        }
        pre.next=null;

        ListNode tmpHead=new ListNode(-1);
        ListNode tmpLeft=mergeSort(head),tmpRight=mergeSort(slow),realTmpHead=tmpHead;

        while (tmpLeft!=null&&tmpRight!=null){
            if (tmpLeft.val<tmpRight.val){
                ListNode flagTmpLeft=tmpLeft;
                while (flagTmpLeft.next!=null&&flagTmpLeft.next.val<tmpRight.val)
                    flagTmpLeft=flagTmpLeft.next;
                tmpHead.next=tmpLeft;
                tmpHead=flagTmpLeft;
                tmpLeft=flagTmpLeft.next;
                tmpHead.next=null;
            }else {
                ListNode flagTmpRight=tmpRight;
                while (flagTmpRight.next!=null&&flagTmpRight.next.val<tmpLeft.val)
                    flagTmpRight=flagTmpRight.next;
                tmpHead.next=tmpRight;
                tmpHead=flagTmpRight;
                tmpRight=flagTmpRight.next;
                tmpHead.next=null;
            }
        }
        if (tmpLeft!=null){
            tmpHead.next=tmpLeft;
        }
        if (tmpRight!=null){
            tmpHead.next=tmpRight;
        }
        return realTmpHead.next;
    }

    public static void main(String[] args){
        T4_again t=new T4_again();
        ListNode head=new ListNode(3);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(4);
//        head=head.next;
//        head.next=new ListNode(2);
//        head=head.next;
//        head.next=new ListNode(1);
        ListNode res=t.sortList(realHead);
        while (res!=null){
            System.out.print(res.val);
            res=res.next;
        }
    }



}
