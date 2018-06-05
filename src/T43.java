/**
 * @author aliyang
 * @date 18-6-5 下午2:44
 * construct-binary-tree-from-inorder-and-postorder-traversal：我的解法
 * 思路：后序遍历的最后一个数字根，然后中序遍历中根将左右分成两棵子树，左子树序列和右子树序列在后序序列的后边的数为子树的根
 */
public class T43 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

//    题目审错，写成了根据前序和后序来构成树
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//
//        if (inorder.length==0||postorder.length==0||inorder.length!=postorder.length)
//            return null;
//
//        TreeNode res=null;
//        int i=0;
//        for (i=0;i<postorder.length;i++){
//            if (inorder[0]==postorder[i])
//                break;
//        }
//        res=generate(inorder,postorder,0,postorder.length-1,i);
//        return res;
//    }
//
//    private TreeNode generate(int[] inorder,int[] postorder,int start,int end,int root){
//
//        if (start>end)
//            return null;
//
//        TreeNode nowNode=new TreeNode(postorder[root]);
//
//        if (start==end)
//            return nowNode;
//
////        找到左边的根
//        int i=0,j=0;
//        left:
//        for (i=0;i<inorder.length;i++){
//            for (j=start;j<root;j++){
//                if (inorder[i]==postorder[j])
//                    break left;
//            }
//        }
//        int leftRoot=j;
////        找到右边的根
//        right:
//        for (i=0;i<inorder.length;i++){
//            for (j=root+1;j<=end;j++){
//                if (inorder[i]==postorder[j])
//                    break right;
//            }
//        }
//        int rightRoot=j;
//
//        nowNode.left=generate(inorder,postorder,start,root-1,leftRoot);
//        nowNode.right=generate(inorder,postorder,root+1,end,rightRoot);
//        return nowNode;
//    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length==0||postorder.length==0||inorder.length!=postorder.length)
            return null;

        TreeNode res=null;
        int i=0;
//        从中序序列中找到根
        for (i=0;i<inorder.length;i++){
            if (inorder[i]==postorder[postorder.length-1])
                break;
        }
        res=generate(inorder,postorder,0,inorder.length-1,i);
        return res;
    }

    private TreeNode generate(int[] inorder,int[] postorder,int start,int end,int root){

        if (start>end)
            return null;

        TreeNode nowNode=new TreeNode(inorder[root]);

        if (start==end)
            return nowNode;

//        找到左边的根
        int i=0,j=0;
        left:
        for (i=postorder.length-1;i>=0;i--){
            for (j=start;j<root;j++){
                if (inorder[j]==postorder[i])
                    break left;
            }
        }
        int leftRoot=j;
//        找到右边的根
        right:
        for (i=postorder.length-1;i>=0;i--){
            for (j=root+1;j<=end;j++){
                if (inorder[j]==postorder[i])
                    break right;
            }
        }
        int rightRoot=j;

        nowNode.left=generate(inorder,postorder,start,root-1,leftRoot);
        nowNode.right=generate(inorder,postorder,root+1,end,rightRoot);
        return nowNode;
    }

    public static void main(String[] args){
        T43 t=new T43();
        int[] inorder=new int[]{4,2,5,1,3,6};
        int[] postorder=new int[]{4,5,2,6,3,1};
        TreeNode res=t.buildTree(inorder,postorder);
        System.out.println(1);
    }
}
