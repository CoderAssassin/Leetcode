/**
 * @Author:Aliyang
 * @Data: Created in 下午3:14 18-7-13
 * surrounded-regions：二刷
 **/
public class T21_again {

    public void solve(char[][] board) {

        if(board==null||board.length<=0||board[0].length<=0)
            return;

//        遍历顶行和底行
        for (int i=0;i<board[0].length;i++){
            traverse(board,0,i);
            traverse(board,board.length-1,i);
        }

        for (int i=0;i<board.length;i++){
            traverse(board,i,0);
            traverse(board,i,board[0].length-1);
        }

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='O')
                    board[i][j]='X';
            }
        }

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='*')
                    board[i][j]='O';
            }
        }
    }

    private void traverse(char[][] board,int row,int col){
        if (board[row][col]=='O'){
            board[row][col]='*';

            if (row>1)
                traverse(board,row-1,col);
            if (row<board.length-1)
                traverse(board,row+1,col);
            if (col>1)
                traverse(board,row,col-1);
            if (col<board[0].length-1)
                traverse(board,row,col+1);
        }
    }
}

