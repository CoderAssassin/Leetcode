import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:41 18-7-13
 * clone-graph：二刷
 **/
public class T18_again {

    static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null)
            return null;

        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();//记录访问过旧节点-新节点映射
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
        map.put(node,newNode);

        while (!queue.isEmpty()){
            UndirectedGraphNode tmp=queue.poll();
            for (UndirectedGraphNode neighbor:tmp.neighbors){
                if (!map.containsKey(neighbor)){
                    queue.add(neighbor);
                    UndirectedGraphNode newNeighbor=new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,newNeighbor);
                }
                map.get(tmp).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    public static void main(String[] args){
        T18_again t=new T18_again();
        UndirectedGraphNode first=new UndirectedGraphNode(0);
        UndirectedGraphNode second=new UndirectedGraphNode(1);
        UndirectedGraphNode third=new UndirectedGraphNode(2);
        first.neighbors.add(second);
        first.neighbors.add(third);
        second.neighbors.add(third);
        third.neighbors.add(third);

        UndirectedGraphNode res=t.cloneGraph(first);
        System.out.println(1);
    }
}
