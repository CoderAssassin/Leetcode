import java.util.Arrays;

/**
 * @author aliyang
 * @date 18-5-31 下午12:28
 * candy：别人解法
 * 思路：从左到右扫一遍，大的加1，从右到左扫一遍，大的加1
 */
public class T16 {

    public int candy(int[] ratings) {

        if (ratings==null||ratings.length==0)
            return 0;
        if (ratings.length==1)
            return 1;
        int[] res=new int[ratings.length];

        Arrays.fill(res,1);
        for (int i=1;i<ratings.length;i++)
            if (ratings[i]>ratings[i-1])
                res[i]=res[i-1]+1;

        for (int i=ratings.length-2;i>=0;i--)
            if (ratings[i]>ratings[i+1]&&res[i]<=res[i+1])
                res[i]=res[i+1]+1;

        int sum=0;

        for (int i=0;i<ratings.length;i++)
            sum+=res[i];
        return sum;
    }

    public static void main(String[] args){
        T16 t=new T16();
        int[] ratings=new int[]{1,2,2};
        System.out.println(t.candy(ratings));


    }


}
