import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aliyang
 * @date 18-5-28 下午7:37
 * minimum-depth-of-binary-tree：我的解法
 * 思路：开一个辅助数组，层序遍历，当遍历到节点孩子节点都为空，返回当前层数
 */
public class T1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int run(TreeNode root) {
        if (root==null)
            return 0;

        Queue queue=new LinkedList();
        ((LinkedList) queue).add(root);

        int minDepth=1;//最小深度
        int nowNodeCount=1;//当前层剩余节点数
        int nextNodeCount=0;//下一层节点数
        while (!queue.isEmpty()){
            TreeNode nowNode=(TreeNode) queue.poll();
            nowNodeCount--;

            if (nowNode.left==null&&nowNode.right==null){
                return minDepth;
            }

            if (nowNode.left!=null){
                ((LinkedList) queue).offer(nowNode.left);
                nextNodeCount++;
            }
            if (nowNode.right!=null){
                ((LinkedList) queue).offer(nowNode.right);
                nextNodeCount++;
            }

            if (nowNodeCount==0){//遍历到当前层最后一个
                minDepth++;//加上一层
                nowNodeCount=nextNodeCount;
                nextNodeCount=0;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        T1 t=new T1();
        TreeNode root=new TreeNode(0);
        TreeNode realRoot=root;
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(4);



        System.out.println(t.run(realRoot));
    }
}

