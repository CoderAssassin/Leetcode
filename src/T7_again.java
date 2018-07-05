import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:53 18-7-5
 * binary-tree-preorder-traversal：二刷
 **/
public class T7_again {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res=new ArrayList<>();
        if (root==null)
            return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp=stack.pop();
            res.add(tmp.val);
            if (tmp.right!=null)
                stack.push(tmp.right);
            if (tmp.left!=null)
                stack.push(tmp.left);
        }
        return res;
    }
}
