/**
 * @Author:Aliyang
 * @Data: Created in 下午3:04 18-7-16
 * balanced-binary-tree：二刷
 **/
public class T39_again {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {

        if (root==null)
            return true;
        if (judge(root)!=-1)
            return true;
        else return false;
    }

    private int judge(TreeNode root){
        if (root==null)
            return 0;
        int left=judge(root.left);
        if (left==-1)
            return -1;
        int right=judge(root.right);
        if (right==-1)
            return -1;
        if (Math.abs(left-right)>1)//关键步骤，不合格设为-1
            return -1;
        return Math.max(left,right)+1;
    }

}
