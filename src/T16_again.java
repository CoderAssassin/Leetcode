import java.util.Arrays;

/**
 * @Author:Aliyang
 * @Data: Created in 下午4:59 18-7-6
 * candy：二刷
 **/
public class T16_again {

    public int candy(int[] ratings) {

        if (ratings==null||ratings.length==0)
            return 0;
        if (ratings.length==1)
            return 1;

        int[] res=new int[ratings.length];
        Arrays.fill(res,1);
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1])
                res[i]=res[i-1]+1;
        }
        for (int i=ratings.length-2;i>=0;i--)
            if (ratings[i]>ratings[i+1]&&res[i]<=res[i+1])
                res[i]=res[i+1]+1;
        int sum=0;
        for (Integer a:res)
            sum+=a;
        return sum;
    }
}
