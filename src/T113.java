/**
 * @Author:Aliyang
 * @Data: Created in 上午10:46 18-6-15
 * sudoku-solver：我的解法
 * 思路：类似八皇后
 **/
public class T113 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        solve(board, 0);
    }

        public boolean solve(char[][] board, int num) {
        if(num == 81)
            return true;
        int m = num / 9;
        int n = num % 9;
        // 如果该位已经有数字，则进行下次搜索
        if(board[m][n] != '.'){
            if(solve(board, ++num))
                return true;
            return false;
        }
        // 如果是‘.’，那么就试凑
        for(char c= '1'; c <= '9'; c++){
            if(!isValid(board, m, n, c))
                continue;
            board[m][n] = c;
            if(solve(board, num+1))
                return true;
            // 试凑结果不对需要进行回溯
            board[m][n] = '.';
        }
        return false;
    }

        public boolean isValid(char[][] board, int m, int n, char c) {

        int tm = m / 3;
        int tn = n / 3;
        int mbegin = tm * 3;
        int nbegin = tn * 3;

        // 检查小的九宫格
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[mbegin + i][nbegin + j] == c)
                    return false;
            }
        }
        // 检查行
        for (int i = 0; i < 9; i++) {
            if (board[m][i] == c)
                return false;
        }
        // 检查列
        for (int i = 0; i < 9; i++) {
            if (board[i][n] == c)
                return false;
        }
        return true;
    }
}
