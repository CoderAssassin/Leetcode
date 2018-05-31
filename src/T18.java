import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author aliyang
 * @date 18-5-31 下午2:57
 * clone-graph：别人解法
 * 思路一：BFS解法
 */
public class T18 {

    static class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null)
            return null;

//        记录访问过的节点，防止重复访问，关键在于存储旧-新节点对应，可以很快找到新节点建立连接
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm=new HashMap<>();
        LinkedList<UndirectedGraphNode> queue=new LinkedList<>();//队列保存BFS节点
        UndirectedGraphNode head=new UndirectedGraphNode(node.label);//新的图

        hm.put(node,head);
        queue.add(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode curnode=queue.poll();
            for (UndirectedGraphNode neighbor:curnode.neighbors){
                if (!hm.containsKey(neighbor)){//如果当前哈希表没有该节点，说明该节点没有访问过
                    queue.add(neighbor);//添加到队列
                    UndirectedGraphNode newneighbor=new UndirectedGraphNode(neighbor.label);
                    hm.put(neighbor,newneighbor);
                }
                hm.get(curnode).neighbors.add(hm.get(neighbor));//更新当前节点的邻接节点列表
            }
        }
        return head;
    }
}
