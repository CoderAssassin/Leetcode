import java.util.*;

/**
 * @author aliyang
 * @date 18-6-1 下午7:51
 * word-ladder-ii：别人解法
 * 这题
 */
public class T24 {



    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Map<String,Set<String>> next=new HashMap<>();//记录一个单词可能的下一个单词
        Set<String> covered=new HashSet<>();//当前已经访问过的单词
        Queue<String> queue=new LinkedList<>();//BFS用到的队列
        boolean found=false;//判断是否已经找到

        next.put(end,new HashSet<>());
        covered.add(end);//先插入end单词
        ((LinkedList<String>) queue).push(end);//结尾先入队，从后往前搜

        while (!queue.isEmpty()&&!found){
            Set<String> rset=new HashSet<>();
            Queue<String> rqueue=new LinkedList<>();

            while (!queue.isEmpty()){
                String curr=queue.poll();
//                若当前单词和start单词只差一个字母，那么可以结束
                if (adjacentp(curr,start)) {
                    found = true;
                    if (!next.containsKey(start)) {
                        Set<String> tmp = new HashSet<>();
                        tmp.add(curr);
                        next.put(start, tmp);
                    } else {
                        next.get(start).add(curr);
                    }
                    continue;
                }

//                判断每一位和26个字母更换后的单词是否和curr单词有关联
                for (int i=curr.length()-1;i>=0;i--){
                    for (int j=0;j<26;j++){
                        String prev=curr;
                        prev.replace(prev.charAt(i),(char)('a'+j));
//                        如果prev之前没有被访问过
                        if (!covered.contains(prev)&&dict.contains(prev)){
                            if (!next.containsKey(prev)) {
                                Set<String> tmp = new HashSet<>();
                                tmp.add(curr);
                                next.put(start, tmp);
                            } else {
                                next.get(start).add(curr);
                            }

                        }

                    }

                }


            }

        }

    }
}
