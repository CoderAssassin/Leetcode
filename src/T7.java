import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-29 下午4:02
 * binary-tree-preorder-traversal：我的解法
 * 思路：递归解法
 */
public class T7 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {

        if (root==null)
            return new ArrayList<Integer>();

        ArrayList<Integer> res=new ArrayList<>();
        traverse(root,res);
        return res;
    }

    private void traverse(TreeNode root,ArrayList<Integer> res) {

        if (root == null)
            return;

        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }

}
