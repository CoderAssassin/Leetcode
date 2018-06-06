import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-6-6 下午1:39
 * binary-tree-level-order-traversal：我的解法
 * 思路：层序遍历常规思路
 */
public class T47 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> cur = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.poll();
                cur.add(tmp.val);
                if (tmp.left!=null)
                    queue.add(tmp.left);
                if (tmp.right!=null)
                    queue.add(tmp.right);
            }
            res.add(cur);
        }
        return res;
    }
}
