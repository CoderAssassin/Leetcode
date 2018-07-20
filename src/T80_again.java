/**
 * @Author:Aliyang
 * @Data: Created in 下午3:33 18-7-20
 * sqrtx：二刷
 **/
public class T80_again {

    public int sqrt(int x) {
        long r=x;
        while (r*r>x){
            r=(r+x/r)/2;
        }
        return (int)r;
    }
}
