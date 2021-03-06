/**
 * @author aliyang
 * @date 18-6-6 下午2:49
 * recover-binary-search-tree：别人解法
 * 思路：中序遍历,设置一个pre前指针，当当前指针比pre指针小的时候，说明由问题
 */
public class T50 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode mistake1, mistake2;
    TreeNode pre;

    void recursive_traversal(TreeNode root) {
        if(root==null) {
            return;
        }
        if(root.left!=null) {
            recursive_traversal(root.left);
        }
        if(pre!=null&&root.val<pre.val) {
            if(mistake1==null) {
                mistake1 = pre;
                mistake2 = root;
            } else {
                mistake2 = root;
            }
        }
        pre = root;
        if(root.right!=null) {
            recursive_traversal(root.right);
        }
    }
    public void recoverTree(TreeNode root) {
        //pre必须设为null，通过遍历的时候设进去。因为是中序遍历，所以pre应该是深层叶子左子树的父节点。
        recursive_traversal(root);
        if(mistake1!=null&&mistake2!=null) {
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = tmp;
        }
    }
}
