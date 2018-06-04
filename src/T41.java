/**
 * @author aliyang
 * @date 18-6-4 下午7:14
 * convert-sorted-array-to-binary-search-tree：我的解法
 * 思路：和40题类似，但是这里是数组，方便多了，就是这里的测试数据对中点的选取，奇数和偶数是不同的，需要处理一下
 */
public class T41 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] num) {

        if (num.length<=0)
            return null;

        return tranverse(num,0,num.length-1);
    }

    private TreeNode tranverse(int[] num,int start,int end){

        if (start>end)
            return null;
        if (start==end)
            return new TreeNode(num[start]);

        int middle=-1;
        if ((end-start+1)%2==0)
            middle=(start+end)/2+1;
        else middle=(start+end)/2;

        TreeNode tmp=new TreeNode(num[middle]);

        tmp.left=tranverse(num,start,middle-1);
        tmp.right=tranverse(num,middle+1,end);

        return tmp;
    }

    public static void main(String[] args){
        T41 t=new T41();
        int[] num=new int[]{3,5,8};
        TreeNode res=t.sortedArrayToBST(num);
        System.out.println(1);
    }
}
