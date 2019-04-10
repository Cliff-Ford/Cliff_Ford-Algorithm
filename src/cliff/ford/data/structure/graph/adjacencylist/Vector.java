package cliff.ford.data.structure.graph.adjacencylist;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接列表的顶点
 * reachAbleNodes 为该顶点可到达的邻接点
 * @author Cliff_Ford
 */
public class Vector {
    public Integer key;
    public List<Vector> reachAbleNodes = new ArrayList<>();
    Vector(Integer key){
        this.key = key;
    }
}
