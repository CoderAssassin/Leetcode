import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:49 18-6-15
 * valid-sudoku：我的解法
 * 思路：判断每行每列每个九宫格里的数字是否合法
 **/
public class T114 {

    public boolean isValidSudoku(char[][] board) {

        for (int i=0;i<9;i++){//表示行列
            Set<Character> row=new HashSet<>();
            Set<Character> col=new HashSet<>();
            Set<Character> block=new HashSet<>();

            for (int j=0;j<9;j++){//表示行列

                if (!(board[i][j]=='.')&&!row.add(board[i][j]))//判断一行
                    return false;
                if (!(board[j][i]=='.')&&!col.add(board[j][i]))//判断一列
                    return false;
                int block_row=3*(i/3)+j/3;
                int block_col=3*(i%3)+j%3;
                if (board[block_row][block_col]!='.'&&!block.add(board[block_row][block_col]))
                    return false;
            }
        }
        return true;
    }
}
