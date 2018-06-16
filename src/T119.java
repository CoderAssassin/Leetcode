

/**
 * @Author:Aliyang
 * @Data: Created in 下午5:19 18-6-16
 * next-permutation：我的解法
 * 思路：从右到左如果是升序的子串已经到达最大了，找到正好降下的位置，从该位置往右找到大于该位置数的数，和该位置交换，然后把该位置往后
 * 的数翻一下
 **/
public class T119 {

    public void nextPermutation(int[] num) {

        int index=num.length-2;
        while (index>=0&&num[index]>=num[index+1])
            index--;
        if (index==-1){//说明是降序的，那么翻一下
            reverse(num,0,num.length-1);
        }else {
            int right=num.length-1;
            while (right>=index+1&&num[right]<=num[index])//在右边找到大于index位置的数的索引
                right--;
            int tmp=num[right];
            num[right]=num[index];
            num[index]=tmp;
            reverse(num,index+1,num.length-1);//换了以后，index后边的数翻一下
        }
    }

    private void reverse(int[] num,int start,int end){

        for (int i=start;i<=start+(end-start)/2;i++){
            int tmp=num[i];
            num[i]=num[end-i+start];
            num[end-i+start]=tmp;
        }
    }

    public static void main(String[] args){
        T119 t=new T119();
        int[] num=new int[]{5,4,7,5,3,2};
        t.nextPermutation(num);
        for (int i=0;i<num.length;i++)
            System.out.print(num[i]+",");
    }
}
