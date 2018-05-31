import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author aliyang
 * @date 18-5-31 下午3:29
 * clone-graph：别人解法
 * 思路：DFS
 */
public class T18_1 {

    static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node==null)
            return null;

//        记录访问过的节点，防止重复访问，关键在于存储旧-新节点对应，可以很快找到新节点建立连接
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm=new HashMap<>();
        UndirectedGraphNode head=new UndirectedGraphNode(node.label);//新的图
        hm.put(node,head);

        DFS(hm,node);
        return head;
    }

    public void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node){

        if (node==null)
            return;

        for (UndirectedGraphNode neighbor:node.neighbors){
            if (!hm.containsKey(neighbor)){//如果该neighbor没有访问过
                UndirectedGraphNode newNeighbor=new UndirectedGraphNode(neighbor.label);
                hm.put(neighbor,newNeighbor);
                DFS(hm,neighbor);
            }
            hm.get(node).neighbors.add(hm.get(neighbor));//新的节点的邻接节点的添加
        }

    }

}
