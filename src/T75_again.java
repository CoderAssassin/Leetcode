/**
 * @Author:Aliyang
 * @Data: Created in 下午2:23 18-7-20
 * search-a-2d-matrix：二刷
 **/
public class T75_again {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix==null||matrix.length==0)
            return false;

//        将二维想象成一维，二分
        int rows=matrix.length,cols=matrix[0].length;
        int low=0,high=rows*cols-1;

        while (low<=high){
            int mid=(low+high)/2;
            int row=mid/cols,col=mid%cols;
            if (matrix[row][col]==target)
                return true;
            else if (matrix[row][col]<target){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        T75_again t=new T75_again();
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(t.searchMatrix(matrix,3));
    }
}
