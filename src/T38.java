/**
 * @author aliyang
 * @date 18-6-4 下午3:04
 * path-sum：我的解法
 * 思路：递归
 */
public class T38 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        return traverse(root,sum,0);
    }

    private boolean traverse(TreeNode root,int sum,int now){

        if (root==null)
            return false;

        if (root.left==null&&root.right==null){
            if (now+root.val==sum)
                return true;
            else return false;
        }

        if (traverse(root.left,sum,now+root.val)||traverse(root.right,sum,now+root.val))
            return true;
        else return false;
    }

    public static void main(String[] args){
        T38 t=new T38();
        TreeNode root=new TreeNode(5);
        TreeNode realRoot=root;
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root=root.left;
        root.left=new TreeNode(11);
        root=root.left;
        root.left=new TreeNode(7);
        root.right=new TreeNode(2);
        root=realRoot.right;
        root.left=new TreeNode(13);
        root.right=new TreeNode(4);
        root=root.right;
        root.right=new TreeNode(1);
        System.out.println(t.hasPathSum(realRoot,2));
    }
}
