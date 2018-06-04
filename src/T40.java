/**
 * @author aliyang
 * @date 18-6-4 下午4:41
 * convert-sorted-list-to-binary-search-tree：我的解法
 * 思路：归并排序思想，中点作为中心，然后递归左右部分
 */
public class T40 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next = null; }
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {

        if (head==null)
            return null;

        return link(head);
    }

    private TreeNode link(ListNode head){

        if (head==null)
            return null;
        if (head.next==null)
            return new TreeNode(head.val);

        ListNode pre=new ListNode(-1);

        pre.next=head;
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&&fast.next!=null){
            pre=pre.next;
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode middle=slow;
        TreeNode tmp=new TreeNode(middle.val);

        tmp.right=link(middle.next);
        if (pre.next==head)
            pre.next.next=null;
        else pre.next=null;
        tmp.left=link(head);

        return tmp;
    }

//    快慢指针找中点
//    private ListNode findMiddle(ListNode head,ListNode pre){
//
//        pre.next=head;
//        ListNode slow=head;
//        ListNode fast=head;
//
//        while (fast!=null&&fast.next!=null){
//            pre=pre.next;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        return slow;
//    }

    public static void main(String[] args){
        T40 t=new T40();
        ListNode head=new ListNode(1);
        ListNode realHead=head;
        head.next=new ListNode(2);
        head=head.next;
        head.next=new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(5);
        head=head.next;
        head.next=new ListNode(6);
        head=head.next;
        head.next=new ListNode(7);
        head=head.next;
        TreeNode res=t.sortedListToBST(realHead);
        System.out.println(1);
    }

}
