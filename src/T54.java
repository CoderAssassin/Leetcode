/**
 * @author aliyang
 * @date 18-6-6 下午7:22
 * unique-binary-search-trees：我的解法
 * 思路：找规律,遍历1-n，即为每个数分别为根的情况，当以j为根的时候，可能数为arr[j-1]*arr[i-j]，即左边和右边部分的可能数
 * 的乘积，然后把所有的加起来，用数组迭代
 */
public class T54 {

    public int numTrees(int n) {
        if (n==0)
            return 0;

        int[] arr=new int[n+1];
        arr[0]=1;

//        从头到尾轮流当根节点
        for (int i=1;i<=n;i++)
            for (int j=1;j<=i;j++)
                arr[i]+=arr[j-1]*arr[i-j];

        return arr[n];
    }

    public static void main(String[] args){
        T54 t=new T54();
        System.out.println(t.numTrees(3));
    }
}
