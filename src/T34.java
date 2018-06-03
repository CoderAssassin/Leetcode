import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-6-3 上午11:46
 * populating-next-right-pointers-in-each-node-ii：我的解法
 * 思路：同35题
 */
public class T34 {

    public static class TreeLinkNode {
        int val;
        T35.TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(T35.TreeLinkNode root) {

        if (root==null)
            return;

        LinkedList<T35.TreeLinkNode> queue=new LinkedList<>();
        T35.TreeLinkNode preNode=null;

        int preCount=1;
        int nowCount=0;
        queue.push(root);

        while (!queue.isEmpty()){
            T35.TreeLinkNode nowNode=queue.poll();
            preCount--;

            if (nowNode.left!=null){
                queue.add(nowNode.left);
                nowCount++;
            }
            if (nowNode.right!=null){
                queue.add(nowNode.right);
                nowCount++;
            }

            if (preCount==0){
                nowNode.next=null;
                preCount=nowCount;
                nowCount=0;
                if (preNode!=null){
                    preNode.next=nowNode;
                    preNode=null;
                }
            }
            else {
                if (preNode==null){
                    preNode=nowNode;
                    continue;
                }
                preNode.next = nowNode;
                preNode = nowNode;
            }
        }
    }
}
