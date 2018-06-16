/**
 * @Author:Aliyang
 * @Data: Created in 下午9:33 18-6-16
 * remove-element：我的解法
 * 思路：开始题意理解错了，wrong了后才知道是从前往后碰到等于elem的位置，那么从后边放一个不是elem的元素到该位置
 **/
public class T123 {

    public int removeElement(int[] A, int elem) {

        int n=A.length;
        for (int i=0;i<n;i++){
            if (A[i]==elem){
                while (n>i&&A[--n]==elem);
                A[i]=A[n];
            }
        }
        return n;
    }

}
