import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:39 18-7-5
 * binary-tree-postorder-traversal：二刷
 **/
public class T6_again {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res=new ArrayList<>();
        if (root==null)
            return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp=stack.pop();
            res.add(tmp.val);
            if (tmp.left!=null)
                stack.push(tmp.left);
            if (tmp.right!=null)
                stack.push(tmp.right);
        }
        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args){
        T6_again t=new T6_again();
        TreeNode root=new TreeNode(1);
        TreeNode realRoot=root;
        root.right=new TreeNode(2);
        root=root.right;
        root.left=new TreeNode(3);

        ArrayList<Integer> res=t.postorderTraversal(realRoot);
        for (Integer a:res)
            System.out.print(a+",");
    }
}
