import java.util.ArrayList;

/**
 * @author aliyang
 * @date 18-6-3 上午9:21
 * pascals-triangle-ii：我的解法
 * 思路：递归，超时
 */
public class T32 {

//    思路一：递归超时
    public ArrayList<Integer> getRow(int rowIndex) {

        ArrayList<Integer> res=new ArrayList<>();
        if (rowIndex==0){
            res.add(1);
            return res;
        }
        res.add(1);
        for (int i=1;i<=rowIndex-1;i++)
            res.add(triangle(rowIndex,i));
        res.add(1);
        return res;
    }

    private int triangle(int row,int col){

        if (row==0&&col==0)
            return 1;
        if (col<0||col>row)
            return 0;

        return triangle(row-1,col-1)+triangle(row-1,col);
    }

    public static void main(String[] args){
        T32 t=new T32();
        ArrayList<Integer> res=t.getRow(4);
        for (Integer a:res)
            System.out.print(a+" ");
    }
}
