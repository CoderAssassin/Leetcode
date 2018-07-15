import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:50 18-7-15
 * word-ladder：二刷
 **/
public class T25_again {

    public int ladderLength(String start, String end, HashSet<String> dict) {

        HashSet<String> visited=new HashSet<>();//访问过的单词
        HashSet<String> words=new HashSet<>(dict);//所有的单词列表
        int len=1;
        visited.add(start);

//        bfs
        while (!visited.contains(end)){
            HashSet<String> nextLevel=new HashSet<>();//下一层
            for (String word:visited){
                for (int i=0;i<word.length();i++){//每一位更换为26个字母中的一个，时间复杂度26n
                    char[] arr=word.toCharArray();
                    for (int j=(int)'a';j<(int)'z'+1;j++){
                        arr[i]=(char)j;
                        String str=new String(arr);
                        if (words.contains(str)){
                            nextLevel.add(str);
                            words.remove(str);
                        }
                    }
                }
            }
            len+=1;
            if (nextLevel.size()==0)
                return 0;
            visited=nextLevel;
        }
        return len;
    }

    public static void main(String[] args){
        T25_again t=new T25_again();
        String start="hit",end="cog";
        HashSet<String> dict=new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(t.ladderLength(start,end,dict));
    }

}
