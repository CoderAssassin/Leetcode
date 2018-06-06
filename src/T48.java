import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-6-6 下午1:47
 * symmetric-tree：我的解法
 */
public class T48 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

//    思路一：递归遍历，分根的左右生成字符串比较字符串是否相等，当遍历到节点为空的时候添加‘#’符号
//    public boolean isSymmetric(TreeNode root) {
//        if (root==null)
//            return true;
//
//        StringBuilder sb_left=new StringBuilder();
//        StringBuilder sb_right=new StringBuilder();
//        traverse_left(root.left,sb_left);
//        traverse_right(root.right,sb_right);
//        if (sb_left.toString().equals(sb_right.toString()))
//            return true;
//        else return false;
//    }
//
////    遍历根的左子树
//    private void traverse_left(TreeNode root,StringBuilder sb){
//
//        if (root==null){
//            sb.append('#');
//            return;
//        }
//
//        sb.append(root.val);
//        traverse_left(root.left,sb);
//        traverse_left(root.right,sb);
//    }
//
////    遍历根的右子树
//    private void traverse_right(TreeNode root,StringBuilder sb){
//
//        if (root==null){
//            sb.append('#');
//            return;
//        }
//
//        sb.append(root.val);
//        traverse_right(root.right,sb);
//        traverse_right(root.left,sb);
//    }

//    思路二：不使用递归，使用字符数组存储从左到右的字符，注意，这里存为字符串数组，然后类似判断回文数的方法判断是否是对称
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            ArrayList<String> arr=new ArrayList<>();
            int length=queue.size();
            for (int i=0;i<length;i++){
                TreeNode tmp=queue.poll();
                if (tmp.left!=null){
                    arr.add(String.valueOf(tmp.left.val));
                    queue.add(tmp.left);
                } else arr.add("#");
                if (tmp.right!=null){
                    arr.add(String.valueOf(tmp.right.val));
                    queue.add(tmp.right);
                } else arr.add("#");
            }
//            判断是否是回文
            if (!judge(arr))
                return false;
        }
        return true;
    }

//    回文判断
    private boolean judge(ArrayList<String> s){

        int left=0;
        int right=s.size()-1;
        while (left<=right){
            if (!s.get(left).equals(s.get(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }



    public static void main(String[] args){
        T48 t=new T48();
        TreeNode root=new TreeNode(4);
        TreeNode realRoot=root;
        root.left=new TreeNode(-57);
        root.right=new TreeNode(-57);
        root=root.left;
//        root.left=new TreeNode(3);
        root.right=new TreeNode(67);
        root=root.right;
        root.right=new TreeNode(-97);
        root=realRoot.right;
        root.left=new TreeNode(67);
        root=root.left;
        root.left=new TreeNode(-97);
//        root.right=new TreeNode(3);
        System.out.println(t.isSymmetric(realRoot));
    }
}
