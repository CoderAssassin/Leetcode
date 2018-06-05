/**
 * @author aliyang
 * @date 18-6-5 下午3:44
 * construct-binary-tree-from-preorder-and-inorder-traversal：我的解法
 * 思路：类似上题，就是递归的时机不同，前序前边都是根的左子树，右边都是根的右子树，用一个下标跟踪下，然后对中序使用递归
 */
public class T44 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private int preIndex=1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length==0||preorder.length==0||inorder.length!=preorder.length)
            return null;

        TreeNode res=null;
        int i=0;
//        从中序序列中找到根
        for (i=0;i<inorder.length;i++){
            if (inorder[i]==preorder[0])
                break;
        }
        res=generate(inorder,preorder,0,inorder.length-1,i);
        return res;
    }

    private TreeNode generate(int[] inorder,int[] preorder,int start,int end,int root){

        if (start>end)
            return null;

        TreeNode nowNode=new TreeNode(inorder[root]);

        if (start==end)
            return nowNode;

//        找到左边的根
        int i=0,j=0;
        for (i=start;i<root;i++){
            if (inorder[i]==preorder[preIndex]){
                preIndex++;
                break ;
            }
        }
        int leftRoot=i;
        nowNode.left=generate(inorder,preorder,start,root-1,leftRoot);

//        找到右边的根
        for (i=root+1;i<=end;i++){
            if (inorder[i]==preorder[preIndex]){
                preIndex++;
                break;
            }
        }
        int rightRoot=i;
        nowNode.right=generate(inorder,preorder,root+1,end,rightRoot);
        return nowNode;
    }

    public static void main(String[] args){
        T44 t=new T44();
        int[] inorder=new int[]{4,2,5,1,6,3};
        int[] preorder=new int[]{1,2,4,5,3,6};
        TreeNode res=t.buildTree(preorder,inorder);
        System.out.println(1);

    }
}
