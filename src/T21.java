/**
 * @author aliyang
 * @date 18-6-1 下午4:46
 * surrounded-regions：别人解法
 * 思路：所有与4条边连接的O都保留，其他都变为X
 */
public class T21 {

    private int rowNum=0;
    private int colNum=0;
    public void solve(char[][] board) {

        if(board==null||board.length<=0||board[0].length<=0)
            return;

        rowNum=board.length;
        colNum=board[0].length;

        for (int i=0;i<colNum;i++){
            dfs(board,0,i);//遍历顶行
            dfs(board,rowNum-1,i);//遍历底行
        }
        for (int i=0;i<rowNum;i++){
            dfs(board,i,0);
            dfs(board,i,colNum-1);
        }
//        将所有的O变为X
        for (int i=0;i<rowNum;i++){
            for (int j=0;j<colNum;j++){
                if (board[i][j]=='O')
                    board[i][j]='X';
            }
        }
//        将所有的*变为O
        for (int i=0;i<rowNum;i++){
            for (int j=0;j<colNum;j++){
                if (board[i][j]=='*')
                    board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board,int row,int col){

        if (board[row][col]=='O'){
            board[row][col]='*';
//            往上
            if (row>1)
                dfs(board,row-1,col);
            if (col>1)
                dfs(board,row,col-1);
            if (row<rowNum-1)
                dfs(board,row+1,col);
            if (col<colNum-1)
                dfs(board,row,col+1);
        }
    }
}
