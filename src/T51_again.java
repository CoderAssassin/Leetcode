/**
 * @Author:Aliyang
 * @Data: Created in 下午1:00 18-7-17
 * validate-binary-search-tree：二刷
 **/
public class T51_again {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {

        if (root==null)
            return true;

        if (!isValidBST(root.left))
            return false;
        if (pre!=null&&pre.val>=root.val)
            return false;
        pre=root;
        if (!isValidBST(root.right))
            return false;
        return true;
    }

    public static void main(String[] args){
        T51_again t=new T51_again();
        TreeNode root=new TreeNode(2);
        TreeNode realRoot=root;
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        System.out.println(t.isValidBST(root));
    }

}
