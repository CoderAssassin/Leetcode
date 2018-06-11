/**
 * @Author:Aliyang
 * @Data: Created in 下午5:15 18-6-11
 * search-a-2d-matrix：我的解法
 * 思路：先遍历找到行，然后用二分查找
 **/
public class T75 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0)
            return false;

        int i=0;
        for (;i<matrix.length;i++)
            if (target>=matrix[i][0]&&target<=matrix[i][matrix[0].length-1])
                break;

        if (i>=matrix.length)
            return false;

        int start=0,end=matrix[i].length-1;
        return binarySearch(matrix,i,start,end,target);
    }

    private boolean binarySearch(int[][] matrix,int line,int start,int end,int target){

        if (start>end)
            return false;
        if (start==end&&matrix[line][start]==target)
            return true;

        int mid=(start+end)/2;
        if (matrix[line][mid]==target)
            return true;

        if (matrix[line][mid]>target)
            return binarySearch(matrix,line,start,mid-1,target);
        else return binarySearch(matrix,line,mid+1,end,target);
    }

    public static void main(String[] args){
        T75 t=new T75();
        int[][] matrix=new int[3][];
        matrix[0]=new int[]{1,3,5,7};
        matrix[1]=new int[]{10,11,16,20};
        matrix[2]=new int[]{23,30,34,50};
        System.out.println(t.searchMatrix(matrix,2));
    }
}
