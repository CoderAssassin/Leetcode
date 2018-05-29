import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author aliyang
 * @date 18-5-29 下午3:48
 * binary-tree-postorder-traversal：别人解法
 * 思路：迭代求解,利用栈，前序遍历根->右->左，然后将结果翻转；总体思想是后序的顺序反着来遍历
 */
public class T6_1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root==null)
            return new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();
        stack.push(root);

        while (!stack.empty()){
            TreeNode tmpNode=stack.pop();
            res.add(tmpNode.val);
            if (tmpNode.left!=null)
                stack.push(tmpNode.left);
            if (tmpNode.right!=null)
                stack.push(tmpNode.right);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){
        T6_1 t=new T6_1();
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        ArrayList<Integer> res=t.postorderTraversal(root);
        for (Integer i:res)
            System.out.print(i+",");
    }
}
