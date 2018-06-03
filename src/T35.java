import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-6-3 下午4:24
 * populating-next-right-pointers-in-each-node：我的解法
 * 思路：BFS
 */
public class T35 {

    public static class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {

        if (root==null)
            return;

        LinkedList<TreeLinkNode> queue=new LinkedList<>();
        TreeLinkNode preNode=null;

        int preCount=1;
        int nowCount=0;
        queue.push(root);

        while (!queue.isEmpty()){
            TreeLinkNode nowNode=queue.poll();
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

    public static void main(String[] args){
        T35 t=new T35();
        TreeLinkNode root=new TreeLinkNode(1);
        root.left=new TreeLinkNode(2);
        root.right=new TreeLinkNode(3);
        t.connect(root);

    }
}
