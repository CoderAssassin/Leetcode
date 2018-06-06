/**
 * @author aliyang
 * @date 18-6-6 下午2:36
 * same-tree：我的解法
 * 思路：递归思路
 */
public class T49 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p==null&&q==null)
            return true;

        return judge_equal(p,q);
    }

    private boolean judge_equal(TreeNode p,TreeNode q){

        if (p==null&&q==null)
            return true;

        if ((p==null&&q!=null)||(p!=null&&q==null))
            return false;

        return (p.val==q.val)&&judge_equal(p.left,q.left)&&judge_equal(p.right,q.right);
    }

    public static void main(String[] args){
        T49 t=new T49();
        TreeNode p=new TreeNode(0);
        p.left=new TreeNode(1);
        p.left.left=new TreeNode(1);

        TreeNode q=new TreeNode(0);
        q.left=new TreeNode(1);

        System.out.println(t.isSameTree(p,q));
    }
}
