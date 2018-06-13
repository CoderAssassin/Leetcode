import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午4:40 18-6-13
 * anagrams：别人解法
 **/
public class T101 {

//    我的思路：有bug
//    public ArrayList<String> anagrams(String[] strs) {
//
//        ArrayList<String> res=new ArrayList<>();
//        if (strs.length==0)
//            return res;
//
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        });
//
//        int len=strs[0].length();
//        int start=0;
//        int end=0;
//        for (int i=0;i<=strs.length;i++){
//
//            if (i==strs.length||strs[i].length()!=len){
////                if (i==strs.length)
////                    end--;
//                if (end-start>=1)
//                    judge(strs,res,start,end);
//                start=i;
//            }else {
//                if (i!=start)
//                    end++;
//            }
//        }
//        return res;
//    }
//
//    private void judge(String[] strs,ArrayList<String> res,int start,int end){
//
//        int[] s=new int[end-start+1];
//
//        int count=1;
//        for (int i=start;i<=end;i++){
//            if (s[i-start]==1)
//                continue;
//            else s[i-start]=1;
//            for (int j=i+1;j<=end;j++){
//                if (judgeequal(strs[i],strs[j])){
//                    s[j-start]=1;
//                    count++;
//                    if (count>1){
//                        if (count==2&&s[i]==1)
//                            res.add(strs[i]);
//                        if (s[j]==1)
//                            res.add(strs[j]);
//                    }
//                }
//            }
//            if (count>1)
//                count=1;
//            else s[i-start]=0;
//        }
//    }
//
////    判断两个字符串是否包含相同字母
//    private boolean judgeequal(String s1,String s2){
//
//        for (int i=0;i<s1.length();i++){
//            boolean flag=false;
//            for (int j=0;j<s2.length();j++){
//                if (s1.charAt(i)==s2.charAt(j)){
//                    flag=true;
//                    break;
//                }
//            }
//            if (flag==false)
//                return false;
//        }
//        return true;
//    }

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s:strs) {
            String key = sortString(s);
            if( ! map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        for (String s:map.keySet()) {
            ArrayList<String> list = map.get(s);
            if(list.size() > 1) result.addAll(list);
        }
            return result;
    }

            public String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args){
        T101 t=new T101();
        String[] strs=new String[2];
        strs[0]="";
        strs[1]="a";
//        strs[2]="inlt";
//        strs[3]="code";

        ArrayList<String> res=t.anagrams(strs);
        for (String s:res)
            System.out.print(s+",");

    }
}
