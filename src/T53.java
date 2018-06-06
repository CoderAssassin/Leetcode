import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-6-6 下午7:21
 * unique-binary-search-trees-ii：别人解法
 * 思路：类似T54的从1到n选定一个根，然后递归左右子树，关键是如何存，这里不会处理
 */
public class T53 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; left = null; right = null; }
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return createTree(1, n);
    }
    public ArrayList<TreeNode> createTree(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<>();//每一层递归下去都要创建一个新的列表
        if(low > high) {
            result.add(null);
            return result;
        }
        for (int i = low; i <= high; i ++) {
        // 求根结点i的左右子树集合
            ArrayList<TreeNode> left = createTree(low, i - 1);
            ArrayList<TreeNode> right = createTree(i + 1, high);

//            到这里说明都已经递归到底层，即添加完最后一个节点
            for (int j = 0; j < left.size(); j ++) {
                for (int k = 0; k < right.size(); k ++) {
                    // 将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left.get(j);
                    newNode.right = right.get(k);
                    result.add(newNode);//将每一种可能情况存储
                }
            }
        }
        return result;//将可能的结果列表返回上一级
    }

    public static void main(String[] args){
        T53 t=new T53();
        ArrayList<TreeNode> res=t.generateTrees(4);
        System.out.println(1);
    }
}
