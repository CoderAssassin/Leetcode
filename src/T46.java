import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-6-5 下午4:10
 * binary-tree-zigzag-level-order-traversal：我的解法
 * 思路：层序遍历
 */
public class T46 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (root==null)
            return res;

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int row=1;//表示现在是第几行
        while (!queue.isEmpty()){
            ArrayList<Integer> cur=new ArrayList<>();
            int length=queue.size();
            for (int i=0;i<length;i++){
                TreeNode tmp=queue.poll();
                cur.add(tmp.val);
                if (tmp.left!=null)
                    queue.add(tmp.left);
                if (tmp.right!=null)
                    queue.add(tmp.right);
            }
            if (row%2==0)
                Collections.reverse(cur);
            res.add(cur);
            row++;
        }
        return res;
    }

    public static void main(String[] args){
        T46 t=new T46();
        TreeNode root=new TreeNode(3);
        TreeNode realRoot=root;
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root=root.right;
        root.left=new TreeNode(15);
        root.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>> res=t.zigzagLevelOrder(realRoot);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
