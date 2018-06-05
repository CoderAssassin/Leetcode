/**
 * @author aliyang
 * @date 18-6-5 下午4:05
 * maximum-depth-of-binary-tree：我的解法
 * 思路：简单的递归
 */
public class T45 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {

        if (root==null)
            return 0;

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args){

        T45 t=new T45();
        TreeNode root=new TreeNode(1);
        TreeNode realRoot=root;
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root=root.left;
        root.left=new TreeNode(4);
        System.out.println(t.maxDepth(realRoot));
    }
}
