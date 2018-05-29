import java.util.ArrayList;
import java.util.Stack;

/**
 * @author aliyang
 * @date 18-5-29 下午4:14
 * binary-tree-preorder-traversal：我的解法
 * 思路：迭代，类似T6，使用栈，入栈顺序根->右->左，不过这里不用翻转
 */
public class T7_1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root==null)
            return new ArrayList<Integer>();

        ArrayList<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode tmpNode=stack.pop();

            res.add(tmpNode.val);
            if (tmpNode.right!=null)
                stack.push(tmpNode.right);
            if (tmpNode.left!=null)
                stack.push(tmpNode.left);
        }
        return res;
    }

    public static void main(String[] args){
        T7_1 t=new T7_1();
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        ArrayList<Integer> res=t.preorderTraversal(root);
        for (Integer i:res)
            System.out.print(i+",");
    }
}
