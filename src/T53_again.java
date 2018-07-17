import java.util.ArrayList;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:12 18-7-17
 * unique-binary-search-trees-ii：二刷
 **/
public class T53_again {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; left = null; right = null; }
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    private ArrayList<TreeNode> dfs(int start,int end){

        ArrayList<TreeNode> cur=new ArrayList<>();//关键的存储步骤，每层递归栈创建一个新的列表
        if (start>end){
            cur.add(null);
            return cur;
        }

        for (int i=start;i<=end;i++){
            ArrayList<TreeNode> left=dfs(start,i-1);
            ArrayList<TreeNode> right=dfs(i+1,end);
            for (int m=0;m<left.size();m++){//前面的是递归，这里是处理该层递归往下的所有的可能
                for (int n=0;n<right.size();n++){
                    TreeNode root=new TreeNode(i);
                    root.left=left.get(m);
                    root.right=right.get(n);
                    cur.add(root);
                }
            }
        }
        return cur;
    }
}
