/**
 * @author aliyang
 * @date 18-6-1 下午6:56
 * 
 */
public class T22 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    int sum=0;
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;
        StringBuilder cur=new StringBuilder();
        traverse(root,cur);
        return sum;
    }

    private void traverse(TreeNode root,StringBuilder cur){

        cur.append(root.val);

        if (root.left==null&&root.right==null){
            if (!cur.equals(""))
                sum+=Integer.valueOf(cur.toString());
            return;
        }

        if (root.left!=null){
            traverse(root.left,cur);
            cur.deleteCharAt(cur.length()-1);
        }

        if (root.right!=null){
            traverse(root.right,cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args){
        T22 t=new T22();
        TreeNode root=new TreeNode(1);
        TreeNode realRoot=root;
//        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        System.out.println(t.sumNumbers(root));
    }
}
