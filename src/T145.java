/**
 * @Author:Aliyang
 * @Data: Created in 下午4:43 18-6-19
 * add-two-numbers：我的解法
 * 思路：题目开始理解错，直接正着加就好
 **/
public class T145 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;

        if (l1.next==null&&l1.val==0)
            return l2;
        if (l2.next==null&&l2.val==0)
            return l1;

        ListNode res=new ListNode(-1);
        ListNode realRes=res;
        int jinwei=0;
        while (l1!=null&&l2!=null){
            ListNode newNode=new ListNode((jinwei+l1.val+l2.val)%10);
            res.next=newNode;
            res=res.next;
            jinwei=(jinwei+l1.val+l2.val)/10;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            ListNode newNode=new ListNode((jinwei+l1.val)%10);
            res.next=newNode;
            res=res.next;
            jinwei=(jinwei+l1.val)/10;
            l1=l1.next;
        }
        while (l2!=null){
            ListNode newNode=new ListNode((jinwei+l2.val)%10);
            res.next=newNode;
            res=res.next;
            jinwei=(jinwei+l2.val)/10;
            l2=l2.next;
        }

        if (jinwei!=0)
            res.next=new ListNode(jinwei);
        return realRes.next;
    }

    public static void main(String[] args){
        T145 t=new T145();
        ListNode l1=new ListNode(9);
        ListNode realL1=l1;
        l1.next=new ListNode(8);
//        l1=l1.next;
//        l1.next=new ListNode(3);

        ListNode l2=new ListNode(1);
        ListNode realL2=l2;
//        l2.next=new ListNode(6);
//        l2=l2.next;
//        l2.next=new ListNode(4);

        ListNode res=t.addTwoNumbers(realL1,realL2);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }
    }
}
