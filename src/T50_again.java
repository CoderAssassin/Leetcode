/**
 * @Author:Aliyang
 * @Data: Created in 下午3:32 18-7-16
 * recover-binary-search-tree：二刷
 **/
public class T50_again {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    TreeNode first=null,second=null,pre=null;
    public void recoverTree(TreeNode root) {
        if (root==null||(root.left==null&&root.right==null))
            return;
        recover(root);
        if (second==null)
            second=pre;
        int tmp=first.val;
        first.val=second.val;
        second.val=tmp;
    }

    private void recover(TreeNode root){

        if (root==null){
            return;
        }

        recover(root.left);
        if (pre!=null&&root.val<pre.val){
            if (first==null){
                first=pre;
                second=root;
            }
            else {
                second=root;
            }
        }
        pre=root;
        recover(root.right);
    }

    public static void main(String[] args){
        T50_again t=new T50_again();
        TreeNode root=new TreeNode(1);
        TreeNode realRoot=root;
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
//        root=root.right;
//        root.left=new TreeNode(2);
//        root=root.left;
//        root.right=new TreeNode(9);
        t.recoverTree(realRoot);
        System.out.println(1);
    }
}
