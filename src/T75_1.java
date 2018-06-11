/**
 * @Author:Aliyang
 * @Data: Created in 下午5:30 18-6-11
 * search-a-2d-matrix：别人解法
 * 思路：选取右上角点，若该数字等于目标，返回true；若大于目标，往左；若小小于目标，往下
 **/
public class T75_1 {

//    思路一：选取右上角点
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int i=0,j=matrix[0].length-1;
//
//        while (i<matrix.length&&j>=0){
//            if (matrix[i][j]==target)
//                return true;
//            else if (matrix[i][j]<target)
//                i++;
//            else j--;
//        }
//        return false;
//    }

//    思路二：将整个二维想象成一维，然后做二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        // 二分查找
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = matrix[mid / n][mid % n];//关键坐标转换
            if (target > value) {
                start = mid + 1;
            } else if (target < value)
                end = mid - 1;
            else
                return true;
        }
        return false;
    }
}
