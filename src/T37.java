import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-6-4 下午3:02
 * path-sum-ii：我的解法
 * 思路：递归，和38题类似，就是用个全局变量保存结果
 */
public class T37 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    ArrayList<ArrayList<Integer>> res=null;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

        res=new ArrayList<>();
        if (root==null)
            return res;

        ArrayList<Integer> cur=new ArrayList<>();

        traverse(root,sum,0,cur);
        return res;
    }

    private void traverse(TreeNode root, int sum, int now, ArrayList<Integer> cur){

        if (root==null)
            return;

        cur.add(root.val);
        now+=root.val;

//        当到达叶节点的时候
        if (root.left==null&&root.right==null){
            if (now==sum){
                ArrayList<Integer> tmpCur=new ArrayList<>(cur);
                res.add(tmpCur);
            }
            cur.remove(cur.size()-1);
            now-=root.val;
            return;
        }

        traverse(root.left,sum,now,cur);
        traverse(root.right,sum,now,cur);
        cur.remove(cur.size()-1);
        now-=root.val;
    }

    public static void main(String[] args){
        T37 t=new T37();
        TreeNode root=new TreeNode(5);
        TreeNode realRoot=root;
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root=root.left;
        root.left=new TreeNode(11);
        root=root.left;
        root.left=new TreeNode(7);
        root.right=new TreeNode(2);
        root=realRoot.right;
        root.left=new TreeNode(13);
        root.right=new TreeNode(4);
        root=root.right;
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        ArrayList<ArrayList<Integer>> res=t.pathSum(realRoot,22);
        for (ArrayList<Integer> arr:res){
            for (Integer a:arr){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
}
