/**
 * @author aliyang
 * @date 18-5-30 下午3:39
 * copy-list-with-random-pointer：我的解法
 * 思路：将新节点先插入原来的节点的后边，然后修改随机指针，然后提取出来
 */
public class T13 {

    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null)
            return null;

//        将新的节点加入到原来的节点的后边
        for (RandomListNode p=head;p!=null;p=p.next){
            RandomListNode newNode=new RandomListNode(p.label);
            newNode.next=p.next;
            p.next=newNode;
            p=newNode;
        }

//        复制随机指针
        for (RandomListNode p=head;p!=null;p=p.next.next){
            if (p.random!=null){
                p.next.random=p.random.next;
            }
        }
//        提取出来新的节点链表
        for (RandomListNode p=head.next;p!=null;p=p.next){
            if (p.next!=null){
                p.next=p.next.next;
            }
        }
        return head.next;
    }

}
