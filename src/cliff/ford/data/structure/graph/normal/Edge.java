package cliff.ford.data.structure.graph.normal;

/**
 * 图的边
 * @author Cliff_Ford
 */
public class Edge {
    Vector leftNode;
    Vector rightNode;
    Edge(Vector leftNode, Vector rightNode){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
