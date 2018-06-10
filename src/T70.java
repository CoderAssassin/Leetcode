/**
 * @Author:Aliyang
 * @Data: Created in 上午10:19 18-6-10
 * word-search：我的解法
 * 思路：递归回溯，设置一个状态数组
 **/
public class T70 {

    public boolean exist(char[][] board, String word) {
        if (word.length()==0||word==null)
            return false;

        boolean[][] visited=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    if (find(board,word.substring(1,word.length()),visited,i,j))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board,String word,boolean[][] visited,int i,int j){

        if (word.length()==0)
            return true;

        char c=word.charAt(0);
        visited[i][j]=true;

        if (i-1>=0&&!visited[i-1][j]&&board[i-1][j]==c)
            if (find(board,word.substring(1,word.length()),visited,i-1,j))
                return true;
        if (i+1<board.length&&!visited[i+1][j]&&board[i+1][j]==c)
            if (find(board,word.substring(1,word.length()),visited,i+1,j))
                return true;
        if (j-1>=0&&!visited[i][j-1]&&board[i][j-1]==c)
            if (find(board,word.substring(1,word.length()),visited,i,j-1))
                return true;
        if (j+1<board[0].length&&!visited[i][j+1]&&board[i][j+1]==c)
            if (find(board,word.substring(1,word.length()),visited,i,j+1))
                return true;

        visited[i][j]=false;
        return false;
    }

    public static void main(String[] args){
        T70 t=new T70();
        char[][] board=new char[3][];
        board[0]=new char[]{'A','B','C','E'};
        board[1]=new char[]{'S','F','C','S'};
        board[2]=new char[]{'A','D','E','E'};
        String word="ABCB";
        System.out.println(t.exist(board,word));


    }
}
