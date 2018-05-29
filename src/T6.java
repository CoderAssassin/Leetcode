import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-5-29 下午3:24
 * binary-tree-postorder-traversal：我的解法
 * 思路：递归求解，题目要求的迭代不会~~~~~~~~
 */
public class T6 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root==null)
            return new ArrayList<Integer>();
        ArrayList<Integer> res=new ArrayList<>();
        traversal(root,res);
        return res;
    }

    private void traversal(TreeNode root,ArrayList<Integer> res){

        if (root==null)
            return;

        traversal(root.left,res);
        traversal(root.right,res);
        res.add(root.val);
    }

    public static void main(String[] args){
        T6 t=new T6();
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        ArrayList<Integer> res=t.postorderTraversal(root);
        for (Integer i:res)
            System.out.print(i+",");
    }

}
