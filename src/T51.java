/**
 * @author aliyang
 * @date 18-6-6 下午4:37
 * validate-binary-search-tree：我的解法
 * 思路：同上题一样
 */
public class T51 {

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
        if(pre!=null&&root.val<=pre.val) {
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

    private boolean isValidBST(TreeNode root){
        //pre必须设为null，通过遍历的时候设进去。因为是中序遍历，所以pre应该是深层叶子左子树的父节点。
        recursive_traversal(root);
        if(mistake1!=null||mistake2!=null) {
            return false;
        }else return true;
    }
}
