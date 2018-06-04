/**
 * @author aliyang
 * @date 18-6-4 下午3:47
 * balanced-binary-tree；别人解法
 * 思路：递归，当遍历某个节点时，若左右高度相差大于1那么返回-1，另外，在比较高度差之前要提前分别检查左右子树的高度差，若已经不平衡直接返回
 */
public class T39 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;

        return balance(root)!=-1;
    }

    private int balance(TreeNode root){

        if (root==null)
            return 0;
        int left=balance(root.left);
        if (left==-1)
            return -1;
        int right=balance(root.right);
        if (right==-1)
            return -1;
        if (Math.abs(left-right)>1)//高度差大于1返回-1
            return -1;
        return Math.max(left,right)+1;
    }
}
