/**
 * @author aliyang
 * @date 18-5-28 下午8:05
 * minimum-depth-of-binary-tree：别人解法
 * 思路：递归
 */
public class T1_1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int run(TreeNode root) {
        if(root==null)
            return 0;
        int l = run(root.left);
        int r = run(root.right);
//        当左右子树至少由一个为null:①若都为null，那么返回1为当前节点增加的层数；
//        ②若只有一边为null，那么返回2为加上子树的一个层
        if(l==0 || r==0)
            return 1+l+r;
        return 1+Math.min(l,r);
    }

    public static void main(String[] args){
        T1_1 t=new T1_1();
        TreeNode root=new TreeNode(0);
        TreeNode realRoot=root;
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(4);

        System.out.println(t.run(realRoot));
    }
}
