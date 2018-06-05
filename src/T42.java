import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-6-5 下午2:22
 * binary-tree-level-order-traversal-ii：我的解法
 * 思路：层序遍历，利用Collections的reverse反一下
 */
public class T42 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (root==null)
            return res;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        int nowCount=1;
        int nextCount=0;

        ArrayList<Integer> cur=new ArrayList<>();
        while (!queue.isEmpty()){

            TreeNode t=queue.poll();
            nowCount--;

            cur.add(t.val);

            if (t.left!=null){
                queue.add(t.left);
                nextCount++;
            }
            if (t.right!=null){
                queue.add(t.right);
                nextCount++;
            }

            if (nowCount==0){
                res.add(cur);
//                res.add(0,cur);做法二，直接在头部加，但是速度会变慢
                cur=new ArrayList<>();
                nowCount=nextCount;
                nextCount=0;
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){
        T42 t=new T42();
        TreeNode root=new TreeNode(3);
        TreeNode realRoot=root;
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root=root.right;
        root.left=new TreeNode(15);
        root.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>> res=t.levelOrderBottom(realRoot);
        for (ArrayList<Integer> cur:res){
            for (Integer a:cur){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
