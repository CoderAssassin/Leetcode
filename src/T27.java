/**
 * @author aliyang
 * @date 18-6-2 上午9:03
 * binary-tree-maximum-path-sum：我的解法
 * 思路：使用深搜，要考虑节点值为负数的情况，对于每个根节点，计算左子树的最大值和右子树的最大值，然后更新max值
 */
public class T27 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root==null)
            return 0;

        traverse(root,0);
        return max;
    }

    private int traverse(TreeNode root,int res){

        if (root==null)
            return res;

        int left=0,right=0;

//        左子树的最大值
        if (root.left!=null)
            left=traverse(root.left,0);
//        右子树的最大值
        if (root.right!=null)
            right=traverse(root.right,0);

        if (root.val>max)
            max=root.val;
        if (root.val+left>max)
            max=root.val+left;
        if (root.val+right>max)
            max=root.val+right;
        if (left+root.val+right>max)
            max=left+root.val+right;

//        以根的上级为根，那么这时候取左右两条路线的大的那一条
        if (left<right&&right+root.val>=root.val)
            return right+root.val;
        else if (left>=right&&left+root.val>=root.val)
            return left+root.val;
        else return root.val;
    }

    public static void main(String [] args){
        T27 t=new T27();
        TreeNode root=new TreeNode(1);
        TreeNode realRoot=root;
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(4);
        System.out.println(t.maxPathSum(root));

    }
}
