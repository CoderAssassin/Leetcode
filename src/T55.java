import java.util.ArrayList;
import java.util.Stack;

/**
 * @author aliyang
 * @date 18-6-6 下午9:09
 * binary-tree-inorder-traversal：我的解法
 */
public class T55 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

//    思路一：递归解法
//    public ArrayList<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> res=new ArrayList<>();
//        if (root==null)
//            return res;
//        inorder(root,res);
//        return res;
//    }
//
//    private void inorder(TreeNode root,ArrayList<Integer> res){
//
//        if (root==null)
//            return;
//
//        inorder(root.left,res);
//        res.add(root.val);
//        inorder(root.right,res);
//    }

//    思路二：非递归解法，用栈来模拟，先找到节点最左边的节点，中途一路保存到栈，然后每次出来一个节点，加入结果，该节点和左边断开，遍历右子树
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null)
            return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode tmp=stack.peek();

            while (tmp.left!=null){
                stack.add(tmp.left);
                TreeNode pre=tmp;
                tmp=tmp.left;//将左子树断开，满足判断条件
                pre.left=null;
            }
            tmp=stack.pop();
            res.add(tmp.val);
            if (tmp.right!=null)
                stack.push(tmp.right);
        }
        return res;
    }

//    别人的非递归的代码，不用断链，我没有调试出来
//    public ArrayList<Integer> inorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        TreeNode node = root;
//        while (!stack.isEmpty() || node != null) {
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//
//            node = stack.pop();
//            res.add(node.val);
//            node = node.right;
//
//        }
//        return res;
//    }

    public static void main(String[] args){
        T55 t=new T55();
        TreeNode root=new TreeNode(1);
        TreeNode realRoot=root;
        root.right=new TreeNode(2);
        root=root.right;
        root.left=new TreeNode(3);
        ArrayList<Integer> res=t.inorderTraversal(realRoot);
        for (Integer a:res)
            System.out.print(a+",");
    }
}
