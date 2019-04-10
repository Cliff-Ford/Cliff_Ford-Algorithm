package cliff.ford.data.structure.graph.adjacencylist;


import org.junit.Test;

/**
 * 邻接列表形式的图
 * @author Cliff_Ford
 */
public class AdjacencyListGraphTest {
    @Test
    public void test(){
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addVector(1);
        graph.addVector(2);
        graph.addVector(3);
        graph.addVector(4);
        graph.addVector(5);
        graph.check();
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(2,5);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.check();
        graph.deleteVector(2);
        graph.check();
        graph.deleteVector(1);
        graph.change(3,6);
        graph.check();
        graph.deleteVector(4);
        graph.deleteVector(5);
        graph.deleteVector(6);
    }
}
