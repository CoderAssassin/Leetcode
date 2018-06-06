/**
 * @author aliyang
 * @date 18-6-6 下午2:34
 * symmetric-tree：别人解法
 * 思路：递归的一种妙解，连代码都是对称的
 */
public class T48_1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public static boolean check(TreeNode x, TreeNode y) {
        if(x == null && y == null) return true;
        if((x == null && y != null) || (x != null && y == null)) return false;
        return x.val == y.val && check(x.left, y.right) && check(x.right, y.left);
    }
}
