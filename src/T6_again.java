import java.util.ArrayList;
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
        Stack<Integer> stack=new Stack<>();
        traverse(root,stack);
        while (!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }

    private void traverse(TreeNode root,Stack<Integer> stack){

        if (root==null)
            return;

        stack.push(root.val);
        traverse(root.right,stack);
        traverse(root.left,stack);
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
